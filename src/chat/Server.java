/**
 * Chat
 * @author Ethan Brown
 * CS 3230
 * Mar 1, 2017
 */
package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author Ethan
 *
 */
public class Server implements Runnable{
	private ArrayList<String> users;
	private int port = 8090;
	/**
	 * 
	 */
	public Server() throws IOException {

		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		new Thread(new Server()).start();
		
	}

	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(port);
			System.out.println("waiting on connection on port: " + port);
			
			
			try {
				while (true) {
					Socket s = ss.accept();
					ServerHandler sh = new ServerHandler(s);
					System.out.println("Client Connected");
					new Thread(sh).start();
				}
			} finally {
				ss.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
