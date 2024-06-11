package com.rentatool.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

import com.rentatool.model.ToolRentalCharge;

public class CommonUtils {

	public static Integer getChargableDays(Date checkoutDate, Date dueDate, ToolRentalCharge charge) {
		checkoutDate = DateUtils.addDays(checkoutDate, 1);
		int chargableDays = DateUtils.getWeekDays(checkoutDate, dueDate);
		if (charge.getWeekendCharge()) {
			chargableDays += DateUtils.getWeekEnds(checkoutDate, dueDate);
		}
		if (!charge.getHolidayCharge()) {
			Integer holidays = getHolidaysCount(checkoutDate, dueDate, charge);
			chargableDays += holidays;
		}
		return chargableDays;

	}

	@SuppressWarnings("deprecation")
	public static Integer getHolidaysCount(Date checkoutDate, Date dueDate, ToolRentalCharge charge) {
		Integer holidaysCount = 0;
		Calendar cal = Calendar.getInstance();
		if ((checkoutDate.getMonth() + 1 <= 7 && dueDate.getMonth() + 1 >= 7)
				&& (checkoutDate.getDate() <= 4 && dueDate.getDate() >= 4)) {
			Date independenceDay = new Date();
			independenceDay.setDate(4);
			independenceDay.setMonth(6);
			independenceDay.setYear(checkoutDate.getYear());

			cal = Calendar.getInstance();
			cal.setTime(independenceDay);

			if ((cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) || (Calendar.DAY_OF_WEEK == Calendar.SUNDAY)) {
				if (charge.getWeekendCharge()) {
					holidaysCount++;
				}
			} else {
				holidaysCount++;
			}
		} else {
			Date date = new Date();
			date.setMonth(8);
			date.setYear(checkoutDate.getYear());
			LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate firstMondayDate = localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
			LocalDate startDate = checkoutDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate endDate = dueDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			boolean isBetween = firstMondayDate.isAfter(startDate) && firstMondayDate.isBefore(endDate);
			if (isBetween) {
				holidaysCount++;
			}
		}
		return holidaysCount;
	}
}
