import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;


public class TestClient {
	private static final int PORT = 2017;
	private static final String HOSTIP = "127.0.0.1";
	
	public static void main(String args[]){
		
		try {
			InetAddress serverAddr = InetAddress.getByName(HOSTIP);
			
			Socket server = new Socket(serverAddr, PORT);
			
			DataOutputStream out = new DataOutputStream(server.getOutputStream());
            
            String fromServer = "";
            byte[] fromClient = getFile("testMessage.txt").getBytes();
            
            out.write(fromClient);
            out.flush();
            server.shutdownOutput();
            
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(server.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                fromServer += inputLine + "\r\n";
            }
           
            
            System.out.println(fromServer);
            
            server.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
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
