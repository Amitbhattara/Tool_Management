package com.rentatool.model;

import java.util.Date;

import com.rentatool.utils.DateUtils;

public class ToolRentalCheckout {

	private String toolCode;
	private String toolType;
	private String brand;
	private Integer rentalDays;
	private Date checkOutDate;
	private Date dueDate;
	private String dailyRentalCharge;
	private Integer chargeDays;
	private String preDiscountCharge;
	private Integer discountPercent;
	private String discountAmount;
	private String finalCharge; 
	
	public ToolRentalCheckout() {};

	public ToolRentalCheckout(String toolCode, String toolType, String brand, Integer rentalDays, Date checkOutDate,
			Date dueDate, String dailyRentalCharge, Integer chargeDays, String preDiscountCharge,
			Integer discountPercent, String discountAmount, String finalCharge) {
		super();
		this.toolCode = toolCode;
		this.toolType = toolType;
		this.brand = brand;
		this.rentalDays = rentalDays;
		this.checkOutDate = checkOutDate;
		this.dueDate = dueDate;
		this.dailyRentalCharge = dailyRentalCharge;
		this.chargeDays = chargeDays;
		this.preDiscountCharge = preDiscountCharge;
		this.discountPercent = discountPercent;
		this.discountAmount = discountAmount;
		this.finalCharge = finalCharge;
	}

	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	public String getToolType() {
		return toolType;
	}

	public void setToolType(String toolType) {
		this.toolType = toolType;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getRentalDays() {
		return rentalDays;
	}

	public void setRentalDays(Integer rentalDays) {
		this.rentalDays = rentalDays;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getDailyRentalCharge() {
		return dailyRentalCharge;
	}

	public void setDailyRentalCharge(String dailyRentalCharge) {
		this.dailyRentalCharge = dailyRentalCharge;
	}

	public Integer getChargeDays() {
		return chargeDays;
	}

	public void setChargeDays(Integer chargeDays) {
		this.chargeDays = chargeDays;
	}

	public String getPreDiscountCharge() {
		return preDiscountCharge;
	}

	public void setPreDiscountCharge(String preDiscountCharge) {
		this.preDiscountCharge = preDiscountCharge;
	}

	public Integer getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Integer discountPercent) {
		this.discountPercent = discountPercent;
	}

	public String getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(String discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getFinalCharge() {
		return finalCharge;
	}

	public void setFinalCharge(String finalCharge) {
		this.finalCharge = finalCharge;
	}

	@Override
	public String toString() {
		return "Tool Code:" + toolCode + '\n'+"Tool Type:" + toolType + '\n'+"Brand:" + brand + '\n'+"Rental Days:"
				+ rentalDays + '\n'+"Checkout Date:" + DateUtils.getFormattedDate(checkOutDate) + '\n'+"Due Date:" + DateUtils.getFormattedDate(dueDate) + '\n'+"Daily Rental Charge:"
				+ dailyRentalCharge + '\n'+"Charge Days:" + chargeDays + '\n'+"Pre-Discount Charge:" + preDiscountCharge
				+ '\n'+"Discount Percent:" + discountPercent +"%"+ '\n'+"Discount Amount:" + discountAmount + '\n'+"Final Charge:"
				+ finalCharge;
	}

}
