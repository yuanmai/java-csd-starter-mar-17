package csd.starter;

import org.junit.Test;

import junit.framework.Assert;

/**
 * Created by liangxg on 2017/3/5.
 */
public class OrderTest {
	@Test
	public void order() {

		Assert.assertEquals(true, CourtService.order("jack", 1, "2017-03-05 14"));
		Assert.assertEquals(true, CourtService.order("jack", 1, "2017-03-05 15"));
		Assert.assertEquals(false, CourtService.order("jack", 1, "2017-03-05 14"));

		Assert.assertEquals(false, CourtService.order("jack", 0, "2017-03-05 19"));

	}

	@Test
	public void courtInfo() {
		Assert.assertNotNull(CourtService.getCourt());
	}
}
