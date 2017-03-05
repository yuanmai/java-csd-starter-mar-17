package csd.starter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        boolean stop = true;

        while (stop) {
            System.out.print("choose your role (P / M):");
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                String role = RoleSelector.select(in.readLine());
                if (role.equals("M")) {
                    // TODO 绠＄悊鍛�
                } else if (role.equals("P")) {
                    // TODO 鐢ㄦ埛
                } else {
                    System.out.println("illegal role");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
