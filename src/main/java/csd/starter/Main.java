package csd.starter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Main {
	public static void main(String[] args) throws Exception{
		CourtDatabase.courtList.clear();
		CourtDatabase.courtList.add(new Court().setId(1).setLongitude(5).setLatitude(5));
		CourtDatabase.courtList.add(new Court().setId(2).setLongitude(10).setLatitude(10));
		CourtDatabase.courtList.add(new Court().setId(3).setLongitude(15).setLatitude(15));
		CourtDatabase.courtList.add(new Court().setId(4).setLongitude(200).setLatitude(200));

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String resultStr = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String param = in.readLine();
		if (param.startsWith("ORDER")) {
			String[] params = param.split(",");
			resultStr = OrderService.order(params[1], df.parse(params[2]), Integer.parseInt(params[3])).toString();
			System.out.print(resultStr);
		}else if(param.startsWith("FIND_COURT")){
			String[] params = param.split(",");
			int id = CourtFinder.findCourt(Double.valueOf(params[1]), Double.valueOf(params[2]));
			resultStr = String.valueOf(id);
			System.out.print(resultStr);
		}
	}

}
