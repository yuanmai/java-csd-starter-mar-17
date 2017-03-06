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

	public static String get(Integer value) {
		Integer decimalValue = checkDecimal(value);
        String decimalRoman = decimalRomanMap.get(decimalValue);
		return null;

	}

    /**
     * 确定当前VALUE是什么级别的，个位数？十位数？百位数？
     * @param value
     * @return
     */
	private static Integer checkDecimal(Integer value) {
		return 1;
	}
}
