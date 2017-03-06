package csd.starter;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;

/**
 * Created by CK on 2017/3/6.
 */
public class InformCenterTest {

    Information info = new Information("Jack", "Rose", new Court().setId(1));

    @Test
    public void shouldInformAfterOrder() {
        assertEquals(true, InformCenter.send(info));
    }

    @Test
    public void shouldPrintInformation() {
        PrintStream stdout = System.out;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));

            InformCenter.send(info);
            String result = baos.toString();

            assertEquals(info.getMessage(), result);
        }
        finally {
            System.setOut(stdout);
        }
    }

}
