package csd.starter;

/**
 * Created by weirq on 2017/3/5.
 */
public class RomainNumber {

    public static  String switchTo(int value) {
        String retStr = "";
        int thousands = value / 1000;
        int hundreds = ( value % 1000 ) / 100;
        int tens = ( value % 100 ) / 10;
        int digits = value % 10;
        retStr += genNumByPrefix('M',' ',' ',thousands);
        retStr += genNumByPrefix('C','D','M',hundreds);
        retStr += genNumByPrefix('X','L','C',tens);
        retStr += genNumByPrefix('I','V','X',digits);

        return retStr;
    }

    private static String  genNumByPrefix(char one,char five,char ten,int num){
        String retStr = "";
        if (num <= 3) {
            for (int i = 1; i <= num; i++) {
                retStr += one;
            }
        }
        else if (4 == num) {
            retStr += one;
            retStr += five;

        }
        else if ( num >= 5 && num < 9) {
            retStr += five;
            for (int i = 1; i + 5 <= num; i++)
            {
                retStr += one;
            }
        }
        else if (9 == num) {
            retStr += one;
            retStr += ten;
        }
        return retStr;
    }


}
