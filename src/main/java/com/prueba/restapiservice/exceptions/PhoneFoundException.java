package com.prueba.restapiservice.exceptions;

public class PhoneFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public PhoneFoundException(String message) {
        super("El tel�fono " + message + " ya existe asociado a un cliente");
    }
}
