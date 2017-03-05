package csd.starter;

import java.util.Set;

/**
 * Created by suzf on 2017/3/5.
 */
public class Order {
    private String id;
    private String courtId;
    private String username;
    private Set<String> dates;
    private double totalPrice;
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourtId() {
        return courtId;
    }

    public void setCourtId(String courtId) {
        this.courtId = courtId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getDates() {
        return dates;
    }

    public void setDates(Set<String> dates) {
        this.dates = dates;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
