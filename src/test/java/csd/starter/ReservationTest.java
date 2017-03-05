package csd.starter;

import org.junit.Test;

import java.util.Date;
import java.util.Scanner;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class ReservationTest {


    @Test
    public void bookTest() {
        String memberId = "";
        String area = "";
        Date startDate = new Date();
        Date endDate = new Date();
        assertEquals(true, Reservator.getInstance().book(memberId, area, startDate, endDate));
        assertEquals(false, Reservator.getInstance().book(memberId, area, startDate, endDate));
    }

    @Test
    public void uat() {
        Scanner scanner = new Scanner("fake input");
        Scanner scanner1 = new Scanner(System.in);



    }

}
