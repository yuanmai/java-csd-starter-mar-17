package csd.starter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReservatorTest {

    @Test
    public void bookTest() {
        String memberId = "";
        String courtName = "";
        String startDate = "";
        String endDate = "";

        Order successOrder = new Order(memberId, courtName, startDate, endDate, true);
        Order failOrder = new Order(memberId, courtName, startDate, endDate, false);
        assertEquals(successOrder, Reservator.getInstance().book(memberId, courtName, startDate, endDate));
        //assertEquals(failOrder, Reservator.getInstance().book(memberId, courtName, startDate, endDate));
    }
}
