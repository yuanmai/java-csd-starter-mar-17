package csd.starter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by CK on 2017/3/5.
 */
public class FindCourtTest {

    @Test
    public void testFind() {
        assertEquals(1, CourtFinder.findCourt(5, 5));
        assertEquals(2, CourtFinder.findCourt(10, 10));
        assertEquals(3, CourtFinder.findCourt(15.3, 15.3));
        assertEquals(4, CourtFinder.findCourt(200, 200));
    }
}
