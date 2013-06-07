package sampleproject2.dto;

import java.io.Serializable;

public class SampleDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * First name of the user.
	 */
	private String firstName;
	/**
	 * Last name of the user.
	 */
	private String lastName;
	/**
	 * Greeting message.
	 */
	private String message;
	
	/**
	 * Store the user name.
	 * @param firstName first name of the user
	 * @param lastName last name of the user
	 */
	public SampleDTO(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setMessage("Hello");
	}

    /**
     * Get first name of the user.
     * @return first name of the user
     */
	public String getFirstName() {
		return firstName;
	}

    /**
     * Set first name of the user.
     * @param firstName first name of the user
     */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

    /**
     * Get last name of the user.
     * @return last name of the user
     */
	public String getLastName() {
		return lastName;
	}

    /**
     * Set last name of the user.
     * @param lastName last name of the user
     */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    /**
     * Get greeting message.
     * @return greeting message
     */
	public String getMessage() {
		return message;
	}

    /**
     * Set greeting message.
     * @param msg greeting message
     */
	public void setMessage(String message) {
		this.message = message;
	}
}
