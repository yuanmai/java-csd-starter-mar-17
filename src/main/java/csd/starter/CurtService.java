package csd.starter;

import java.util.ArrayList;
import java.util.List;



public class CurtService {
    public List<Court> getCurtTimeAndFee(){
        List<Court> courtList = new ArrayList<Court>();

        Court courtA = new Court();
        courtA.courtName = "courtA";
        courtA.price = 10;
        courtA.courtXY =  new int[]{1,2};


        Court courtB = new Court();
        courtA.courtName = "courtB";
        courtA.price = 20;
        courtA.courtXY =  new int[]{10,20};

        Court courtC = new Court();
        courtA.courtName = "courtC";
        courtA.price = 5;
        courtA.courtXY =  new int[]{50,20};
        courtList.add(courtA);
        courtList.add(courtB);
        courtList.add(courtC);
        return  courtList;
    }
}
