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
import java.io.PrintWriter;
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
		String userName = JOptionPane.showInputDialog("Enter Username");
		// socket setup
		int portNumber = 8090;
		String str = "initilized";
		Socket socket1;
		ChatWindow window;
		BufferedReader input;
		PrintWriter output;

		try {
			socket1 = new Socket(InetAddress.getByName(ipAddress), portNumber);
		} catch (Exception ex) {
			System.out.println("Connection failed, starting new server at " + InetAddress.getLocalHost());
			new Thread(new Server()).start();
			socket1 = new Socket(InetAddress.getLocalHost(), portNumber);
		}
		
		input = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
		output = new PrintWriter(socket1.getOutputStream(), true);
		output.println(userName);
		
		if (input.readLine() != "ACK") {
			new Thread(new Server()).start();
			socket1 = new Socket(InetAddress.getLocalHost(), portNumber);
			input = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
			window = new ChatWindow(socket1, userName);
		} else {
			window = new ChatWindow(socket1, userName);
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
