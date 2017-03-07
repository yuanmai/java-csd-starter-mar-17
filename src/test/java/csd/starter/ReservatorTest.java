package csd.starter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReservatorTest {

    @Test
    public void booking_the_same_court_with_the_same_day_should_be_fail() {
        String memberId = "m1";
        String courtName = "A1";
        String startDate = "2017-03-10";
        String endDate = "2017-03-10";

        assertEquals(
                new Order(memberId, courtName, startDate, endDate, true),
                Reservator.getInstance().booking(memberId, courtName, startDate, endDate)
        );
        assertEquals(
                new Order(memberId, courtName, startDate, endDate, false),
                Reservator.getInstance().booking(memberId, courtName, startDate, endDate)
        );
    }


    @Test
    public void booking_the_same_court_with_conflict_day_should_be_fail() {
        Reservator.getInstance().invalidate();

        String memberId = "m2";
        String courtName = "A2";
        String startDate = "2017-03-12";
        String endDate = "2017-03-12";

        assertEquals(
                new Order(memberId, courtName, startDate, endDate, true),
                Reservator.getInstance().booking(memberId, courtName, startDate, endDate)
        );

        endDate = "2017-03-13";

        assertEquals(
                new Order(memberId, courtName, startDate, endDate, false),
                Reservator.getInstance().booking(memberId, courtName, startDate, endDate)
        );

        startDate = "2017-03-15";
        endDate = "2017-03-14";

        assertEquals(
                new Order(memberId, courtName, startDate, endDate, false),
                Reservator.getInstance().booking(memberId, courtName, startDate, endDate)
        );

        courtName = "A2";
        startDate = "2017-03-15";
        endDate = "2017-03-14";

        assertEquals(
                new Order(memberId, courtName, startDate, endDate, false),
                Reservator.getInstance().booking(memberId, courtName, startDate, endDate)
        );
    }

    @Test
    public void booking_invalid_date() {
        Reservator.getInstance().invalidate();

        String memberId = "m2";
        String courtName = "A2";
        String startDate = "2017-02-28";
        String endDate = "2017-02-30";

        assertEquals(
                new Order(memberId, courtName, startDate, endDate, false),
                Reservator.getInstance().booking(memberId, courtName, startDate, endDate)
        );
    }
}
