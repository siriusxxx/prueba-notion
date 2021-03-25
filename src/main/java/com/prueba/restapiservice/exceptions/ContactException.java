package com.prueba.restapiservice.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactException.
 */
public class ContactException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new contact exception.
	 *
	 * @param message the message
	 */
	public ContactException(String message) {
		super("Error al intentar guardar/actualizar el contacto: ");
    }
}
