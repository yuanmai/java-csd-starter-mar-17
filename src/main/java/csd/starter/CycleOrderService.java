package csd.starter;

import csd.starter.entity.CycleOrderForm;
import csd.starter.entity.Order;
import csd.starter.entity.OrderForm;
import csd.starter.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * todo describe this file
 *
 * @author linluxian
 * @version 1.0 2017/3/7
 * @since 1.0
 */
public class CycleOrderService {

	public static List<Order> createCycleOrder(CycleOrderForm cycleOrderForm) {
		List<Order> orderList = new ArrayList<>();

		for (int i = 0; i < cycleOrderForm.getWeekNumber(); i++) {
			OrderForm orderForm = new OrderForm();
			orderForm.setPhone(cycleOrderForm.getOrderForm().getPhone());
			orderForm.setCourtId(cycleOrderForm.getOrderForm().getCourtId());
			orderForm.setUser(cycleOrderForm.getOrderForm().getUser());
			orderForm.setHourStart(cycleOrderForm.getOrderForm().getHourStart());
			orderForm.setHourEnd(cycleOrderForm.getOrderForm().getHourEnd());

			orderForm.setOrderDate(DateUtil
					.stringFromDate(DateUtil.dateAddDay(cycleOrderForm.getStartDate(), i * 7)));
			orderList.add(OrderService.order(orderForm));
		}

		return orderList;
	}

}
