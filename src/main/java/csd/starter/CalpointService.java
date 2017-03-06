package csd.starter;

/**
 * Created by wangsu on 2017/3/6.
 */
public class CalpointService {
	public static String get(int x, int y) {
		//比分相等
		if (x == y) {
			if (x < 4) {
				return conver(x) + " All";
			}
			else {
				return "Deuce";
			}
		}
		//比分不相等
		int bigValue = x;
		int smallValue = y;
		if (x < y) {
			bigValue = y;
			smallValue = x;
		}
		if (bigValue >= 4) {
			if (bigValue - smallValue >= 2) {
				return "Game to " + getSf(x, bigValue);
			}
			else {
				return "Advantage " + getSf(x, bigValue);
			}
		}
		return conver(x) + " " + conver(y);

	}

	private static String getSf(int x, int checkValue) {
		if (checkValue == x) {
			return "Server";
		}
		else {
			return "Receiver";
		}

	}

	private static String conver(int i) {
		switch (i) {
		case 0:
			return "Love";
		case 1:
			return "Fifteen";
		case 2:
			return "Thirty";
		case 3:
			return "Forty";
		default:
			return "";
		}
	}
}
