/**
 * Chat
 * @author Ethan Brown
 * CS 3230
 * Jan 24, 2017
 */
package chat;

import java.util.ArrayList;

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
	 */
	public Student() {

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
	 * @param score the new score
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

}
