package csd.starter.bean;

import java.util.Date;

/**
 * Created by wangsu on 2017/3/6.
 */
public class OrderBean {
	private String userName;
	private Date startTime;
	private Integer minutes;

	public OrderBean(String userName, Date startTime, Integer minutes) {
		this.userName = userName;
		this.startTime = startTime;
		this.minutes = minutes;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Integer getMinutes() {
		return minutes;
	}

	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}
}
