package csd.starter;

/**
 * Created by wangsu on 2017/3/5.
 */
public enum ProcessDataEnum {
	ORDER("order"); //Ô¤¶¨¶©µ¥

	private String key;

	ProcessDataEnum(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}
