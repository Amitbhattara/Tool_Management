package com.rentatool.exception;

public class InvalidDiscountPercentException extends RentAToolServiceException {
	private static final long serialVersionUID = 3703634169836887307L;

	public InvalidDiscountPercentException(String message) {
		super(message);
	}
}
