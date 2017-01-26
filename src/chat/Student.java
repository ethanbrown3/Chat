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

	/** The student's first/last name. */
	private String firstName, lastName;

	/** The student's score. */
	private double score;

	/** The chat responses. */
	ArrayList<String> chats;

	/**
	 * Instantiates a new student.
	 *
	 * @param first - first name of the student
	 * @param last - last name of the student
	 *@param score - the student's score
	 * @param chats - the chat responses for this student
	 */
	public Student(String first, String last, String[] chats) {
		this.firstName = first;
		this.lastName = last;
		//this.score = score;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chats == null) ? 0 : chats.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (chats == null) {
			if (other.chats != null)
				return false;
		} else if (!chats.equals(other.chats))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
			return false;
		return true;
	}

	/**
	 * main() for student used for testing.
	 * @param args
	 */
	public static void main(String[] args) {
		String[] testChats = {"Hello", "How you doin'?", "thank you", "bye"};
		Student student1 = new Student("Ethan","Brown", testChats);
		
		//test student1 with toString
		System.out.println(student1.toString());
		System.out.println(student1.chats.get(0));
		System.out.println(student1.chats.get(1));
	}
}
