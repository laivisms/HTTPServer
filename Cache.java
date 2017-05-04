import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * The Cache class, part of the HTTPServer program. Acts as a cache for the program. A new instance is created when the server
 * 					is started, and a reference to this instance is given to every thread. The actual cache elements are referenced
 * 					in both a hashMap and a queue: the hashMap allows quick and easy access to a requested cache element, while
 * 					the queue retains the order of the pushed elements, ensuring the ability to remove an element and
 * 					write it through to the file system when the cache reaches its limit. Elements in the cache are composed 
 * 					of a 3-tuple, containing: the directory of the resource, the contents of the resource (in bytes), and the placement
 * 					of that resource in the array which is the queue. 
 * @author SL
 *
 */

public class Cache {
	
	private static final int FLUSH_INTERVAL = 5000;// how often to flush the cache
	private Element[] queue;
	private ConcurrentHashMap<String, Element> cache;
	private int head = 1;
	private int tail = 0;
	private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
	private int size;
	private ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
	FileLocks locks;
	//Logger log;
	
	public Cache(int size, FileLocks locks){
		queue = new Element[size];
		cache = new ConcurrentHashMap<String, Element>(size + 2);
		this.size = size;
		this.locks = locks;
		//this.log = log;
		//scheduler.execute(new CacheFlusher(FLUSH_INTERVAL, this));
	}
	/**
	 * flushes the contents of the cache to disk, clears cache
	 * @throws ErrorException 
	 */
	public void flush() throws ErrorException{
		cacheLock.writeLock().lock();
		
		while (tail != head -1 && (head !=0 || tail + 1 != size)){
			tail++;
			if(tail == size){
				tail = 0;
			}
			writeThrough(queue[tail]);
		}
		
		cache.clear();
		tail = 0;
		head = 1;
		
		cacheLock.writeLock().unlock();
	}
	
	/**
	 * Locks the cache, creates a new element with the inputted info, then stores the element in the queue
	 * 
	 * @param target the absolute file path of the resource
	 * @param payload the contents of the resource to be cached
	 * @throws ErrorException throws 500 if the writeThrough method has an IO exception
	 */
	public void encache(String message, String target, byte[] payload) throws ErrorException{
		
		cacheLock.writeLock().lock();
		
		Element temp = new Element(message, target, payload, head);
		queue[head] = temp;
		cache.put(target, temp);
		head++;
		if(head == size){
			head = 0;
		}
		if (head == tail){
			if(queue[tail] != null && cache.containsKey(queue[tail].target)){//it couldve been deleted in the meantime
				writeThrough(queue[tail]);
				cache.remove(queue[tail].target);
			}
			
			tail++;
			if(tail == size){
				tail = 0;
			}
		}
		cacheLock.writeLock().unlock();
	}
	
	public byte[] getResponse(String target){
		cacheLock.readLock().lock();
		
		if(!cache.containsKey(target)){
			cacheLock.readLock().unlock();
			return null;
		}
		Element result = cache.get(target);
		int switchWith = result.placement;
		Element temp = queue[head-1];
		queue[switchWith] = temp;
		queue[head-1] = result;//now recent object is first
		result.placement = head-1;
		
		cacheLock.readLock().unlock();
		
		return result.payload;
		
	}
	
	public void deleteResponse(String target){
		
		cacheLock.writeLock().lock();
		
		if(cache.containsKey(target)){
			cache.remove(target);
		}
		
		cacheLock.writeLock().unlock();
	}
	
	public boolean replacePayload(String target, byte[] payload){
		cacheLock.writeLock().lock();
		
		if(!cache.containsKey(target)){
			
			cacheLock.writeLock().unlock();
			
			return false;
		}
		cache.get(target).payload = payload;
		
		cacheLock.writeLock().unlock();
		
		return true;
	}
	
	public boolean appendPayload(String target, byte[] appendage){
		cacheLock.writeLock().lock();
		
		if(!cache.containsKey(target)){
			
			cacheLock.writeLock().unlock();
			
			return false;
		}
		Element temp = cache.get(target);
		temp.payload = concat(temp.payload, appendage);
		
		cacheLock.writeLock().unlock();
		
		return true;
	}
	
	private void writeThrough(Element element) throws ErrorException{
		File oldFile = new File(element.target);
		locks.writeLockFile(oldFile.getAbsolutePath());
		
		if(oldFile.exists()){
			String newFileName = element.target + "-backup";
			File backup = new File(newFileName);
			
			
			try {
				backup.createNewFile();
				
				//Files.copy(Paths.get(oldFile.getAbsolutePath()), new FileOutputStream(backup.getAbsolutePath()));
				
				//log.modify(element.message, element.target, backup.getAbsolutePath());//modification is about to begin
				
				oldFile.delete();
				oldFile.createNewFile();
				PrintWriter pw = new PrintWriter(oldFile);
				String toWrite = new String(element.payload);
				pw.write(toWrite);
				pw.close();
				
				//log.commit(element.message);
				
			} catch (IOException e) {
				File tempFile = new File(newFileName);
				tempFile.delete();
				locks.writeUnlockFile(oldFile.getAbsolutePath());
				throw new ErrorException(StatusCodes.S500);
			}
			
		}
		locks.writeUnlockFile(oldFile.getAbsolutePath());
		//else, the file was deleted, so do nothing
	}
	
	private static byte[] concat(byte[] a, byte[] b){
		int length = a.length + b.length;
		byte[] result = new byte[length];
		System.arraycopy(a, 0, result, 0, a.length);
		System.arraycopy(b, 0, result, a.length, b.length);
		return result;
	}
	
	class Element{
		String message;
		String target;
		byte[] payload;
		int placement;
		public Element(String message, String target, byte[] payload, int placement){
			this.message = message;
			this.target = target;
			this.payload = payload;
			this.placement = placement;
		}
		
	}
	
	class CacheFlusher implements Runnable{
		
		private int interval;
		private Cache cache;
		
		public CacheFlusher(int interval, Cache cache){
			this.interval = interval;
			this.cache = cache;
		}
		
		@Override
		public void run() {
			try {
				while(true){
					
					Thread.sleep(interval);
					cache.flush();
					
				}
			} catch (InterruptedException | ErrorException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}
}
