/**
 * Chat
 * @author Ethan Brown
 * CS 3230
 * Jan 25, 2017
 */
package chat;

/**
 * @author Ethan
 *
 */
public class Group {
	Student studentA;
	Student studentB;

	/**
	 * Used to group students together in pairs
	 */
	public Group(Student student1, Student student2) {
		int firstNameCompare = student1.getFirstName().compareTo(student2.getFirstName());
		if (student1.equals(student2)) {
			throw new IllegalArgumentException("students must be unique");
		}
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
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
