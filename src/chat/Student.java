/**
 * Chat
 * @author Ethan Brown
 * CS 3230
 * Jan 24, 2017
 */
package chat;

import java.util.ArrayList;
import java.util.Arrays;

// TODO: Auto-generated Javadoc
/**
 * The Class Student.
 *
 * @author Ethan
 */
public class Student {

	/** The first/last name. */
	private String firstName, lastName;

	/** The score. */
	private double score;

	/** The chat responses. */
	ArrayList<String> chats;

	/**
	 * Instantiates a new student.
	 *
	 * @param first
	 *            - first name of the student
	 * @param last
	 *            - last name of the student
	 * @param score
	 *            - the student's score
	 * @param chats
	 *            - the chat responses for this student
	 */
	public Student(String first, String last, double score, String[] chats) {
		this.firstName = first;
		this.lastName = last;
		this.score = score;
		this.chats = new ArrayList<String>(Arrays.asList(chats));

	}

	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public double getScore() {
		return score;
	}

	/**
	 * Sets the score.
	 *
	 * @param score
	 *            the new score
	 */
	public void setScore(double score) {
		this.score = score;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", score=" + score + ", chats=" + chats
				+ "]";
	}

	/**
	 * main() for student used for testing.
	 * @param args
	 */
	public static void main(String[] args) {
		String[] testChats = {"Hello", "How you doin'?", "thank you", "bye"};
		Student student1 = new Student("Ethan","Brown", 99.9, testChats);
		
		//test student1 with toString
		System.out.println(student1.toString());
		System.out.println(student1.chats.get(2));
	}
}
