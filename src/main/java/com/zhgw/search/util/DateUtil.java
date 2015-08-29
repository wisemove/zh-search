package com.zhgw.search.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author yujunming
 *
 */
public class DateUtil {

	public static String SHORT_PARTTEN = "yyyy-MM-dd";

	public static String LONG_PARTTEN = "yyyy-MM-dd HH:mm:ss";

	public static void setPartten(String partten) {
		DateUtil.LONG_PARTTEN = partten;
	}

	public static String getCurrentDay() {
		SimpleDateFormat sdf = new SimpleDateFormat(LONG_PARTTEN);
		return sdf.format(new Date());
	}

	public static String toLongDate(String date, String partten) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(partten);
		return String.valueOf(sdf.parse(date).getTime());
	}

	public static Date toDate(String time) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(LONG_PARTTEN);
		return sdf.parse(time);
	}

	public static String getCalDate(int param, int calendar, String partten) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(partten);
		String createDate = sdf.format(new Date());
		String temp = "";
		Date date = sdf.parse(createDate);
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		cl.add(calendar, param);
		temp = sdf.format(cl.getTime());
		return temp;
	}

	public static String getYesterdayDate() throws ParseException {
		return getCalDate(-1, Calendar.DATE, LONG_PARTTEN);
	}

	public static String getLastWeekEndDate() throws ParseException {
		int day = Integer.parseInt("-"+getCurrentDayOfWeek());
		return getCalDate(day, Calendar.DATE, LONG_PARTTEN);
	}
	
	public static String getLastWeekStartDate() throws ParseException{
		int day = -6+Integer.parseInt("-"+getCurrentDayOfWeek());
		return getCalDate(day, Calendar.DATE, LONG_PARTTEN);
	}

	public static String getThisWeek() throws ParseException {
		return getCalDate(-1, Calendar.WEEK_OF_MONTH, LONG_PARTTEN);
	}
	
	public static String getLastYear() throws ParseException {
		return getCalDate(-1, Calendar.YEAR, LONG_PARTTEN);
	}

	public static String getLastMonth() throws ParseException {
		return getCalDate(-1, Calendar.MONTH, LONG_PARTTEN);
	}

	public static String getLastThreeMonth() throws ParseException {
		return getCalDate(-3, Calendar.MONTH, LONG_PARTTEN);
	}

	public static String getLastThreeDay() throws ParseException {
		return getCalDate(-3, Calendar.DATE, LONG_PARTTEN);
	}

	public static int getCurrentDayOfWeek() {
		SimpleDateFormat sdf = new SimpleDateFormat("E");
		String week = sdf.format(new Date());
		if ("星期一".equals(week)) 
			return 1;
		if ("星期二".equals(week))
			return 2;
		if ("星期三".equals(week))
			return 3;
		if ("星期四".equals(week))
			return 4;
		if ("星期五".equals(week))
			return 5;
		if ("星期六".equals(week))
			return 6;
		if ("星期日".equals(week))
			return 7;
		return 1;
	}
}
