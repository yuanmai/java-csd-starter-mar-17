package csd.starter;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CourtServiceTest {
    @Test
    public void testCourt(){
        CurtService courtService = new CurtService();
        List<Court> courts = courtService.getCurtTimeAndFee();
        assertNotNull(courts);
        assertTrue(courts.get(0).price>0);

    }
}
