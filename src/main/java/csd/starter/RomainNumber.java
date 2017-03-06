package csd.starter;

import com.google.common.collect.ImmutableList;

/**
 * Created by weirq on 2017/3/5.
 */
public class RomainNumber {
    static String[][] dictArray = {{"","I","II","III","IV","V","VI","VII","VIII","IX"},
            {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
            {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
            {"","M","MM","MMM"}
    };
    public static  String switchTo(int value) {
        String retStr = "";
        for (int i = 0; i < 4; i++) {
            int single = value % 10;
            retStr = dictArray[i][single] + retStr;
            value = value / 10;
        }

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
