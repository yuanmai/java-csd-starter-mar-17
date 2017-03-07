package csd.starter;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/3/7.
 */
public class VenueServiceTest {
    private static VenueService venueService;
    @BeforeClass
    public static void beforeClass(){
        venueService = new VenueService();
    }

    @Test
    public void findVenueByLocation(){
        Venue venue = venueService.findNearbyVenueByLocation(9.0, 9.0);
        Assert.assertEquals("Venue A",venue.getName());
        venue = venueService.findNearbyVenueByLocation(110.0, 110.0);
        Assert.assertEquals("Venue B",venue.getName());
        venue = venueService.findNearbyVenueByLocation(550.0, 550.0);
        Assert.assertEquals("Venue C",venue.getName());
    }
}
