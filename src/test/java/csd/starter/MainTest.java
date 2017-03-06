package csd.starter;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
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

    @Test
    public void uat() {

        String inputStr = "123344";

        InputStream stdin = System.in;
        PrintStream stdout = System.out;
        OutputStream outputStream = new ByteArrayOutputStream();
        InputStream inputStream = new ByteArrayInputStream(inputStr.getBytes());

        try {
            System.setIn(inputStream);
            System.setOut(new PrintStream(outputStream));
            Main.main(null);

            assertEquals(inputStr, outputStream.toString().trim());
        }
        finally {
            System.setIn(stdin);
            System.setOut(stdout);
        }
    }


}
