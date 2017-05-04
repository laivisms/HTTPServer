import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * The Logger class, part of the HTTPServer program. Writes log entries to stringbuilder, flushing the entries to disk after 
 * 					FLUSH_AFTER entries. Has three types of logs:
 * 
 * 					<START transaction> - This indicates that the server has recieved this transaction and is about to begin
 * 					<transaction, location, backup> (<T,L,B>) - this indicates that the server is about to begin modifying data,
 * 													  and has made a backup copy in "backup"
 * 					<COMMIT transaction> - the transaction has been fully committed to disk safely
 * 
 * 				if there appears in the log a <T,L,B> tuple before a <COMMIT>, then a transaction may have been interrupted 
 * 				during modifying data. This indicates that the server must be rolled back to B in order to ensure data
 * 				is not corrupted.
 * 
 * @author Laivi Malamut-Salvaggio
 *
 */

public class Logger {
	private static final String LOG = "log.txt";
	private static final int FLUSH_AFTER = 5;
	private StringBuilder sb = new StringBuilder();
	private ReentrantReadWriteLock sbLock = new ReentrantReadWriteLock();
	private int logCount = 0;
	
	
	public Logger(){
		
	}
	
	
	public void start(String transaction){
		sbLock.writeLock().lock();
		
		sb.append("<START " + transaction + ">\n");
		
		logCount++;
		if(logCount >= FLUSH_AFTER){
			flush();
		}
		
		sbLock.writeLock().unlock();
	}
	
	public void modify(String transaction, String location, String backup){
		sbLock.writeLock().lock();
		
		sb.append("<START " + transaction + ">\n");
		sb.append("<" + transaction + "," + location + "," + backup + ">\n");
		logCount++;
		if(logCount >= FLUSH_AFTER){
			flush();
		}
		
		sbLock.writeLock().unlock();
	}
	
	private void flush(){
		File log = new File(LOG);
		try {
			if(!log.exists()){
				
				log.createNewFile();
		}
			
			PrintWriter pw = new PrintWriter(log);
			pw.append(sb.toString());
			sb.setLength(0);
			pw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void commit(String transaction){
		sbLock.writeLock().lock();
		
		sb.append("<COMMIT " + transaction + ">\n");
		logCount++;
		if(logCount >= FLUSH_AFTER){
			flush();
		}
		
		sbLock.writeLock().unlock();
	}	
}
