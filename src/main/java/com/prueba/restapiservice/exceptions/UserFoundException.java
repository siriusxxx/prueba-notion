package com.prueba.restapiservice.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class UserFoundException.
 */
public class UserFoundException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new user found exception.
	 *
	 * @param message the message
	 */
	public UserFoundException(String message) {
        super("Ya existe el usuario: "+ message);
    }
}
