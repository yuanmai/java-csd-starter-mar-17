package csd.starter;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
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
        Scanner scanner = new Scanner("fake input");
        Scanner scanner1 = new Scanner(System.in);

        String inputStr = "123344";
        InputStream inputStream = new ByteArrayInputStream(inputStr.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Main.main(null);

        assertEquals(inputStr,byteArrayOutputStream.toString().trim());
    }

}
