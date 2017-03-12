/**
 * Chat
 * @author Ethan Brown
 * CS 3230
 * Mar 1, 2017
 */
package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Ethan
 *
 */
public class ServerHandler implements Runnable {
	private Socket clientSocket;
	private BufferedReader input;
	private String username;

	/**
	 * 
	 */
	public ServerHandler(Socket s, String user) throws IOException {
		clientSocket = s;
		input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		username = user;
	}

	@Override
	public void run() {
		String str;
		try {
			while ((str = input.readLine()) != null) {
				Server.sendMessage(username + ": " + str);
				System.out.println("Client " + str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
