import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;


/**
 * The DeleteHandler class, part of the HTTPServer program. This class uses only static methods. When the MessageProcessor receives
 * 				a DELETE request, it feeds the target of the request, a reference to the server's locking system, a map of all the header
 * 				fields from the message and their contents, and a reference to the server's cache into the handleDelete method.
 * 				the method first maps the target to the location on the computer where the requested resource should be located,
 * 				and locks that location. if the file doesnt exist, a 404 is returned. the resource is then deleted from the cache
 * 				(if it exists in cache) and deleted from the file system. the location is unlocked, the lock is deleted, and 
 * 				a 204 is returned.
 * 
 * @author Laivi Malamut-Salvaggio
 *
 */
public class DeleteHandler {
	private static final String CLRF = "\r\n";
	public static byte[] handleDelete(String host, String message, String path, FileLocks locks, HashMap<String, String> fields, Cache cache) throws ErrorException{
		String target = PathFormatter.formatPath(path, fields);
		
		File file = new File(target);
		
		locks.writeLockFile(file.getAbsolutePath());
		
		if(!file.exists()){
			locks.writeUnlockFile(file.getAbsolutePath());
			locks.deleteLock(file.getAbsolutePath());
			throw new ErrorException(StatusCodes.S404);
		}
		File backup = new File(file.getAbsolutePath() + "-backup");
		//log.modify(message, file.getAbsolutePath(), backup.getAbsolutePath());
		cache.deleteResponse(file.getAbsolutePath());
		file.renameTo(backup);
		
		locks.writeUnlockFile(file.getAbsolutePath());
		locks.deleteLock(file.getAbsolutePath());
		
		//log.commit(message);
		file.delete();//delete backup
		String returnMessage = StatusCodes.S204 + CLRF
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
