package csd.starter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CourtServiceTest {
    CurtService courtService = new CurtService();

    @Before
    public void Before(){
        System.out.println("Before test Court");
    }

    @Test
    public void test_Court_fee_greater_than_zero(){
        List<Court> courts = courtService.getCurtTimeAndFee();

        assertTrue(courts.get(0).price>0);
    }

    @Test(expected = Exception.class)
    public void test_pub_price_exception() throws Exception {
        courtService.pub("须毛球馆",-1,new int[]{0,0});
    }


    @Test
    public void test_pub_success() throws Exception {
        String msg = courtService.pub("须毛球馆",10,new int[]{0,0});

        assertEquals("pub succss", msg);
    }

    @Test
    public void test_pub_fail() throws Exception {
        courtService.pub("须毛球馆",10,new int[]{0,0});
        String msg = courtService.pub("须毛球馆",10,new int[]{0,0});

        assertEquals("pub fail", msg);
    }

    @After
    public void After(){
        courtService.resetPubList();
    }
}
