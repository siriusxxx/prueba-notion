package com.prueba.restapiservice.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class PhoneFoundException.
 */
public class PhoneFoundException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new phone found exception.
	 *
	 * @param message the message
	 */
	public PhoneFoundException(String message) {
        super("El teléfono " + message + " ya existe asociado a un cliente");
    }
}
