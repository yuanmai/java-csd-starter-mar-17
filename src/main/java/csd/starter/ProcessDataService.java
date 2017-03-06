package csd.starter;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by wangsu on 2017/3/5.
 */
public class ProcessDataService {

	private static final HashMap<String, Object> dataCache = new HashMap<>();

	public static void setData(ProcessDataEnum key, Object obj) {
		if (StringUtils.isBlank(key.getKey())) {
			throw new RuntimeException("key is null!");
		}
		dataCache.put(key.getKey(), obj);
	}

	public static Object get(ProcessDataEnum key) {
		if (StringUtils.isBlank(key.getKey())) {
			throw new RuntimeException("key is null!");
		}
		return dataCache.get(key);
	}
}
