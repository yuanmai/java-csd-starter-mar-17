package csd.starter;

/**
 * Created by shenzx on 3/5/17.
 */
public class Reservator {

    public static Reservator getInstance() {
        return new Reservator();
    }


    public Order book(String memberId, String courtName, String startDate, String endDate) {
        //TODO:
        return new Order(memberId, courtName, startDate, endDate, true);
    }
}
