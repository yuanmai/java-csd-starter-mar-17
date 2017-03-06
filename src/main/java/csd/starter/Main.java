package csd.starter;


import csd.starter.entity.Order;
import csd.starter.entity.OrderForm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        index();
    }

    public static void index() {
        System.out.println("请输入功能编号：");
        System.out.println("1.预约场地");
        System.out.println("2.查看场地信息");
        System.out.println("0.退出");

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        if (str.equals("1")) {
            order(s);
        } else if (str.equals("2")) {

            System.out.println("我是场地");
        } else if (str.equals("0")) {

            System.out.println("谢谢使用");
        } else {

            System.out.println("请输入正确的编号！");
            index();
        }

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
        System.out.println(order.toString());

    }

}
