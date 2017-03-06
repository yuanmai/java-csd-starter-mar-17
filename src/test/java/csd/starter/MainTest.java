package csd.starter;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class MainTest {



    @Test
    public void lambda() {
        Function<Integer, Integer> inc = (i) -> i + 1;

        assertEquals(Integer.valueOf(3), inc.apply(2));

        assertEquals(new ArrayList<>(), new ArrayList<>());
    }

//    @Test
//    public void uat() {
//
//        String inputStr = "123344";
//
//        InputStream stdin = System.in;
//        PrintStream stdout = System.out;
//        OutputStream outputStream = new ByteArrayOutputStream();
//        InputStream inputStream = new ByteArrayInputStream(inputStr.getBytes());
//
//        try {
//            System.setIn(inputStream);
//            System.setOut(new PrintStream(outputStream));
//            Main.main(null);
//
//            assertEquals(inputStr, outputStream.toString().trim());
//        }
//        finally {
//            System.setIn(stdin);
//            System.setOut(stdout);
//        }
//    }

    @Test
    public void make_an_order() throws UnsupportedEncodingException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        InputStream oldIn = System.in;
        PrintStream oldOut = System.out;

        String in = "1\n1\nsuzf\n12345678\n2017-03-06\n10\n12";
        System.setIn(new BufferedInputStream(new ByteArrayInputStream(in.getBytes("UTF-8"))));
        System.setOut(new PrintStream(baos));
        Main.main(null);
        System.setIn(oldIn);
        System.setOut(oldOut);
        String content = baos.toString();
        Assert.assertTrue(content.contains("id=1"));
        System.out.println(content);
    }


}
