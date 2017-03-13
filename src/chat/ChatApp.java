/**
 * Chat
 * @author Ethan Brown
 * CS 3230
 * Jan 24, 2017
 */
package chat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

/**
 * The Class ChatApp.
 *
 * @author Ethan
 */
public class ChatApp {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		Set<Student> students = new HashSet<>();

		// String arrays of chat transcripts
		String[] testChats = { "Hello", "How's it goin'?", "good", "ok bye" };
		String[] testChats2 = { "Waaazzzzuuup!?", "great, you?", "great", "see you later", "bye bye" };

		BufferedReader reader = new BufferedReader(new FileReader("src/chat/studentNames.csv"));
		String line;

		// while loop that creates new students and adds them to students set
		while ((line = reader.readLine()) != null) {
			String[] name = line.split(",");
			students.add(new Student(name[0], name[1], testChats));
		}
		reader.close();

		ArrayList<Student> studentList = new ArrayList<Student>(students);
		studentList.sort(null);

		System.out.println(studentList);
		ArrayList<Group> groups = new ArrayList<>();

		// fill the ArrayList groups with new groups of students
		for (int i = 0; i < students.size(); i++) {
			studentList.get(i + 1).setChats(testChats2);
			groups.add(new Group(studentList.get(i), studentList.get(++i)));
		}
		groups.sort(null);

		String ipAddress = JOptionPane.showInputDialog("Enter Server IP Address");

		// socket setup
		final int PORT_NUMBER = 8090;
		String str;
		Socket socket1;
		ChatWindow window;
		BufferedReader input;
		boolean newServer = false;
		
		try {
			socket1 = new Socket(InetAddress.getByName(ipAddress), PORT_NUMBER); //if I enter a valid ip address but it isn't a server it hangs here without throwing an exception
		} catch (IOException ex) {
			System.out.println("Connection failed, starting new server at " + InetAddress.getLocalHost());
			new Thread(new Server()).start();
			newServer = true;
			socket1 = new Socket(InetAddress.getLocalHost(), PORT_NUMBER);
		}
		
		input = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
		
		if (input.readLine() != "ACK" && newServer == false) {
			new Thread(new Server()).start();
			socket1 = new Socket(InetAddress.getLocalHost(), PORT_NUMBER);
			input = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
			window = new ChatWindow(socket1);
		} else {
			window = new ChatWindow(socket1);
		}

		System.out.println(InetAddress.getLocalHost());

		// print the chat transcripts of the groups
		for (int i = 0; i < groups.size(); i++) {
			window.addText(groups.get(i).studentChats());
		}

		// handle server communication
		while ((str = input.readLine()) != null) {
			window.addText(str);
		}

	}

}
