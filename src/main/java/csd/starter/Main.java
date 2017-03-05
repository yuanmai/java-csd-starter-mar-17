package csd.starter;

import java.util.Scanner;

public class Main {
    enum CMD {
        F, B, Q
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);// 接收控制台输入的信息
        System.out.println("请输入用户：");
        String userName = scan.next();
        System.out.println("请输出已知的命令(F/B/Q)");
        while(true) {
            String cmdStr = scan.next();
            CMD cmd = CMD.valueOf(cmdStr);
            switch (cmd) {
                case B:
                    System.out.println("预定的场地与时间段:");
                    String area = scan.next();
                    String sDate = scan.next();
                    String eDate = scan.next();
                    Order order = Reservator.getInstance().book(userName, area, sDate, eDate);
                    System.out.println(order);
                    break;
                case Q:
                    System.exit(0);
            }
        }


    }

}
