package csd.starter;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by CK on 2017/3/6.
 */
public class InformCenterTest {

    Information info;

    @Before
    public void before() {
        info = new Information();
        info.setSender("Jack");
        info.setReceiver("Rose");
        info.setCourt(new Court().setId(1).setLongitude(5).setLatitude(5));
    }

    @Test
    public void shouldInformAfterOrder() {
        assertEquals(true, InformCenter.send(info));
    }

    /*
    @Test
    public void shouldPrintInformation() {
        PrintStream stdout = System.out;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));

            String result = baos.toString();

            Assert.assertEquals(info.getInformation(), result);
        }
        finally {
            System.setOut(stdout);
        }
    }
    */

}
