package csd.starter;

import java.util.List;

/**
 * Created by Administrator on 2017/3/7.
 */
public class VenueService {

    public Venue findNearbyVenueByLocation(Double lat, Double lng) {
        List<Venue> venues = VenueStore.getVenues();

        Double currentDistance = Double.MAX_VALUE;
        Venue nearByVenue = null;

        for (Venue venue : venues) {
            Double distance = getDistance(venue.getLat(), venue.getLng(), lat, lng);
            System.out.println(String.format("%s-->%s,%s,%s,%s", String.valueOf(distance), String.valueOf(venue.getLat()), String.valueOf(venue.getLng()), String.valueOf(lat), String.valueOf(lng)));
            if (distance < currentDistance) {
                nearByVenue = venue;
                currentDistance = distance;
            }
        }

        return nearByVenue;
    }


    /**
     * 根据两个位置的经纬度，来计算两地的距离（单位为KM）
     * 参数为String类型
     *
     * @return
     */
    public static Double getDistance(Double lat1, Double lng1, Double lat2, Double lng2) {
        return Math.sqrt(Math.pow(Math.abs(lat1 - lat2), 2.0) + Math.pow(Math.abs(lng1-lng2),2.0));
    }
}
