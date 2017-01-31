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
import java.util.ArrayList;

/**
 * The Class ChatApp.
 *
 * @author Ethan
 */
public class ChatApp {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {

		// ArrayList of students in the class
		ArrayList<Student> students = new ArrayList<>();

		// String arrays of chat transcripts
		String[] testChats = { "Hello", "How's it goin'?", "good", "ok bye" };
		String[] testChats2 = { "Waaazzzzuuup!?", "great, you?", "great", "see you later", "bye bye" };
		
		// BufferedReader - used to read in student names from a csv file
		BufferedReader reader = new BufferedReader(new FileReader("src/chat/studentNames.csv"));
		String line;
		
		// while loop that creates new students and adds them to the student ArrayList
		while ((line = reader.readLine()) != null) {
			String[] name = line.split(",");
			students.add(new Student(name[0], name[1], testChats2));
		}
		reader.close(); // close the reader
		
		
		// print ArrayList of students
		System.out.println(students);
		
		// ArrayList of Groups
		ArrayList<Group> groups = new ArrayList<>();
		// fill the groups AL with new groups
		for (int i = 0; i < students.size(); i++) {
			students.get(i + 1).setChats(testChats);
			groups.add(new Group(students.get(i), students.get(++i)));
		}
		
		// print the chat transcripts of the groups
		for (int i = 0; i < groups.size(); i++) {
			System.out.println(groups.get(i).studentChats());
		}

	}

}
