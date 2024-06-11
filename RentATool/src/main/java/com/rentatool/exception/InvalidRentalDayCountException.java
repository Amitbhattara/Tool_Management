package com.rentatool.exception;

public class InvalidRentalDayCountException extends RentAToolServiceException {
	private static final long serialVersionUID = -407041679181595677L;

	public InvalidRentalDayCountException(String message) {
		super(message);
	}
}
