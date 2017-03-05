package csd.starter;

import java.util.Set;

/**
 * Created by liangxg on 2017/3/5.
 */
public class Court {

	private String name;
	private int id;
	private int price;
	private Set<String> orderedTime;
	private int x;
	private int y;

	public Court(int id, String name, int price, Set<String> orderedTime, int x, int y) {
		this.setId(id);
		this.setName(name);
		this.setPrice(price);
		this.setOrderedTime(orderedTime);
		this.setX(x);
		this.setY(y);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Set<String> getOrderedTime() {
		return orderedTime;
	}

	public void setOrderedTime(Set<String> orderedTime) {
		this.orderedTime = orderedTime;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
