import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Server Class - receives socket connections and transfers the connection, cache, and locks to a thread,
 * then continues to wait for more connections.
 * 
 * @author Laivi Malamut-Salvaggio
 *
 */
public class Server {
	private static final int PORTNUMBER = 2017;
	private static final int CACHE_SIZE = 5;//at least 3
	private static final int CONNECTIONS_LIMIT = 1000;
	private static final int THREAD_COUNT = 100;
	private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(THREAD_COUNT);
	private static FileLocks locks;
	private static Cache cache;
	//private static Logger log;
	
	
	public static void main(String args[]){
		locks = new FileLocks();
		//log = new Logger();
		cache = new Cache(CACHE_SIZE, locks);
		try {
			int a = 0;
			ServerSocket serverSocket = new ServerSocket(PORTNUMBER);
				do{
		            Socket clientSocket = serverSocket.accept();   
		            
		            scheduler.execute(new MessageProcessor(clientSocket, locks, cache));
		            
		            a++;
				} while(a < CONNECTIONS_LIMIT);
				serverSocket.close();
				scheduler.shutdown();
	        } catch (IOException e) {
	            System.out.println("Exception caught when trying to listen on port "
	                + PORTNUMBER + " or listening for a connection");
	            System.out.println(e.getMessage());
	        }
	}
}
