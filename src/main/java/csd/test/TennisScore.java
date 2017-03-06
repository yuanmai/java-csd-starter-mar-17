package csd.test;

import com.google.common.collect.ImmutableMap;

/**
 * Created by CK on 2017/3/6.
 */
public class TennisScore {

    static ImmutableMap<Integer, String> map = ImmutableMap.of(0, "Love", 1, "Fifteen", 2, "Thirty", 3, "Forty");

    public static String point(int s1, int s2) {
        if (s1 <= 3 && s2 <= 3) {
            if (s1 == s2) return map.get(s1) + " All";
            else return map.get(s1) + " " + map.get(s2);
        }
        //
        else {
            if (s1 - s2 > 1) return "Game to Server";
            if (s2 - s1 > 1) return "Game to Receiver";
            if (s1 > s2) return "Advantage Server";
            if (s1 < s2) return "Advantage Receiver";
            else return "Deuce";
        }
    }
}
