/**
 * Chat
 * @author Ethan Brown
 * CS 3230
 * Jan 25, 2017
 */
package chat;

import java.util.ArrayList;

/**
 * The Class Group.
 *
 * @author Ethan
 */
public class Group implements Comparable<Group> {

	Student studentA;
	Student studentB;

	/**
	 * Used to group students together in pairs. Sorted by name.
	 *
	 * @param student1
	 * @param student2
	 */
	public Group(Student student1, Student student2) {

		if (student1.equals(student2)) {
			throw new IllegalArgumentException("students must be unique");
		}
		this.studentA = student1;
		this.studentB = student2;
	}

	/**
	 * returns a formatted string of the two students' chat transcripts together
	 *
	 * @return String - the chat transcript
	 */
	public String studentChats() {
		String nameA = studentA.getFirstName() + " " + studentA.getLastName();
		String nameB = studentB.getFirstName() + " " + studentB.getLastName();
		String chat = "";
		ArrayList<String> chatA = studentA.getChats();
		ArrayList<String> chatB = studentB.getChats();

		int chatLength = Math.min(chatA.size(), chatB.size());
		for (int i = 0; i < chatLength; i++) {
			chat += nameA + ": " + chatA.get(i) + "\n";
			chat += nameB + ": " + chatB.get(i) + "\n";
		}

		return chat;

	}

	public String getStudentAName() {
		return this.studentA.getFirstName() + this.studentA.getLastName();
	}

	@Override
	public String toString() {
		return "Group [studentA=" + studentA + ", studentB=" + studentB + "]";
	}

	@Override
	public int compareTo(Group compareGroup) {
		String compareString = ((Group) compareGroup).getStudentAName();
		return this.getStudentAName().compareToIgnoreCase(compareString);
	}

	public static void main(String[] args) {
		String[] testChats = { "Hello", "How you doin'?", "good", "ok bye" };
		String[] testChats2 = { "Waaazzzzuuup!?", "great, you?", "great", "see you", "bye bye" };
		Student student1 = new Student("Ethan", "Brown", testChats2);
		Student student2 = new Student("Alan", "Doe", testChats);
		// test student1 with toString
		Group testGroup = new Group(student1, student2);
		// Group testGroup = new Group(student1, student1); // test for having
		// duplicate students in a group
		System.out.println(testGroup.toString());
		System.out.println(testGroup.studentChats());

	}

}
