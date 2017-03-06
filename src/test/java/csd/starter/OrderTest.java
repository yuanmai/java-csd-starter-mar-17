package csd.starter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

/**
 * Created by wangsu on 2017/3/5.
 */
public class OrderTest {

	String userName = "jack";
	Integer minutes = 30;
	Date startTimeMoreCurr = new Date((new Date()).getTime() + 1000);
	Date startTimeLessCurr = new Date((new Date()).getTime() - 1000);

	@Test
	public void orderTest() {

		//正常逻辑 比当前时间大1000
		Date startTime = new Date((new Date()).getTime() + 1000);
		assertEquals(true, OrderService.order(userName, startTime, minutes));
		//昨天预定之前的时间 
		startTime = new Date((new Date()).getTime() - 1000);
		assertEquals(false, OrderService.order(userName, startTime, minutes));
	}

	@Test
	public void 正常预定() {
		assertEquals(true, OrderService.order(userName, startTimeMoreCurr, minutes));
	}

	@Test
	public void 预定时间小于当前时间应该返回失败() {
		assertEquals(false, OrderService.order(userName, startTimeLessCurr, minutes));
	}

	@Test
	public void 用户为空应抛异常() {
		Exception e = null;
		try {
			OrderService.order(null, startTimeLessCurr, minutes);
		}
		catch (Exception ex) {
			e = ex;
		}
		assertTrue("", "用户不可为空".equals(e.getMessage()));

		try {
			OrderService.order("", startTimeLessCurr, minutes);
		}
		catch (Exception ex) {
			e = ex;
		}
		assertTrue("", "用户不可为空".equals(e.getMessage()));
	}

	@Test
	public void 预定时间为空应抛异常() {
		Exception e = null;
		try {
			OrderService.order(userName, null, minutes);
		}
		catch (Exception ex) {
			e = ex;
		}
		assertTrue("", "预定开始时间不可为空".equals(e.getMessage()));
	}

	@Test
	public void 预定时长为负数应抛异常() {
		Exception e = null;
		try {
			OrderService.order(userName, startTimeMoreCurr, -1);
		}
		catch (Exception ex) {
			e = ex;
		}
		assertTrue("", "预定时长不可为空或者小于0".equals(e.getMessage()));
	}

	@Test
	public void 预定时长为空应抛异常() {
		Exception e = null;
		try {
			OrderService.order(userName, startTimeMoreCurr, null);
		}
		catch (Exception ex) {
			e = ex;
		}
		assertTrue("", "预定时长不可为空或者小于0".equals(e.getMessage()));
	}
}
