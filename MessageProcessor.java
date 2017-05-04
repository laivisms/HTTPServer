
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
/**
 * MessageProcessor runnable class, part of the HTTPServer program. An instance of this class is created with references to 
 * 				a connected socket, the server's filelocking system, and the server's cache, then fed into a thread and executed
 * 				by the server. This class then reads the bytes from the client through the socket, retrying TIMEOUT times
 * 				on an empty message before timing out, sleeping 10 milliseconds before each retry. Once a message is waiting 
 * 				in the socket, the bytes are read into an arraylist one by one (in case they are being transfered to the socket
 * 				slowly), the arraylist is converted to a byte array, and then a string. Then, inside the parseMessage method,
 * 				 an antlr tree is created from this message, its header is determined, and the necessary information is fed
 * 				into the appropriate HEADER handler (get, head, post, put, delete). The handler returns the response message,
 * 				the response message is converted to bytes, fed into the socket, and the connection is flushed, then closed.
 * 
 * @author Laivi Malamut-Salvaggio
 *
 */
public class MessageProcessor implements Runnable{
	
	private static final int TIMEOUT = 10;
	private static final String CLRF = "\r\n";
	private Socket clientSocket = null;
	private FileLocks locks;
	private Cache cache;
	//private Logger log;
	
	public MessageProcessor(Socket client, FileLocks locks, Cache cache){
		clientSocket = client;
		this.locks = locks;
		this.cache = cache;
	//	this.log = log;
	}
	@Override
	public void run() {
		DataOutputStream out;
		try {
			
		                   
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
           
            ArrayList<Byte> byteMessage = new ArrayList<Byte>();
            
    
            byte[] result = (StatusCodes.S408 + CLRF + CLRF).getBytes();//assume the connection will time-out
           
            int attempt = 0;
            
            while(in.available() == 0){
            	attempt++;
            	Thread.sleep(10);
            	if(attempt > TIMEOUT) break;
            }
            
            if(in.available() != 0){// message exists in socket
                	
	            while (in.available() > 0) {
	                byteMessage.add(in.readByte());
	            }
	            
	            Byte[] Bytes = new Byte[byteMessage.size()];
	            
	            
	            Bytes = byteMessage.toArray(Bytes);
	            
	            byte[] bytes = new byte[byteMessage.size()];
	            int i=0;
	            for (Byte b : Bytes){
	            	bytes[i] = b;
	            	i++;
	            }
	            
	            String fullMessage = new String(bytes);
	            
	            System.out.println(fullMessage);
	            
	            result = parseMessage(fullMessage);
            }
            out = new DataOutputStream(clientSocket.getOutputStream());
            out.write(result);
            out.flush();
            
            clientSocket.close();
            
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	private byte[] parseMessage(String message){
		 byte[] returnMessage = StatusCodes.S501.getBytes();
		try{
	        ANTLRInputStream input = new ANTLRInputStream(message);
	
	        HTTPMessageLexer lexer = new HTTPMessageLexer(input);
	
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        HTTPMessageParser parser = new HTTPMessageParser(tokens);
	       
	        ParseTree tree = parser.message(); // begin parsing at rule 'message'
        
	        String path = tree.getChild(0).getChild(2).getText();
	        
	        HashMap<String, String> headerFields = parseHeaders(tree);
	        
	        if(!headerFields.containsKey("Host")){
	        	return StatusCodes.S400.getBytes();
	        }
	        
	        String host = headerFields.get("Host");
	      
	        String method = tree.getChild(0).getChild(0).getText();
       
        
	        if(method.equals("GET") || method.equals("HEAD")){
	        	boolean head = false;
	        	if(method.equals("HEAD")){
	        		head = true;
	        	}
	        	returnMessage = GetHandler.handleGet(host, message, path, locks, headerFields, cache, head);
	        }
	        else if(method.equals("PUT")){
	        	//log.start(message);
	        	returnMessage = PutHandler.handlePut(host, message, tree, locks, headerFields, cache);
	        	
	        }
	        
	        else if(method.equals("POST")){
	        //	log.start(message);
	        	returnMessage = PostHandler.handlePost(host, message, tree, locks, headerFields, cache);
	        	
	        }
	        
	        else if(method.equals("DELETE")){
	        	//log.start(message);
	        	returnMessage = DeleteHandler.handleDelete(host, message, path, locks, headerFields, cache);
	        	
	        }
	       
        } catch(ErrorException e){
        	return e.getMessage().getBytes();
        }
        
        return returnMessage;
        
        
        
	}
	
	private static HashMap<String,String> parseHeaders(ParseTree tree){
		HashMap<String, String> headerFields = new HashMap<String, String>();
		if(tree.getChildCount() >= 2 && tree.getChild(1) instanceof HTTPMessageParser.HeaderFieldsContext
				&& tree.getChild(1).getChildCount()>0){// if the message contains header fields
			ParseTree fields = tree.getChild(1);
			String name = "";
			String contents = "";
			for(int i=0;i<fields.getChildCount(); i+=2){
				name = fields.getChild(i).getChild(0).getText();
				contents = fields.getChild(i).getChild(3).getText();
				headerFields.put(name, contents);
			}
		}
		
		return headerFields;
	}
	


}
