package csd.starter;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainTest {


    @Test
    public void orderSuccess() throws Exception {
        String inputText = "2017030501-2017030512";
        System.setIn(new ByteArrayInputStream(inputText.getBytes()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Main.main(null);

        assertEquals(true, Boolean.valueOf(baos.toString()));
    }

    @Test
    public void orderFaileWhenEndTimeBeforStartTime() throws Exception {
        String inputText = "2017030601-2017030512";
        System.setIn(new ByteArrayInputStream(inputText.getBytes()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Main.main(null);

        assertEquals(false, Boolean.valueOf(baos.toString()));
    }

    @Test(expected = Exception.class)
    public void throwExceptionWhenParseTimeError() throws Exception {
        String inputText = "2017030601-201703051200";
        System.setIn(new ByteArrayInputStream(inputText.getBytes()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Main.main(null);
    }


}
