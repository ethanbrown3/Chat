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
import java.util.Scanner;
import java.util.Set;

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

		

		// socket setup
		int portNumber = 8090;
		String str = "initilized";
		Socket socket1 = new Socket(InetAddress.getLocalHost(), portNumber);
//		BufferedReader br = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
//		PrintWriter pw = new PrintWriter(socket1.getOutputStream(), true);
//		Scanner keyboard = new Scanner(System.in);
//		//pw.println(str);
//
//		while ((str = br.readLine()) != null) {
//			System.out.println(str);
//			str = keyboard.nextLine();
//			pw.println(str);
//
//			if (str.equals("bye"))
//				break;
//		}
		
		ChatWindow window = new ChatWindow(socket1);
		// print the chat transcripts of the groups
		for (int i = 0; i < groups.size(); i++) {
			window.addText(groups.get(i).studentChats());
		}

	}

}
