import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

import org.antlr.v4.runtime.tree.ParseTree;


/**
 * The PutHandler class, part of the HTTPServer program. This class uses only static methods. When the MessageProcessor receieves
 * 				a PUT request, it feeds the antlr tree of the request, a reference to the server's locking system, a map of all the header
 * 				fields from the message and their contents, and a reference to the server's cache into the handlePut method. The 
 * 				putHandler method first retrieves the requested path from the parseTree, then maps that path to a directory 
 * 				in the computer using PathFormatter's formatPath method. Then, if there is a payload (if not return 400 error)
 * 				the old file is marked for a deletion. If the file is in cache, the contents of the cache are replaced, and the
 * 				will write them to disk when that entry is flushed. If the file is not in cache, a new file 
 * 				(named the same as the old file, except with -temp appended to the name) is created, and the payload
 * 				 written into it. The old file is then deleted, and the new file renamed to the old file. 201 is returned
 * 				if a new file was created, 204 if it was overwritten.
 * 
 * @author Laivi Malamut-Salvaggio
 *
 */
public class PutHandler {
	private static final String CLRF = "\r\n";
	public static byte[] handlePut(String host, String message, ParseTree tree, FileLocks locks, HashMap<String, String> fields, Cache cache) throws ErrorException{

		String path = tree.getChild(0).getChild(2).getText();
		
		String target = PathFormatter.newPath(path, fields);		
		boolean delete = false;
		
		String returnMessage = "";
		
		if(tree.getChild(0).getChildCount() < 3){
			throw new ErrorException(StatusCodes.S400);
		}
		
		String payload = tree.getChild(2).getChild(1).getText();
		//replace file, send 201 (created) if no file exists, or 204 if it did
		
		File oldFile = new File(target);
		if(oldFile.exists()){
			returnMessage = StatusCodes.S204;
			delete = true;
		}
		else{
			returnMessage = StatusCodes.S201;
		}
		
		String tempAddition = "-temp.txt";
		
		String newFileName = target + tempAddition;
		
		
		
		locks.writeLockFile(oldFile.getAbsolutePath());

		locks.writeLockFile(oldFile.getAbsolutePath() + tempAddition);//locks the temp file that doesnt exist yet, just in case
		
		boolean isInCache = cache.replacePayload(oldFile.getAbsolutePath(), payload.getBytes());
		
		File backup = new File(oldFile.getAbsolutePath() + "-backup");
		
		if(!isInCache){// if it was in cache, the contents have been overwritten and will be written through when leaves cache.
			try {
				File.createTempFile(newFileName, "");
				Writer writer = new BufferedWriter(new OutputStreamWriter(
				          new FileOutputStream(newFileName), "utf-8"));
				writer.write(payload);
				writer.close();
				
			} catch (IOException e) {
				File tempFile = new File(newFileName);
				tempFile.delete();
				throw new ErrorException(StatusCodes.S500);
			}
			
			File newFile = new File(newFileName);
			String oldFilePath = oldFile.getAbsolutePath();
			if(delete){
				//log.modify(message, oldFile.getAbsolutePath(), backup.getAbsolutePath());
				oldFile.renameTo(backup);
			}
			
			newFile.renameTo(new File(oldFilePath));
		}
		
		
		locks.writeUnlockFile(oldFile.getAbsolutePath());
		locks.writeUnlockFile(oldFile.getAbsolutePath() + tempAddition);
		locks.deleteLock(oldFile.getAbsolutePath() + tempAddition);
		
		
		
		if(!isInCache){//only commit if it was written to filesystem,, not to cache. Cache will commit when flushed
			//log.commit(message);
			backup.delete();
		}
		returnMessage = returnMessage + CLRF
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
