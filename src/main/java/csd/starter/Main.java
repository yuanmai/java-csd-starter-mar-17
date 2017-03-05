package csd.starter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.print("shu ru can shu: ");
		try {
			String resultStr = null;
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String param = in.readLine();
			if (param.startsWith("ORDER")) {
				String[] params = param.split(",");
				resultStr = OrderService.order(params[1], df.parse(params[2]), Integer.parseInt(params[3])).toString();
				System.out.println(resultStr);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
