package csd.starter;
import csd.starter.Court;
import csd.starter.Member;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/5.
 */
public class CourtQuery {
    public static Court getNearestCourt(Member member, List<Court> courts) {
        int minDistance = Integer.MAX_VALUE;
        Court nearestCourt = null;
        for(Court currentCourt:courts){
            int currentDistance = calculateDistance(member.getLocation(), currentCourt.courtXY);
            if(minDistance > currentDistance ) {
                minDistance = currentDistance;
                nearestCourt = currentCourt;
            }
        }
        return nearestCourt;
    }

    private static int calculateDistance(int[] memberPosition, int[] courtPosition) {
        return (int)(Math.pow(courtPosition[0]  -  memberPosition[0], 2) + Math.pow(courtPosition[1]  - memberPosition[1], 2));
    }

    public static Order memberReservation(Member member, String startDate, String endDate) {
        return memberReservation( new CurtService(), Reservator.getInstance(),member, startDate, endDate);
    }

    public static Order memberReservation(CurtService courtService, Reservator reservator, Member member, String startDate, String endDate) {
        List<Court> allCourts = courtService.getCurtTimeAndFee();
        Court nearestCourt = getNearestCourt(member, allCourts);
        return reservator.booking(member.getId(),nearestCourt.courtName, startDate, endDate);
    }
}
