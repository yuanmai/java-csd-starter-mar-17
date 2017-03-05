package csd.starter.entity;

import java.util.Set;

/**
 * Created by suzf on 2017/3/5.
 */
public class Order {
    private int id;
    private int courtId;
    private String username;
    private Set<String> dates;
    private double totalPrice;
    private String phone;

    private boolean paid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourtId() {
        return courtId;
    }

    public void setCourtId(int courtId) {
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

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
