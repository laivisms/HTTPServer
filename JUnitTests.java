import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

import org.junit.Test;

public class JUnitTests {
	private static final int PORT = 2017;
	private static final String HOSTIP = "127.0.0.1";
	/*
	 * Keep in mind that, since the cache is not write-through, the puts/posts may not go through immediately-
	 * they could be written to the cache, and only written to disk when cache is flushed
	 */
	@Test
	public void getTest(){
		
		String result = messageServer("tests\\getTest.txt");
		
		System.out.println("GET returned:\n" + result);
	}
	@Test
	public void headTest(){
		
		String result = messageServer("tests\\headTest.txt");
		System.out.println("HEAD returned:\n" + result);
	}
	
	@Test
	public void putTest(){
		
		String result = messageServer("tests\\putTest.txt");
		System.out.println("PUT returned:\n" + result);
	}
	
	@Test
	public void postTest(){
		
		String result = messageServer("tests\\postTest.txt");
		System.out.println("POST returned:\n" + result);
	}
	
	@Test
	public void deleteTest(){
		System.out.println(messageServer("tests\\putDeleteTest.txt"));
		String result = messageServer("tests\\deleteTest.txt");
		System.out.println("DELETE returned:\n" + result);
	}
	
	private static String messageServer(String dir){
		String fromServer = "";
		try {
			InetAddress serverAddr = InetAddress.getByName(HOSTIP);
			
			Socket server = new Socket(serverAddr, PORT);
			
			DataOutputStream out = new DataOutputStream(server.getOutputStream());
            
            byte[] fromClient = getFile(dir).getBytes();
            
            out.write(fromClient);
            out.flush();
            server.shutdownOutput();
            
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(server.getInputStream()));
            String inputLine = "";
            while (inputLine != null) {
                fromServer += inputLine + "\r\n";
                inputLine = in.readLine();
            }
           
            server.close();
            
            
           
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return (fromServer);
		
	}
	
	private static String getFile(String fileName) throws IOException {
	    BufferedReader reader = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder builder = new StringBuilder();
	        String line = reader.readLine();

	        while (line != null) {
	            builder.append(line);
	            line = reader.readLine();
	            if(line!=null)
	            	builder.append("\r\n");
	        }
	        return builder.toString();
	    } finally {
	        reader.close();
	    }
	}
}
