package csd.starter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/7.
 */
public class VenueStore {
    public static List<Venue> getVenues(){
        List<Venue> venues = new ArrayList<>();

        venues.add(new Venue("Venue A",10.01028712333508,10.22593287666493));
        venues.add(new Venue("Venue B",100.01028712333508,100.22593287666493));
        venues.add(new Venue("Venue C",500.01028712333508,500.22593287666493));

        return venues;
    }
}
