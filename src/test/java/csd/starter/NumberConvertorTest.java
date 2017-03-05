package csd.starter;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shenzx on 3/5/17.
 */
public class NumberConvertorTest {


    @Test
    public void testArabic2Roman() {
        Assert.assertEquals("I", NumberConvertor.arabic2roman(1));
        Assert.assertEquals("II", NumberConvertor.arabic2roman(2));
        Assert.assertEquals("III", NumberConvertor.arabic2roman(3));
        Assert.assertEquals("IV", NumberConvertor.arabic2roman(4));
        Assert.assertEquals("V", NumberConvertor.arabic2roman(5));
        Assert.assertEquals("VI", NumberConvertor.arabic2roman(6));
        Assert.assertEquals("VII", NumberConvertor.arabic2roman(7));
        Assert.assertEquals("VIII", NumberConvertor.arabic2roman(8));
        Assert.assertEquals("IX", NumberConvertor.arabic2roman(9));
        Assert.assertEquals("X", NumberConvertor.arabic2roman(10));
/*
        Assert.assertEquals("X", NumberConvertor.arabic2roman(14));
        Assert.assertEquals("X", NumberConvertor.arabic2roman(15));


        Assert.assertEquals("L", NumberConvertor.arabic2roman(50));
        Assert.assertEquals("C", NumberConvertor.arabic2roman(100));
        Assert.assertEquals("D", NumberConvertor.arabic2roman(500));
        Assert.assertEquals("M", NumberConvertor.arabic2roman(1000));
*/
    }
}
