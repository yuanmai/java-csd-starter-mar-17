package csd.starter;
import csd.starter.Court;
import csd.starter.Member;

import java.util.List;

/**
 * Created by Administrator on 2017/3/5.
 */
public class CourtQuery {
    public static Court getNearestCourse(Member member, List<Court> courts) {
        int[] pos = member.getLocation();

        int length = Integer.MAX_VALUE;
        Court court = null;
        for(Court c:courts){
            int newLen = (int)(Math.pow(c.courtXY[0]  -  member.getLocation()[0], 2) + Math.pow(c.courtXY[1]  -  member.getLocation()[1], 2));
            if(length > newLen ) {
                length = newLen;
                court = c;
            }
        }
        return court;
    }
}
