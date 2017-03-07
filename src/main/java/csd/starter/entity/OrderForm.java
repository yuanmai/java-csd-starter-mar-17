package csd.starter.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by suzf on 2017/3/5.
 */
public class OrderForm {
    private int courtId;
    private String user;
    private String orderDate;
    private int hourStart;
    private int hourEnd;
    private String phone;

    public int getCourtId() {
        return courtId;
    }

    public void setCourtId(int courtId) {
        this.courtId = courtId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getHourStart() {
        return hourStart;
    }

    public void setHourStart(int hourStart) {
        this.hourStart = hourStart;
    }

    public int getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(int hourEnd) {
        this.hourEnd = hourEnd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<String> getOrderTimes() {
        int cursor = getHourStart();
        Set<String> orderedTimes = new HashSet<>();
        while (cursor <= getHourEnd()) {
            String time = getOrderDate() + " " + cursor + ":00";
            orderedTimes.add(time);
            cursor++;
        }
        return orderedTimes;
    }
}
