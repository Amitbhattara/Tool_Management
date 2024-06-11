package com.rentatool.exception;

public class InvalidChargeException extends RentAToolServiceException {
	private static final long serialVersionUID = 6679319832291726862L;

	public InvalidChargeException(String message) {
		super(message);
	}
}
