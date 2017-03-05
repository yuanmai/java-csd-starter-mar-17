package csd.starter;

import java.util.*;

/**
 * Created by liangxg on 2017/3/5.
 */
public class CourtService {

	private static List<Court> courts = new ArrayList<Court>();

	private static Map<Integer, Set<String>> ordered = new HashMap();

	static {
		Set set = new HashSet();
		set.add("8:00");
		set.add("22:00");
		courts.add(new Court(1, "奥网城", 20, set, 1, 1));
		courts.add(new Court(2, "奥林匹克", 15, set, 3, 2));
		courts.add(new Court(3, "京鼎", 20, set, 3, 3));
		courts.add(new Court(4, "五缘湾", 25, set, 4, 4));
		courts.add(new Court(5, "云顶山庄", 30, set, 2, 2));
	}

	public static List<Court> getCourt() {
		return courts;
	}

	public List<Court> getNearestCourt(int x, int y) {
		List<Court> cs = getCourt();
		Collections.sort(cs, new Comparator<Court>() {
			@Override
			public int compare(Court o1, Court o2) {
				int a = (int) (Math.pow(o1.getX() - x, 2) + Math.pow(o1.getY() - y, 2));
				int b = (int) (Math.pow(o2.getX() - x, 2) + Math.pow(o2.getY() - y, 2));
				return a - b;
			}
		});
		return cs;
	}

	public static boolean order(String name, int id, String date) {
		for (Court c : courts) {
			if (c.getId() == id) {
				break;
			}
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
