package csd.starter;

import java.util.HashMap;

/**
 * Created by wangsu on 2017/3/5.
 */
public class RommanService {

	private static HashMap<Integer, String> decimalRomanMap = new HashMap<>();
	private static HashMap<Integer, String> halfRomanMap = new HashMap<>();

	private static void init() {
		decimalRomanMap.put(1, "I");
		decimalRomanMap.put(10, "X");
		decimalRomanMap.put(100, "C");
		decimalRomanMap.put(1000, "M");

		halfRomanMap.put(1, null);
		halfRomanMap.put(10, "V");
		halfRomanMap.put(100, "L");
		halfRomanMap.put(1000, "D");
	}

	//获取位的对应值 100 200 1000 3000?
	private static String getWei(Integer value) {
		String decimalRoman = decimalRomanMap.get(value);
		Integer weiValue = value % 10;
		if (weiValue == 5) {
			return halfRomanMap.get(value);
		}
		return getSimpleRoman(weiValue).replace("V", halfRomanMap.get(value)) + decimalRoman;

	}

	/**
	 * 确定当前VALUE是什么级别的，个位数？十位数？百位数？
	 * @param value
	 * @return
	 */
	private static Integer checkDecimal(Integer value) {
		return 1;
	}

	private static String getSimpleRoman(Integer value) {
		switch (value) {
		case 1:
			return "I";
		case 2:
			return "II";
		case 3:
			return "III";
		case 4:
			return "IV";
		case 5:
			return "V";
		case 6:
			return "VI";
		case 7:
			return "VII";
		case 8:
			return "VIII";
		case 9:
			return "IX";
		default:
			return "";
		}
	}

	public static void main(String[] args) {
		System.out.println(1003%10);
		System.out.println(2000%10);
		System.out.println(300%10);
		System.out.println(40%10);
	}
}
