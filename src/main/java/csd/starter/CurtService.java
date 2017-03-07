package csd.starter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class CurtService {
    private static   List<String> pubList = new LinkedList<>();
    public List<Court> getCurtTimeAndFee(){
        List<Court> courtList = new ArrayList<>();
        Court courtA = new Court();
        courtA.courtName = "courtA";
        courtA.price = 10;
        courtA.courtXY =  new int[]{1,2};

        Court courtB = new Court();
        courtB.courtName = "courtB";
        courtB.price = 20;
        courtB.courtXY =  new int[]{10,20};

        Court courtC = new Court();
        courtC.courtName = "courtC";
        courtC.price = 5;
        courtC.courtXY =  new int[]{50,20};
        courtList.add(courtA);
        courtList.add(courtB);
        courtList.add(courtC);
        return  courtList;
    }

    public String  pub(String courtName, int price, int[] courtXY) throws Exception {

        if(price < 0){
            throw new Exception();
        }
        if(!pubList.contains(courtName)) {
            pubList.add(courtName);
            return "pub succss";
        }else {
            return "pub fail";
        }
    }

    public void resetPubList(){
        pubList.clear();
    }


}
