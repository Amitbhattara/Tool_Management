package com.rentatool.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {
	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
	
	public static Integer getWeekDays(Date startDate, Date endDate) {
		
		LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate end = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
	    final DayOfWeek startW = start.getDayOfWeek();
	    final DayOfWeek endW = end.getDayOfWeek();

	    final long days = ChronoUnit.DAYS.between(start, end);
	    final long daysWithoutWeekends = days - 2 * ((days + startW.getValue())/7);

	    return (int) daysWithoutWeekends + (startW == DayOfWeek.SUNDAY ? 1 : 0) + (endW == DayOfWeek.SUNDAY ? 1 : 0);
	}
	
	public static Integer getWeekEnds(Date startDate, Date endDate) {
		return (int) getTotalDays(startDate, endDate) - getWeekDays(startDate, endDate);
	}
	
	public static Integer getTotalDays(Date startDate, Date endDate) {
		long diff = endDate.getTime() - startDate.getTime();
	    return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public static Date addDays(Date date, Integer daysToAdd) {
		return Date.from(date.toInstant().plus(Duration.ofDays(daysToAdd)));
	}
	
	public static String getFormattedDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return dateFormat.format(date);
	}
	
	public static Date parseDate(String date) {
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
