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
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author Ethan
 *
 */
public class Server implements Runnable {
	public static ArrayList<String> users;
	private final int PORT = 8090;
	private PrintWriter newOutput;
	public static ArrayList<PrintWriter> outputs;

	/**
	 * 
	 */
	public Server() throws IOException {
		users = new ArrayList<>();
		outputs = new ArrayList<>();
	}

	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(PORT);
			System.out.println("waiting on connection at address: " + InetAddress.getLocalHost() + ":" + PORT);
			try {
				while (true) {
					Socket clientSocket = ss.accept();
					BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
					newOutput = new PrintWriter(clientSocket.getOutputStream(), true);					
					System.out.println("Client Connected");
					String username;
					while (true) {
						username = input.readLine();
						if (users.contains(username) || username.isEmpty()) {
							newOutput.println("DENY");
							newOutput.flush();
							System.out.println("Server: DNY");
						} else {
							newOutput.println("ACK");
							newOutput.flush();
							users.add(username);
							System.out.println("Server: ACK");
							break;
						}
					}
					ServerHandler sh = new ServerHandler(clientSocket, username);
					outputs.add(newOutput);
					new Thread(sh).start();
					sendMessage(username + " has joined the chat");

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

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		new Thread(new Server()).start();
	}

}
