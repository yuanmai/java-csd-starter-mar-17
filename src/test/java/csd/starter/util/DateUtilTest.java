package csd.starter.util;

import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * todo describe this file
 *
 * @author linluxian
 * @version 1.0 2017/3/7
 * @since 1.0
 */
public class DateUtilTest {

	@Test
	public void testDateFromString() {
		Date date = DateUtil.dateFromString("2017-03-06");
		assertNotNull(date);
		System.out.println(date);
	}

	@Test
	public void testStringFromDate() {
		String dateStr = "2017-03-06";
		Date date = DateUtil.dateFromString(dateStr);

		assertEquals(dateStr, DateUtil.stringFromDate(date));
	}

	@Test
	public void dateAddDay() {
		String dateStr = "2017-03-06";
		Date date = DateUtil.dateFromString(dateStr);

		assertEquals("2017-03-13", DateUtil.stringFromDate(DateUtil.dateAddDay(date, 7)));
	}

}