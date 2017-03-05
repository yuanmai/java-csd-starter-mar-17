package csd.starter;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class MainTest {

    final static int BUFFER_SIZE = 4096;

    @Test
    public void lambda() {
        Function<Integer, Integer> inc = (i) -> i + 1;

        assertEquals(Integer.valueOf(2), inc.apply(2));
    }

    @Test
    public void testMain() throws UnsupportedEncodingException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        InputStream oldIn = System.in;
        PrintStream oldOut = System.out;

        String in = "hello 1 2";
        System.setIn(new BufferedInputStream(new ByteArrayInputStream(in.getBytes("UTF-8"))));
        System.setOut(new PrintStream(baos));
        Main.main(null);
        System.setIn(oldIn);
        System.setOut(oldOut);
        String content = baos.toString();
        Assert.assertEquals("OK", content);
        System.out.println(content);
        //System.exit(0);
    }

}
