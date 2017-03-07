package csd.starter;

/**
 * Created by Administrator on 2017/3/7.
 */
public class FakeReservator extends Reservator {
    String courtName;
    public FakeReservator(String courtName) {
        this.courtName = courtName;
    }

    public Order booking(String memberId, String courtName, String startDate, String endDate) {
        if(courtName.equals(this.courtName)) {
            return new Order(memberId, courtName, startDate, endDate, true);
        } else {
            return new Order(memberId, courtName, startDate, endDate, false);
        }
    }
}
