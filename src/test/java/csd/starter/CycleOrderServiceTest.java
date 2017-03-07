package csd.starter;

import csd.starter.entity.CycleOrderForm;
import csd.starter.entity.Order;
import csd.starter.entity.OrderForm;
import csd.starter.util.DateUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * todo describe this file
 *
 * @author linluxian
 * @version 1.0 2017/3/7
 * @since 1.0
 */
public class CycleOrderServiceTest {

	CycleOrderForm cycleOrderForm;

	@Before
	public void before() {
		OrderForm form = new OrderForm();
		form.setCourtId(1);
		form.setUser("suzf");
		form.setOrderDate("2017-03-05");
		form.setHourStart(10);
		form.setHourEnd(12);

		cycleOrderForm = new CycleOrderForm();
		cycleOrderForm.setOrderForm(form);
		cycleOrderForm.setStartDate(DateUtil.dateFromString(form.getOrderDate()));
		cycleOrderForm.setWeekNumber(4);

	}

	@Test
	public void 创建周期预约() {

		List<Order> orderList = CycleOrderService.createCycleOrder(cycleOrderForm);

		assertNotNull(orderList);
		assertEquals(4, orderList.size());
		assertEquals("2017-03-05",
				orderList.get(0).getDates().toArray()[0].toString().substring(0, 10));
		assertEquals("2017-03-12",
				orderList.get(1).getDates().toArray()[0].toString().substring(0, 10));
		assertEquals("2017-03-19",
				orderList.get(2).getDates().toArray()[0].toString().substring(0, 10));
		assertEquals("2017-03-26",
				orderList.get(3).getDates().toArray()[0].toString().substring(0, 10));

	}
}
