package csd.starter;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by CK on 2017/3/6.
 */
public class InformationTest {

    @Test
    public void shouldReturnInformation() {
        Information info = new Information();
        info.setSender("Jack");
        info.setReceiver("Rose");
        info.setCourt(new Court().setId(1).setLongitude(5).setLatitude(5));

        assertEquals("Jack sends to Rose, court: " + 1, info.getInformation());
    }
}
