package csd.starter;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class MainTest {

    final static int BUFFER_SIZE = 4096;

    @Test
    public void testMain() throws UnsupportedEncodingException {

        InputStream oldIn = System.in;
        PrintStream oldOut = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String in = "hello 1 2\nhello 1 2\nexit";
        System.setIn(new ByteArrayInputStream(in.getBytes("UTF-8")));
        System.setOut(new PrintStream(baos));

        Main.main(null);

        System.setIn(oldIn);
        System.setOut(oldOut);

        String[] allresult = baos.toString().split("\n");

        assertEquals("OK", allresult[0]);
        assertEquals("OK", allresult[1]);
        assertEquals("bye~", allresult[2]);
    }

}
