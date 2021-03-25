package com.prueba.restapiservice.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateUserException.
 */
public class CreateUserException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new creates the user exception.
	 *
	 * @param message the message
	 */
	public CreateUserException(String message) {
		super("No se ha podido crear el usuario: "+ message);
    }
}
