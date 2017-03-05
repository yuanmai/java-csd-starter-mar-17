package csd.starter;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * Created by shenzx on 3/5/17.
 */
public class NumberConvertor {

    private static Map<Integer, String> CONST = new ImmutableMap.Builder<Integer, String>()
            .put(1, "I")
            .put(5, "V")
            .put(10, "X")
            .put(50, "L")
            .put(100, "C")
            .put(500, "D")
            .put(1000, "M")
            .build();

    public static String arabic2roman(int i) {
        String rn = CONST.get(i);
        if (rn != null) {
            return rn;
        }
        rn = CONST.get(i + 1);
        if (rn != null) {
            return "I" + rn;
        }

        if (i < 4) {
            StringBuilder sb = new StringBuilder();
            for (int count = 0; count < i; count++) {
                sb.append("I");
            }
            return sb.toString();
        } else {
            StringBuilder sb = new StringBuilder("V");
            for (int count = 0; count < i - 5; count++) {
                sb.append("I");
            }
            return sb.toString();
        }

    }
}
