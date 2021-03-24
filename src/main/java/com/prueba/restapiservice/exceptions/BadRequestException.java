package com.prueba.restapiservice.exceptions;

public class BadRequestException extends Exception {

	private static final long serialVersionUID = 1L;

	public BadRequestException(String message) {
		super("Error en alguno de los par�metros de entrada o no informado: ");
    }
}
