package csd.starter.entity;

import java.util.Date;

/**
 * Created by suzf on 2017/3/5.
 */
public class CycleOrderForm {

	private OrderForm orderForm;
	private Date startDate;
	private int weekNumber;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public OrderForm getOrderForm() {
		return orderForm;
	}

	public void setOrderForm(OrderForm orderForm) {
		this.orderForm = orderForm;
	}

	public int getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(int weekNumber) {
		this.weekNumber = weekNumber;
	}
}
