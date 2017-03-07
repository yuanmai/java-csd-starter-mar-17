package csd.starter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2017/3/5.
 */
public class CourtQueryTest extends CurtService {
    List<Court> courts = new ArrayList<Court>();

    @Before
    public void before() {
        getCurtTimeAndFee();
    }

    @Test
    public void  returnInOneCourt() {
        Member member = new Member();
        member.setLocation(new int[]{1, 2});
        assertEquals( "hecuo", CourtQuery.getNearestCourt( member, courts).courtName);
    }

    @Test
    public void  returnInTwoCourt() {
        Member member = new Member();
        member.setLocation(new int[]{1, 1});
        assertEquals( "ruanjianyuan", CourtQuery.getNearestCourt( member, courts).courtName);
    }

    public List<Court> getCurtTimeAndFee(){
        int[] pos = {0, 0};
        Court c1 = new Court();
        c1.courtXY = pos;
        c1.courtName = "ruanjianyuan";
        courts.add(c1);

        int[] pos1 = {2, 2};
        c1 = new Court();
        c1.courtXY = pos1;
        c1.courtName = "hecuo";
        courts.add(c1);

        int[] pos2 = {4, 4};
        c1 = new Court();
        c1.courtXY = pos2;
        c1.courtName = "xiada";
        courts.add(c1);

        c1 = new Court();
        c1.courtXY = new int[]{4, 4};
        c1.courtName = "baicheng";
        courts.add(c1);
        return courts;
    }

    @Test
    public void reserveSuccess() {
        Member member = new Member();
        member.setLocation(new int[]{1, 2});
        Order memberOrder = CourtQuery.memberReservation(this, new FakeReservator("hecuo"),member,"","");
        assertTrue(memberOrder.isStatus());
    }

    @Test
    public void reserveFailure() {
        Member member = new Member();
        member.setLocation(new int[]{1, 1});
        Order memberOrder = CourtQuery.memberReservation(this, new FakeReservator("hecuo"),member,"","");
        assertTrue(!memberOrder.isStatus());
    }
}
