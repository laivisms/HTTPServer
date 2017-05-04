import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * The FileLocks class, part of the HTTPServer program. An instance of this class is stored in every server, and a reference
 * 				 distributed to all the threads, to ensure the sharing of the same locking system. Locks are created as needed,
 * 				with the key being the absolute path of the directory in the computer (MUST be retrieved from the
 * 				 file.getAbsolutePath() function of a location), and the value being a lock instance. Locks can be
 * 				created, locked, unlocked, and deleted from this class.
 * 
 * @author Laivi Malamut-Salvaggio
 *
 */
public class FileLocks {
	private HashMap<String,ReentrantReadWriteLock> locks = new HashMap<String,ReentrantReadWriteLock>();
	private ReentrantReadWriteLock mapLock = new ReentrantReadWriteLock();
	
	
	public FileLocks(){
		
	}
	
	
	/**
	 * creates a lock if one doesnt exist yet, then locks it
	 * @param path the absolute path of the location to be locked
	 * 
	 */
	public void writeLockFile(String path){
		
		if(!locks.containsKey(path)){
			createLock(path);
		}
		mapLock.readLock().lock();
		
		locks.get(path).writeLock().lock();
		
		mapLock.readLock().unlock();
	}
	/**
	 * unlocks lock designated by path, if exists
	 * @param path the absolute path of the location to be unlocked
	 * @return true if location contains lock and it was unlocked, false if no lock exists
	 */
	public boolean writeUnlockFile(String path){
		
		if(!locks.containsKey(path)){
			return false;
		}
		
		mapLock.readLock().lock();
		
		locks.get(path).writeLock().unlock();
		
		mapLock.readLock().unlock();
		
		return true;
	}
	
	/**
	 * creates a lock if one doesnt exist yet, then locks it
	 * @param path the absolute path of the location to be locked
	 * 
	 */
	public boolean readLockFile(String path){
	
		if(!locks.containsKey(path)){
			createLock(path);
		}
		
		mapLock.readLock().lock();
		
		locks.get(path).readLock().lock();
		
		mapLock.readLock().unlock();
		
		return true;
	}
	
	/**
	 * unlocks lock designated by path, if exists
	 * @param path the absolute path of the location to be unlocked
	 * @return true if location contains lock and it was unlocked, false if no lock exists
	 */
	public boolean readUnlockFile(String path){
		
		if(!locks.containsKey(path)){
			return false;
		}
		mapLock.readLock().lock();
		
		locks.get(path).readLock().unlock();
		
		mapLock.readLock().unlock();
		
		return true;
	}
	/**
	 * Deletes a lock from the lock map.
	 * @param path the absolute path of the directory to lock
	 * @return false if no lock exists, true if it does and has been removed
	 */
	public boolean deleteLock(String path){
		
		mapLock.writeLock().lock();
		
		if(!locks.containsKey(path)){
			mapLock.writeLock().unlock();
			return false;
		}
		
		ReentrantReadWriteLock toDelete = locks.get(path);
		toDelete.writeLock().lock();
		
		locks.remove(path);
		
		
		toDelete.writeLock().unlock();
		mapLock.writeLock().unlock();
		
		return true;
	}
	/*
	 * write-locks the whole lock map, checks if a lock has been created already,
	 * creates one if none exists, locks it, then returns the lock
	 */
	private ReentrantReadWriteLock createLock(String path){
		mapLock.writeLock().lock();
		ReentrantReadWriteLock result = null;
		if(!locks.containsKey(path)){
			locks.put(path, new ReentrantReadWriteLock());
			
		}
		result = locks.get(path);
		mapLock.writeLock().unlock();
		return result;
	}
}
