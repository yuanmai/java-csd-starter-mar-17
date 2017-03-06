package csd.starter;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CourtServiceTest {
    @Before
    public void Before(){
        System.out.println("Before test Court");
    }

    @Test
    public void test_Court_fee_greater_than_zero(){
        CurtService courtService = new CurtService();
        List<Court> courts = courtService.getCurtTimeAndFee();
        assertTrue(courts.get(0).price>0);
    }


}
