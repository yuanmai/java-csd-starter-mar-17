package csd.starter;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by CK on 2017/3/5.
 */
public class CourtFinderTest {

    @BeforeClass
    public static void initCourtList() {
        CourtDatabase.courtList.add(new Court().setId(1).setLongitude(5).setLatitude(5));
        CourtDatabase.courtList.add(new Court().setId(2).setLongitude(10).setLatitude(10));
        CourtDatabase.courtList.add(new Court().setId(3).setLongitude(15).setLatitude(15));
        CourtDatabase.courtList.add(new Court().setId(4).setLongitude(200).setLatitude(200));
    }

    @AfterClass
    public static void clearCourtList() {
        CourtDatabase.courtList.clear();
    }

    @Test
    public void testShouldReturnNearestCourtId() {
        new CourtDatabase();
        new CourtFinder();

        assertEquals(1, CourtFinder.findNearestCourt(5, 5));

        assertEquals(1, CourtFinder.findNearestCourt(0, 0));

        assertEquals(2, CourtFinder.findNearestCourt(10, 10));

        assertEquals(3, CourtFinder.findNearestCourt(15.3, 15.3));

        assertEquals(4, CourtFinder.findNearestCourt(200, 200));

        assertEquals(4, CourtFinder.findNearestCourt(500, 500));
    }
}