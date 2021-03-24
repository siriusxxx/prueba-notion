package com.prueba.restapiservice.exceptions;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super("No existe el usuario: "+ message);
    }
}
