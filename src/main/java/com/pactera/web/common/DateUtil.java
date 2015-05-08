package com.pactera.web.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date parse(String source, String format) throws ParseException {
		DateFormat fmt = new SimpleDateFormat(format);
		Date date = fmt.parse(source);
		return date;
	}

	public static String format(Date date, String format) {
		DateFormat fmt = new SimpleDateFormat(format);
		String dateStr = fmt.format(date);
		return dateStr;
	}

}
