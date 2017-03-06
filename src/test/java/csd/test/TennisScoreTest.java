package csd.test;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by CK on 2017/3/6.
 */
public class TennisScoreTest {

    @Test
    public void testDeuce() {
        Assert.assertEquals("Deuce", TennisScore.point(4, 4));
    }

    @Test
    public void testAll() {
        Assert.assertEquals("Love All", TennisScore.point(0, 0));
        Assert.assertEquals("Fifteen All", TennisScore.point(1, 1));
        Assert.assertEquals("Thirty All", TennisScore.point(2, 2));
        Assert.assertEquals("Forty All", TennisScore.point(3, 3));
    }

    @Test
    public void testBelowForty() {
        Assert.assertEquals("Fifteen Love", TennisScore.point(1, 0));
        Assert.assertEquals("Thirty Fifteen", TennisScore.point(2, 1));
        Assert.assertEquals("Fifteen Forty", TennisScore.point(1, 3));
    }

    @Test
    public void testAdvantageServer() {
        Assert.assertEquals("Advantage Server", TennisScore.point(5, 4));
        Assert.assertEquals("Advantage Server", TennisScore.point(4, 3));
    }

    @Test
    public void testAdvantageReceiver() {
        Assert.assertEquals("Advantage Receiver", TennisScore.point(4, 5));
        Assert.assertEquals("Advantage Receiver", TennisScore.point(3, 4));
    }

    @Test
    public void testGameToServer() {
        Assert.assertEquals("Game to Server", TennisScore.point(7, 5));
        Assert.assertEquals("Game to Server", TennisScore.point(4, 0));
        Assert.assertEquals("Game to Server", TennisScore.point(4, 2));
    }

    @Test
    public void testGameToReceive() {
        Assert.assertEquals("Game to Receiver", TennisScore.point(2, 4));
        Assert.assertEquals("Game to Receiver", TennisScore.point(0, 4));
        Assert.assertEquals("Game to Receiver", TennisScore.point(5, 7));
    }
}
