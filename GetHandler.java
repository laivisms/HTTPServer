import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

/**
 * The GetHandler class, part of the HTTPServer program. This class uses only static methods. When the MessageProcessor receieves
 * 				a GET request, it feeds the target of the request, a reference to the server's locking system, a map of all the header
 * 				fields from the message and their contents, and a reference to the server's cache into the handleGet method.
 * 				This method first maps the target to where the actual resource should be in the computer's file system using the 
 * 				PathFormatter class's formatPath method, locks that location, then checks if any file is present there.
 * 				if no file is present, the location is unlocked, the lock deleted, and a 404 error thrown. If a file is present
 * 				in the mapped location, an attempt is made to retrieve the file's contents from the cache. If the cache returns 
 * 				null, the bytes are retrieved from the file itself, stored in the cache, and returned to the messageProcessor,
 * 				preceded by the correct header. 
 * 
 * @author Laivi Malamut-Salvaggio
 *
 */

public class GetHandler {
	
	private static final String CLRF = "\r\n";
	
	public static byte[] handleGet(String host, String message, String path, FileLocks locks, HashMap<String,String> fields, Cache cache,boolean head) throws ErrorException{
		
		try {
			String resultPath = PathFormatter.formatPath(path, fields);
			File resource = new File(resultPath);
			
			
			locks.readLockFile(resource.getAbsolutePath());
			
			if(!resource.exists()){
				locks.readUnlockFile(resource.getAbsolutePath());
				locks.deleteLock(resource.getAbsolutePath());
				throw new ErrorException(StatusCodes.S404);
			}
			
			byte[] fileContents = cache.getResponse(resource.getAbsolutePath());
			if(fileContents == null){//if it was not in cache
				fileContents = getResource(resultPath);
				cache.encache(message, resource.getAbsolutePath(), fileContents);
			}
			
			String headers = StatusCodes.S200 + CLRF
							+"Content-Length: " +  fileContents.length + CLRF
							+"Date: " + getTime() + CLRF
							+"Location: " + "http://" + host + path + CLRF
							+ CLRF;
			byte[] result;
			if(head){
				result = headers.getBytes();
			}
			else{
				result = concat((headers).getBytes(), fileContents);
			}
			
			
			
			locks.readUnlockFile(resource.getAbsolutePath());
				
			
			return result;
				
		} catch (IOException e) {
			throw new ErrorException(StatusCodes.S500);
		}
	}
	
	private static byte[] getResource(String target) throws IOException {
		File file = new File(target);
		FileInputStream reader = new FileInputStream(file);
		byte[] contents = new byte[(int) file.length()];
	    try {
	        
	        reader.read(contents);

	    } finally {
	        reader.close();
	    }
	    return contents;
	}
	
	private static byte[] concat(byte[] a, byte[] b){
		int length = a.length + b.length;
		byte[] result = new byte[length];
		System.arraycopy(a, 0, result, 0, a.length);
		System.arraycopy(b, 0, result, a.length, b.length);
		return result;
	}
	
	private static String getTime() {
	    SimpleDateFormat dForm = new SimpleDateFormat( "EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
	    dForm.setTimeZone(TimeZone.getTimeZone("GMT"));
	    Calendar cr = Calendar.getInstance();
	    return dForm.format(cr.getTime());
	}
	
}