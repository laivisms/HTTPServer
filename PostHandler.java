import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

import org.antlr.v4.runtime.tree.ParseTree;
/**
 * The PostHandler class, part of the HTTPServer program. This class uses only static methods. When the MessageProcessor receieves
 * 				a POST request, it feeds the Antlr tree of the request, a reference to the server's locking system, a map of all the header
 * 				fields from the message and their contents, and a reference to the server's cache into the handlePost method.
 * 				It first separates the path of the url from the tree, then maps it to the corresponding location on the computer
 * 				where that resource should be located, using PathFormatter's formatPath method. If that method throws a 404,
 * 				the file must first be created, so the putHandler is called instead. The location is then locked, and it is 
 * 				ensured that the file still exists after locking. then checks for a payload, throws a 400 status code if no payload.
 * 				Tries to append the payload to the file in cache. If file not present in cache, append to file in directory, and return
 * 				200 status code
 * 
 * @author Laivi Malamut-Salvaggio
 *
 */
public class PostHandler {
	private static final String CLRF = "\r\n";
	
	public static byte[] handlePost(String host, String message, ParseTree tree, FileLocks locks, HashMap<String, String> fields, Cache cache) throws ErrorException{
		String path = tree.getChild(0).getChild(2).getText();
		String target = "";
		try{
			target = PathFormatter.formatPath(path, fields);
		} catch(ErrorException e){
			if(e.getMessage().equals(StatusCodes.S400)){
				throw e;
			}else{//it was a 404 error, need to create the file first with the putHandler
				return PutHandler.handlePut(host, message, tree, locks, fields, cache);
			}
		}
		File file = new File(target);
		
		locks.writeLockFile(file.getAbsolutePath());
		
		if(!file.exists()){
			return PutHandler.handlePut(host, message, tree, locks, fields, cache);
		}
		
		if(tree.getChildCount() != 3 || !(tree.getChild(2) instanceof HTTPMessageParser.ContentsContext)){ //no payload
			throw new ErrorException(StatusCodes.S400);
		}
		
		String payload = tree.getChild(2).getChild(1).getText();
		BufferedWriter bw = null;
		FileWriter fw = null;
		File backup = new File(file.getAbsolutePath() + "-backup");
		
		boolean isInCache = cache.appendPayload(file.getAbsolutePath(), payload.getBytes());
		
		if(!isInCache){// if not in cache, write to actual file
		
			try {
				backup.createNewFile();
				Files.copy(Paths.get(file.getAbsolutePath()),new FileOutputStream(backup.getAbsolutePath()));
				
			//	log.modify(message, file.getAbsolutePath(), backup.getAbsolutePath());//backup has been created
				
				fw = new FileWriter(file.getAbsoluteFile(), true);
				bw = new BufferedWriter(fw);
				
				bw.write(payload);
				
				bw.close();
			} catch (IOException e) {
				locks.writeUnlockFile(path);
				throw new ErrorException(StatusCodes.S500);
			}
		}
		
		locks.writeUnlockFile(file.getAbsolutePath());
		
		if(isInCache){
			//log.commit(message);
			backup.delete();
		}
		
		String returnMessage = StatusCodes.S200 + CLRF
								+"Date: " + getTime() + CLRF
								+"Location: " + "http://" + host + path + CLRF
								+ CLRF;
		return returnMessage.getBytes();
		
	}
	
	private static String getTime() {
	    SimpleDateFormat dForm = new SimpleDateFormat( "EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
	    dForm.setTimeZone(TimeZone.getTimeZone("GMT"));
	    Calendar cr = Calendar.getInstance();
	    return dForm.format(cr.getTime());
	}
}
