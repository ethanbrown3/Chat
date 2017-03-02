/**
 * Chat
 * @author Ethan Brown
 * CS 3230
 * Mar 1, 2017
 */
package chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Ethan
 *
 */
public class ServerHandler implements Runnable {
	private Socket socket;
	private InputStream input;
	private OutputStream output;
	
	/**
	 * 
	 */
	public ServerHandler(Socket s) throws IOException {
		socket = s;
		input = s.getInputStream();
		output = s.getOutputStream();
	}

	@Override
	public void run() {
		
	}

}
