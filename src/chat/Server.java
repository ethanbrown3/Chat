/**
 * Chat
 * @author Ethan Brown
 * CS 3230
 * Mar 1, 2017
 */
package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author Ethan
 *
 */
public class Server implements Runnable {
	private ArrayList<String> users;
	private int port = 8090;
	private PrintWriter newOutput;
	public static ArrayList<PrintWriter> outputs;

	/**
	 * 
	 */
	public Server() throws IOException {
		users = new ArrayList<>();
		outputs = new ArrayList<>();
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
			String newUser;
			try {
				while (true) {
					Socket clientSocket = ss.accept();
					BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
					newOutput = new PrintWriter(clientSocket.getOutputStream(), true);
					newUser = input.readLine();
					if (users.contains(newUser)) {
						newOutput.println("DENY");
						clientSocket.close();
					} else {
						users.add(newUser);
						ServerHandler sh = new ServerHandler(clientSocket);
						System.out.println("Client Connected");
						newOutput.println("ACK");
						outputs.add(newOutput);
						new Thread(sh).start();
					}	
				}
			} finally {
				ss.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void sendMessage(String message) {
		for (PrintWriter p : outputs) {
			p.println(message);
			p.flush();
		}
	}

}
