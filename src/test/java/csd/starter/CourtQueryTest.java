package csd.starter;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/5.
 */
public class CourtQueryTest {
    static List<Court> courts = new ArrayList<Court>();
    static {
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
    }
    @Test
    public void  test() {
        Member member = new Member();
        member.setLocation(new int[]{1, 2});
        Assert.assertEquals( "hecuo", CourtQuery.getNearestCourse( member, courts).courtName);

        member.setLocation(new int[]{3, 4});
        Assert.assertEquals( "xiada", CourtQuery.getNearestCourse( member, courts).courtName);

        member.setLocation(new int[]{1, 1});
        Assert.assertEquals( "ruanjianyuan", CourtQuery.getNearestCourse( member, courts).courtName);

        member.setLocation(new int[]{0, 1});
        Assert.assertEquals( "ruanjianyuan", CourtQuery.getNearestCourse( member, courts).courtName);
    }
}
