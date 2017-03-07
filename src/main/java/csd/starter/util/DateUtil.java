package csd.starter.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * todo describe this file
 *
 * @author linluxian
 * @version 1.0 2017/3/7
 * @since 1.0
 */
public class DateUtil {

	static DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

	public static Date dateFromString(String str) {

		try {
			return format1.parse(str);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static String stringFromDate(Date date) {
		return format1.format(date);
	}

	public static Date dateAddDay(Date date, int i) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.add(5, i);
		return gc.getTime();
	}
}
