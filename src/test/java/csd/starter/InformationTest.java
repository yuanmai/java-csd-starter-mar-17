package csd.starter;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by CK on 2017/3/6.
 */
public class InformationTest {

    @Test
    public void shouldReturnInformation() {
        Information info = new Information("Jack", "Rose", new Court().setId(1));
        String expectedMsg = "Jack sends to Rose, court: " + 1;

        assertEquals(expectedMsg, info.getMessage());
    }
}
