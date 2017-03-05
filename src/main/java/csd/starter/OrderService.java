package csd.starter;

import java.util.Date;

/**
 * Created by wangsu on 2017/3/5.
 */
public class OrderService {
	/**
	 * 预定
	 * @param userName
	 * @param startTime
	 * @param order
	 * @return
	 */
	public static boolean order(String userName, Date startTime, Integer order) {
		if (null == userName || "".equals(userName)) {
			throw new RuntimeException("用户不可为空");
		}
		if (null == startTime) {
			throw new RuntimeException("预定开始时间不可为空");
		}

		if (null == order || order <= 0) {
			throw new RuntimeException("预定时长不可为空或者小于0");
		}
		if (startTime.getTime() - System.currentTimeMillis() < 0) {
			return false;
		}
		return true;
	}
}
