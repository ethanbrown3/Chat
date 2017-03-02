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

/**
 * @author Ethan
 *
 */
public class Server {
	
	/**
	 * 
	 */
	public Server() throws IOException {
		ServerSocket ss = new ServerSocket(8080);
		
		try {
			while (true) {
				Socket s = ss.accept();
				ServerHandler sh = new ServerHandler(s);
				
				new Thread(sh).start();
			}
		} finally {
			ss.close();
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		new Server();
		
	}
}
