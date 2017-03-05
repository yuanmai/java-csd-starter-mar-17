package csd.starter;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

/**
 * Created by wangsu on 2017/3/5.
 */
public class OrderTest {

	@Test
	public void orderTest() throws Exception {
		String userName = "jack";
		Integer order = 30;
		//正常逻辑 比当前时间大1000
		Date startTime = new Date((new Date()).getTime() + 1000);
		assertEquals(true, OrderService.order(userName, startTime, order));
		//昨天预定之前的时间 
		startTime = new Date((new Date()).getTime() - 1000);
		assertEquals(false, OrderService.order(userName, startTime, order));
	}
}
