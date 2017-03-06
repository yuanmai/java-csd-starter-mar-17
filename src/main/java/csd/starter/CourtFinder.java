package csd.starter;

/**
 * Created by CK on 2017/3/5.
 */
public class CourtFinder {
    /**
     * pandalxb
     *
     * @param longitude
     * @param latitude
     * @return
     */
    public static int findCourt(double longitude, double latitude) {
        int id = 0;
        //return (int) (longitude / 5);
        double minDistance = 999999999;
        for (int i = 0; i < CourtDatabase.courtList.size(); i++) {
            Court court = CourtDatabase.courtList.get(i);
            double distance = (longitude - court.getLongitude()) * (longitude - court.getLongitude()) + (latitude - court.getLatitude()) * (latitude - court.getLatitude());
            if (distance < minDistance) {
                minDistance = distance;
                id = court.getId();
            }
        }

        return id;
    }
}
