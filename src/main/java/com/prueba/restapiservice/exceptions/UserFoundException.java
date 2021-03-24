package com.prueba.restapiservice.exceptions;

public class UserFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserFoundException(String message) {
        super("Ya existe el usuario: "+ message);
    }
}
