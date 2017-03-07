package csd.starter;

import java.util.List;
import java.util.Scanner;

import csd.starter.entity.Court;
import csd.starter.entity.CycleOrderForm;
import csd.starter.entity.Order;
import csd.starter.entity.OrderForm;
import csd.starter.util.DateUtil;

public class Main {

	private Main() {
		throw new IllegalAccessError("");
	}

	public static void main(String[] args) {

		index();
	}

	public static void index() {
		System.out.println("请输入功能编号：");
		System.out.println("1.预约场地");
		System.out.println("2.查看场地信息");
		System.out.println("3.查找最近场地");
		System.out.println("4.订单结算");
		System.out.println("5.周期性预约场地");
		System.out.println("0.退出");

		Scanner scanner = new Scanner(System.in);
		String nextLine = scanner.nextLine();

		if (nextLine.equals("1")) {
			order(scanner);
		}
		else if (nextLine.equals("2")) {
			System.out.println("我是场地");
		}
		else if (nextLine.equals("3")) {
			findNearestCourt(scanner);
		}
		else if (nextLine.equals("4")) {
			payOrder(scanner);
		}
		else if (nextLine.equals("5")) {
			cycleOrder(scanner);
		}
		else if (nextLine.equals("0")) {

			System.out.println("谢谢使用");
		}
		else {
			System.out.println("请输入正确的编号！");
			index();
		}

	}

	private static void cycleOrder(Scanner scanner) {
		System.out.println("周期预约：");

		OrderForm form = new OrderForm();
		System.out.println("请输入：场地ID");
		form.setCourtId(scanner.nextInt());
		System.out.println("请输入：预约人");
		form.setUser(scanner.next());
		System.out.println("请输入：手机号");
		form.setPhone(scanner.next());
		System.out.println("请输入：预约日期（yyyy-MM-dd格式）");
		form.setOrderDate(scanner.next());
		System.out.println("请输入：开始时段（HH）");
		form.setHourStart(scanner.nextInt());
		System.out.println("请输入：结束时段（HH）");
		form.setHourEnd(scanner.nextInt());

		CycleOrderForm cycleOrderForm = new CycleOrderForm();
		cycleOrderForm.setOrderForm(form);
		System.out.println("请输入：重复周数）");
		cycleOrderForm.setWeekNumber(scanner.nextInt());
		cycleOrderForm.setStartDate(DateUtil.dateFromString(form.getOrderDate()));

		List<Order> orderList = CycleOrderService.createCycleOrder(cycleOrderForm);
		System.out.println("订单信息：");
		for (Order order : orderList) {
			System.out.println(order.toString());
		}

	}

	private static void payOrder(Scanner scanner) {
		System.out.println("请输入订单号");
		Order order = OrderService.getOrder(scanner.nextInt());
		System.out.println("订单信息：");
		if (order == null) {
			System.out.println("无订单信息");
			return;
		}
		String orderInfo = order.getId() + "," + order.getCourtId() + "," + order.getUsername()
				+ ",金额：" + order.getTotalPrice();

		System.out.println(orderInfo);

		int money = scanner.nextInt();

		orderInfo += ",收款：" + money + ",差额：" + (money - order.getTotalPrice());
		System.out.println("结账信息：");
		System.out.println(orderInfo);

	}

	private static void order(Scanner scanner) {
		OrderForm form = new OrderForm();
		System.out.println("请输入：场地ID");
		form.setCourtId(scanner.nextInt());
		System.out.println("请输入：预约人");
		form.setUser(scanner.next());
		System.out.println("请输入：手机号");
		form.setPhone(scanner.next());
		System.out.println("请输入：预约日期（yyyy-MM-dd格式）");
		form.setOrderDate(scanner.next());
		System.out.println("请输入：开始时段（HH）");
		form.setHourStart(scanner.nextInt());
		System.out.println("请输入：结束时段（HH）");
		form.setHourEnd(scanner.nextInt());

		Order order = OrderService.order(form);
		System.out.println("订单信息：");
		System.out.println(order.toString());

	}

	private static void findNearestCourt(Scanner scanner) {
		System.out.println("请输入位置:x,y");
		String[] positions = scanner.next().split(",");

		Integer x = Integer.parseInt(positions[0]);
		Integer y = Integer.parseInt(positions[1]);

		List<Court> courtList = OrderService.getNearestCourt(x, y);
		Court nearestCourt = courtList.get(0);
		System.out.println("最近场馆：");
		System.out.println(nearestCourt.getId() + "," + nearestCourt.getName());
	}

}
