/**
 * Chat
 * @author Ethan Brown
 * CS 3230
 * Jan 25, 2017
 */
package chat;

/**
 * The Class Group.
 *
 * @author Ethan
 */
public class Group {
	
	Student studentA;
	Student studentB;

	/**
	 * Used to group students together in pairs. Sorted by name.
	 *
	 * @param student1
	 * @param student2
	 */
	public Group(Student student1, Student student2) {
		int firstNameCompare = student1.getFirstName().compareTo(student2.getFirstName());
		
		if (student1.equals(student2)) {
			throw new IllegalArgumentException("students must be unique");
		}
		
		// sort the students by first then last name
		if (firstNameCompare < 0) {
			this.studentA = student1;
			this.studentB = student2;
		} else if (firstNameCompare > 0) {
			this.studentB = student1;
			this.studentA = student2;
		} else if (firstNameCompare == 0) {
			int lastNameCompare = student1.getLastName().compareTo(student2.getLastName());
			if (lastNameCompare < 0) {
				this.studentA = student1;
				this.studentB = student2;
			} else if (lastNameCompare > 0) {
				this.studentB = student1;
				this.studentA = student2;
			} else {
				this.studentA = student1;
				this.studentB = student2;
			}
		}
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

		int chatLength = Math.min(studentA.chats.size(), studentB.chats.size());
		for (int i = 0; i < chatLength; i++) {
			chat += nameA + ": " + studentA.chats.get(i) + "\n";
			chat += nameB + ": " + studentB.chats.get(i) + "\n";
		}
		
		return chat;
		
	}

	@Override
	public String toString() {
		return "Group [studentA=" + studentA + ", studentB=" + studentB + "]";
	}

	public static void main(String[] args) {
		String[] testChats = {"Hello", "How you doin'?", "good", "ok bye"};
		String[] testChats2 = {"Waaazzzzuuup!?" , "great, you?" , "great", "see you", "bye bye"};
		Student student1 = new Student("Ethan","Brown", testChats2);
		Student student2 = new Student("Alan","Doe", testChats);
		//test student1 with toString
		Group testGroup = new Group(student1, student2);
//		Group testGroup = new Group(student1, student1); // test for having duplicate students in a group
		System.out.println(testGroup.toString());
		System.out.println(testGroup.studentChats());
		
	}

}
