package com.rentatool.service;

import java.text.DecimalFormat;
import java.util.Date;

import com.rentatool.model.RentalTool;
import com.rentatool.model.ToolRentalCharge;
import com.rentatool.model.ToolRentalCheckout;
import com.rentatool.repository.RentalToolRepository;
import com.rentatool.repository.ToolRentalChargeRepository;
import com.rentatool.utils.CommonUtils;
import com.rentatool.utils.DateUtils;
import com.rentatool.validator.CheckoutValidator;

public class ToolCheckoutService {

	private RentalToolRepository toolRepository = new RentalToolRepository();
	private ToolRentalChargeRepository chargeRepository = new ToolRentalChargeRepository();

	public ToolRentalCheckout toolCheckout(String toolCode, String checkout, int rentalDayCount, String discount) {

		Date checkoutDate = DateUtils.parseDate(checkout);
		int discountPercent = Integer.parseInt(discount.split("%")[0]);
		ToolRentalCheckout toolCheckout = null;
		try {
			if (CheckoutValidator.validate(toolCode, rentalDayCount, discountPercent, checkoutDate)) {
				RentalTool tool = null;
				ToolRentalCharge charge = null;
				tool = toolRepository.getRentalToolByCode(toolCode);
				if (tool != null) {
					charge = chargeRepository.getToolRentalChargeByToolType(tool.getType());
					if (charge != null) {
						toolCheckout = new ToolRentalCheckout();
						DecimalFormat f = new DecimalFormat("$##.00");
						Date dueDate = DateUtils.addDays(checkoutDate, rentalDayCount);
						Integer chargableDays = CommonUtils.getChargableDays(checkoutDate, dueDate, charge);
						Double preDiscountCharge = chargableDays * charge.getDailyCharge();
						Double discountAmount = (discountPercent * preDiscountCharge) / 100;
						Double finalCharge = preDiscountCharge - discountAmount;
						toolCheckout.setToolCode(toolCode);
						toolCheckout.setToolType(tool.getType());
						toolCheckout.setBrand(tool.getBrand());
						toolCheckout.setRentalDays(rentalDayCount);
						toolCheckout.setCheckOutDate(checkoutDate);
						toolCheckout.setDailyRentalCharge(f.format(charge.getDailyCharge()));
						toolCheckout.setDueDate(dueDate);
						toolCheckout.setChargeDays(chargableDays);
						toolCheckout.setPreDiscountCharge(f.format(preDiscountCharge));
						toolCheckout.setDiscountPercent(discountPercent);
						toolCheckout.setDiscountAmount(f.format(discountAmount));
						toolCheckout.setFinalCharge(f.format(finalCharge));
					} else {
						return null;
					}
				} else {
					return null;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return toolCheckout;
	}

	

}
