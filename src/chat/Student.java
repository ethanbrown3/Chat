/**
 * Chat
 * @author Ethan Brown
 * CS 3230
 * Jan 24, 2017
 */
package chat;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Class Student.
 *
 * @author Ethan
 */
public class Student implements Comparable<Student> {

	private String firstName, lastName;

	private double score;

	ArrayList<String> chats;

	private final int id;

	public static int idIncrementer = 10000;

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
	public Student(String first, String last, String[] chats) {
		this.firstName = first;
		this.lastName = last;
		// this.score = score;
		this.chats = new ArrayList<String>(Arrays.asList(chats));

		id = idIncrementer++;

	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public ArrayList<String> getChats() {
		return chats;
	}

	public void setChats(ArrayList<String> chats) {
		this.chats = chats;
	}

	public void setChats(String[] chats) {
		this.chats = new ArrayList<String>(Arrays.asList(chats));
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", score=" + score + ", id=" + id + "]\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chats == null) ? 0 : chats.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
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
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
			return false;
		return true;
	}

	@Override
	public int compareTo(Student compareStudent) {
		String compareString = compareStudent.getFirstName()+compareStudent.getLastName();
		String studentString = this.getFirstName() + this.getLastName();
		return studentString.compareToIgnoreCase(compareString);
	}

	public static void main(String[] args) {
		String[] testChats = { "Hello", "How you doin'?", "thank you", "bye" };
		Student student1 = new Student("Ethan", "Brown", testChats);
		Student student2 = new Student("Ethan", "Brown", testChats);
		// test student1 with toString
		System.out.println(student1.toString());
		System.out.println(student2.toString());
		System.out.println(student1.chats.get(0));
		System.out.println(student2.chats.get(0));
	}

}
