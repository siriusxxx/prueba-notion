package com.prueba.restapiservice.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class UserNotFoundException.
 */
public class UserNotFoundException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new user not found exception.
	 *
	 * @param message the message
	 */
	public UserNotFoundException(String message) {
		super("No existe el usuario: "+ message);
    }
}
