package com.rentatool.validator;

import java.util.Date;

import com.rentatool.exception.InvalidDiscountPercentException;
import com.rentatool.exception.InvalidRentalDayCountException;

public class CheckoutValidator {

	public static Boolean validate(String toolCode, int rentalDayCount, int discountPercent, Date checkoutDate)
			throws Exception {

		if (discountPercent < 0 || discountPercent > 100) {
			throw new InvalidDiscountPercentException("Discount percent is not in the range 0-100");
		}
		
		if (rentalDayCount < 1) {
			throw new InvalidRentalDayCountException("Rental day count is not 1 or greater");
		}

		return true;
	}
}
