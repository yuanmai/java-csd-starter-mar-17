package csd.starter;

import java.util.Date;

import csd.starter.bean.OrderBean;

/**
 * Created by wangsu on 2017/3/5.
 */
public class OrderService {

	private static final String PROCESS_DATA_KEY = "ORDER_PROCESS_DATA_KEY";

	/**
	 * 预定
	 * @param userName
	 * @param startTime
	 * @param minutes
	 * @return
	 */
	public static Boolean order(String userName, Date startTime, Integer minutes) {
		if (null == userName || "".equals(userName)) {
			throw new RuntimeException("用户不可为空");
		}
		if (null == startTime) {
			throw new RuntimeException("预定开始时间不可为空");
		}
		if (null == minutes || minutes <= 0) {
			throw new RuntimeException("预定时长不可为空或者小于0");
		}
		if (startTime.getTime() - System.currentTimeMillis() < 0) {
			return false;
		}
		ProcessDataService.setData(PROCESS_DATA_KEY, new OrderBean(userName, startTime, minutes));
		return true;
	}

	public static OrderBean getCurrOrder() {
		Object obj = ProcessDataService.get(PROCESS_DATA_KEY);
		if (null == obj) {
			return null;
		}else {
			return (OrderBean) obj;
		}
	}
}
