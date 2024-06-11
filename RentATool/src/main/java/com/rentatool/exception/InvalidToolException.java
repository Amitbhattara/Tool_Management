package com.rentatool.exception;

public class InvalidToolException extends RentAToolServiceException {
	private static final long serialVersionUID = -5032031319680693408L;

	public InvalidToolException(String message) {
		super(message);
	}
}
