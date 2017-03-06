package csd.starter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.collect.Lists;

/**
 * 预约接口
 * @author wangsf
 * @date 2017年3月5日
 * @version $Revision$
 */
public class ReservationService {

	private Map<String, List<Integer>> reservationInfo = new HashMap<>();

	public boolean reserve(String site, List<Integer> duration) {

		List<Integer> reservationDuration = reservationInfo.get(site);
		if (reservationDuration == null) {
			reservationDuration = Lists.newArrayList();
			reservationInfo.put(site, reservationDuration);
		}
		if (CollectionUtils.containsAny(reservationDuration, duration)) {
			return false;
		} else {
			reservationDuration.addAll(duration);
		}

		return true;
	}

}