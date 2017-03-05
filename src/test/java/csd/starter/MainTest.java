package csd.starter;

import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void lambda() {
        Function<Integer, Integer> inc = (i) -> i + 1;

        assertEquals(Integer.valueOf(2), inc.apply(2));
    }

    @Test
    public void uat() {
//        Scanner scanner = new Scanner("fake input");
//        Scanner scanner1 = new Scanner(System.in);
//
//        System.setIn();
//        System.setOut();
//
//        Main.main();

    }

}
