package csd.starter;

import java.util.Arrays;

/**
 * Created by shenzx on 3/5/17.
 */
public class Order {
    private String memberId;
    public String courtName;
    String startDate;
    String endDate ;
    private boolean status;

    public Order(String memberId, String courtName, String startDate, String endDate, boolean status) {
        this.memberId = memberId;
        this.courtName = courtName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (status != order.status) return false;
        if (!memberId.equals(order.memberId)) return false;
        if (!courtName.equals(order.courtName)) return false;
        if (!startDate.equals(order.startDate)) return false;
        return endDate.equals(order.endDate);

    }

    @Override
    public int hashCode() {
        int result = memberId.hashCode();
        result = 31 * result + courtName.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + (status ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId='" + memberId + '\'' +
                ", courtName='" + courtName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", status=" + status +
                '}';
    }

    public String getKey() {
        return courtName + "|" + startDate + "|" + endDate;
    }
}
