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
 * @author Ethan
 *
 */
public class ChatApp {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("src/chat/studentNames.csv"));
		String line;
		ArrayList<Student> students = new ArrayList<>();
		
		String[] testChats = {"Hello", "How you doin'?", "good", "ok bye"};
		String[] testChats2 = {"Waaazzzzuuup!?" , "great, you?" , "great", "see you later", "bye bye"};
		
		while((line = reader.readLine()) != null)
		{
			String[] name = line.split(",");
		    students.add(new Student(name[0],name[1], testChats2));
		}
		reader.close();
		
		System.out.println(students);
		ArrayList<Group> groups = new ArrayList<>();
		for (int i = 0; i < students.size(); i++) {
			students.get(i+1).setChats(testChats);
			groups.add(new Group(students.get(i), students.get(++i)));
		}
		
		System.out.println(groups.get(0).studentChats());
		
	}

}
