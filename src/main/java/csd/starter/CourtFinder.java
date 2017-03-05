package csd.starter;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by CK on 2017/3/5.
 */
public class CourtFinder {
    public static List<Court> courtList = new ArrayList<Court>();

    static{
        courtList.add(new Court().setId(1).setLongitude(5).setLatitude(5));
        courtList.add(new Court().setId(2).setLongitude(10).setLatitude(10));
        courtList.add(new Court().setId(3).setLongitude(15).setLatitude(15));
        courtList.add(new Court().setId(4).setLongitude(200).setLatitude(200));
    }

    public static int findCourt(double longitude, double latitude) {
        int id = 0;
        //return (int) (longitude / 5);
        double minDinstance = 999999999;
        for (int i = 0; i < courtList.size(); i++) {
            Court court = courtList.get(i);
            double dinstance = (longitude - court.getLongitude())*(longitude - court.getLongitude()) + (latitude - court.getLatitude())*(latitude - court.getLatitude());
            if(dinstance < minDinstance){
                minDinstance = dinstance;
                id = court.getId();
            }
        }

        return id;
    }
}
