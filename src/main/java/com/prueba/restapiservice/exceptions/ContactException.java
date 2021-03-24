package com.prueba.restapiservice.exceptions;

public class ContactException extends Exception {

	private static final long serialVersionUID = 1L;

	public ContactException(String message) {
		super("Error al intentar guardar/actualizar el contacto: ");
    }
}
