package csd.starter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by liangxg on 2017/3/5.
 */
public class Court {

	private static HashMap<Integer, String> courts = new HashMap<>();

	private static Map<Integer, Set<String>> ordered = new HashMap();

	static {
		courts.put(1, "奥网城");
		courts.put(2, "奥林匹克");
		courts.put(3, "京鼎");
		courts.put(4, "五缘湾");
		courts.put(5, "云顶山庄");
	}

	public static HashMap<Integer, String> getCourt() {
		return courts;
	}

	public static boolean order(String name, int id, String date) {
		if (!courts.containsKey(id)) {
			return false;
		}
		Set<String> set = ordered.get(id);
		if (set == null) {
			Set<String> s = new HashSet();
			s.add(date);
			ordered.put(id, s);
		}
		else if (!set.contains(date)) {
			set.add(date);
		}
		else {
			return false;
		}
		return true;
	}
}
