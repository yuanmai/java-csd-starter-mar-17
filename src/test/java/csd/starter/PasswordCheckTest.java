package csd.starter;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by luxb on 2017/3/7.
 */
public class PasswordCheckTest {

    @Test
    public void test(){
        Assert.assertEquals(false, PasswordCheck.checkPassword(null));

        Assert.assertEquals(false, PasswordCheck.checkPassword("abc"));

        Assert.assertEquals(false, PasswordCheck.checkPassword("aaWFOINEFOWNEFOLSss"));

        Assert.assertEquals(false, PasswordCheck.checkPassword("129791949173874197"));

        Assert.assertEquals(false, PasswordCheck.checkPassword("JFOEOWoejwo2783792"));

        Assert.assertEquals(true, PasswordCheck.checkPassword("FNWIIKKkjf2382^$%@@"));
    }
}
