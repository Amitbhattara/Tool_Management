package com.rentatool.model;

public class ToolRentalCharge {

	private String toolType;
	private Double dailyCharge;
	private Boolean weekdayCharge;
	private Boolean weekendCharge;
	private Boolean holidayCharge;

	public ToolRentalCharge(String toolType, Double dailyCharge, Boolean weekdayCharge, Boolean weekendCharge,
			Boolean holidayCharge) {
		super();
		this.toolType = toolType;
		this.dailyCharge = dailyCharge;
		this.weekdayCharge = weekdayCharge;
		this.weekendCharge = weekendCharge;
		this.holidayCharge = holidayCharge;
	}

	public String getToolType() {
		return toolType;
	}

	public void setToolType(String toolType) {
		this.toolType = toolType;
	}

	public Double getDailyCharge() {
		return dailyCharge;
	}

	public void setDailyCharge(Double dailyCharge) {
		this.dailyCharge = dailyCharge;
	}

	public Boolean getWeekdayCharge() {
		return weekdayCharge;
	}

	public void setWeekdayCharge(Boolean weekdayCharge) {
		this.weekdayCharge = weekdayCharge;
	}

	public Boolean getWeekendCharge() {
		return weekendCharge;
	}

	public void setWeekendCharge(Boolean weekendCharge) {
		this.weekendCharge = weekendCharge;
	}

	public Boolean getHolidayCharge() {
		return holidayCharge;
	}

	public void setHolidayCharge(Boolean holidayCharge) {
		this.holidayCharge = holidayCharge;
	}

}
