package com.prueba.restapiservice.exceptions;

public class CreateUserException extends Exception {

	private static final long serialVersionUID = 1L;

	public CreateUserException(String message) {
		super("No se ha podido crear el usuario: "+ message);
    }
}
