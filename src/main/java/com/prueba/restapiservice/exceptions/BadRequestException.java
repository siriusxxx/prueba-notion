package com.prueba.restapiservice.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class BadRequestException.
 */
public class BadRequestException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new bad request exception.
	 *
	 * @param message the message
	 */
	public BadRequestException(String message) {
		super("Error en alguno de los parámetros de entrada o no informado: ");
    }
}
