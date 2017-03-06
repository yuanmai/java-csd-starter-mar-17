package csd.starter;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class MainTest {

//    @Test
//    public void lambda() {
//        Function<Integer, Integer> inc = (i) -> i + 1;
//
//        assertEquals(Integer.valueOf(2), inc.apply(2));
//    }

    @Test
    public void orderSuccess() throws ParseException {
        String inputText = "2017-03-05 01:00to2017-03-05 12:00end";
        System.setIn(new ByteArrayInputStream(inputText.getBytes()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Main.main(null);

        assertEquals("true", baos.toString());
    }

    @Test
    public void orderFaile() throws ParseException {
        String inputText = "2017-03-06 01:00to2017-03-05 12:00end";
        System.setIn(new ByteArrayInputStream(inputText.getBytes()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Main.main(null);

        assertEquals("false", baos.toString());
    }


}
