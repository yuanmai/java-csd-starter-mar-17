package csd.starter;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.Scanner;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class MainTest {

//    @Test
//    public void lambda() {
//        Function<Integer, Integer> inc = (i) -> i + 1;
//
//        assertEquals(Integer.valueOf(2), inc.apply(2));
//    }

    @Test
    public void uat() throws ParseException {
//        Scanner scanner = new Scanner("fake input");
//        Scanner scanner1 = new Scanner(System.in);

//        System.setIn();
//        System.setOut();
//
//        Main.main();
        Assert.assertEquals(true,Main.reserve("2017-03-05 19:00","2017-03-05 21:00"));
        Assert.assertEquals(false,Main.reserve("2017-03-05 22:00","2017-03-05 21:00"));

    }


}
