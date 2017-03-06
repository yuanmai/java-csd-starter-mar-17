package csd.starter;


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

			System.out.println("我是预约");
		}
		else if (str.equals("2")) {

			System.out.println("我是场地");
		}
		else if (str.equals("0")) {

			System.out.println("谢谢使用");
		}
		else {

			System.out.println("请输入正确的编号！");
			index();
		}

	}

}
