package csd.starter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        boolean stop = true;

        while (stop) {
            System.out.print("choose your role (P / M): ");
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                String role = RoleSelector.select(in.readLine());
                if (role.equals("M")) {
                    // TODO 管理员
                } else if (role.equals("P")) {
                    // TODO 用户
                    handlePlayer(in);
                } else {
                    System.out.println("illegal role");
                }

            } catch (Exception e) {
                // NOOP
            }
        }
    }

    private static void handlePlayer(BufferedReader in) throws Exception {
        System.out.print("Enter your username: ");
        String user = in.readLine();
        System.out.print("Enter order date: ");
        String startTimeStr = in.readLine();
        System.out.print("Enter order duration: ");
        Integer order = Integer.valueOf(in.readLine());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = format.parse(startTimeStr);

        OrderService orderService = new OrderService();
        if (orderService.order(user, startTime, order)) {
            System.out.println("Order successfully.");
        } else {
            System.out.println("Order fail.");
        }
    }

}
