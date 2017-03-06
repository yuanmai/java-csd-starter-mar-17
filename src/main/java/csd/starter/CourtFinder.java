package csd.starter;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by CK on 2017/3/5.
 */
public class CourtFinder {
    /**
     * pandalxb
     * @param longitude
     * @param latitude
     * @return
     */
    public static int findCourt(double longitude, double latitude) {
        int id = 0;
        //return (int) (longitude / 5);
        double minDinstance = 999999999;
        for (int i = 0; i < CourtDatabase.courtList.size(); i++) {
            Court court = CourtDatabase.courtList.get(i);
            double dinstance = (longitude - court.getLongitude())*(longitude - court.getLongitude()) + (latitude - court.getLatitude())*(latitude - court.getLatitude());
            if(dinstance < minDinstance){
                minDinstance = dinstance;
                id = court.getId();
            }
        }

        return id;
    }
}
