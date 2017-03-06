package csd.starter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by weirq on 2017/3/5.
 */
public class RomainNumberTest {

    @Test
    public void test(){
        assertEquals("I",RomainNumber.switchTo(1));
        assertEquals("II",RomainNumber.switchTo(2));
        assertEquals("III",RomainNumber.switchTo(3));
        assertEquals("IV",RomainNumber.switchTo(4));
        assertEquals("V",RomainNumber.switchTo(5));
        assertEquals("VI",RomainNumber.switchTo(6));
        assertEquals("VII",RomainNumber.switchTo(7));
        assertEquals("VIII",RomainNumber.switchTo(8));
        assertEquals("IX",RomainNumber.switchTo(9));
        assertEquals("X",RomainNumber.switchTo(10));
        assertEquals("XI",RomainNumber.switchTo(11));
        assertEquals("XII",RomainNumber.switchTo(12));
        assertEquals("XIII",RomainNumber.switchTo(13));
        assertEquals("XIV",RomainNumber.switchTo(14));
        assertEquals("XV",RomainNumber.switchTo(15));
        assertEquals("XVI",RomainNumber.switchTo(16));
        assertEquals("XVII",RomainNumber.switchTo(17));
        assertEquals("XVIII",RomainNumber.switchTo(18));
        assertEquals("XIX",RomainNumber.switchTo(19));
        assertEquals("XX",RomainNumber.switchTo(20));
        assertEquals("XXI",RomainNumber.switchTo(21));
        assertEquals("XXIV",RomainNumber.switchTo(24));
        assertEquals("XXV",RomainNumber.switchTo(25));
        assertEquals("XXVI",RomainNumber.switchTo(26));
        assertEquals("XXIX",RomainNumber.switchTo(29));
        assertEquals("XXXIV",RomainNumber.switchTo(34));
        assertEquals("XXXV",RomainNumber.switchTo(35));
        assertEquals("XXXIX",RomainNumber.switchTo(39));
        assertEquals("XL",RomainNumber.switchTo(40));
        assertEquals("L",RomainNumber.switchTo(50));
        assertEquals("LI",RomainNumber.switchTo(51));
        assertEquals("LV",RomainNumber.switchTo(55));
        assertEquals("LX",RomainNumber.switchTo(60));
        assertEquals("LXV",RomainNumber.switchTo(65));
        assertEquals("LXXX",RomainNumber.switchTo(80));
        assertEquals("XC",RomainNumber.switchTo(90));
        assertEquals("XCIX",RomainNumber.switchTo(99));
        assertEquals("C",RomainNumber.switchTo(100));
        assertEquals("CC",RomainNumber.switchTo(200));
        assertEquals("CCC",RomainNumber.switchTo(300));
        assertEquals("CD",RomainNumber.switchTo(400));
        assertEquals("D",RomainNumber.switchTo(500));
        assertEquals("DC",RomainNumber.switchTo(600));
        assertEquals("DCC",RomainNumber.switchTo(700));
        assertEquals("DCCC",RomainNumber.switchTo(800));
        assertEquals("CM",RomainNumber.switchTo(900));
        assertEquals("CMXCIX",RomainNumber.switchTo(999));
        assertEquals("M",RomainNumber.switchTo(1000));
        assertEquals("MC",RomainNumber.switchTo(1100));
        assertEquals("MCD",RomainNumber.switchTo(1400));
        assertEquals("MD",RomainNumber.switchTo(1500));
        assertEquals("MDC",RomainNumber.switchTo(1600));
        assertEquals("MDCLXVI",RomainNumber.switchTo(1666));
        assertEquals("MDCCCLXXXVIII",RomainNumber.switchTo(1888));
        assertEquals("MDCCCXCIX",RomainNumber.switchTo(1899));
        assertEquals("MCM",RomainNumber.switchTo(1900));
        assertEquals("MCMLXXVI",RomainNumber.switchTo(1976));
        assertEquals("MCMLXXXIV",RomainNumber.switchTo(1984));
        assertEquals("MCMXC",RomainNumber.switchTo(1990));
        assertEquals("MM",RomainNumber.switchTo(2000));
        assertEquals("MMMCMXCIX",RomainNumber.switchTo(3999));
    }


}
