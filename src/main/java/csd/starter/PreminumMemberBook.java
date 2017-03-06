package csd.starter;


import java.util.*;

/**
 * Created by hongja on 2017/3/5.
 */
public class PreminumMemberBook {
    //常驻内存信息
    private static Map<String,Map<Court,String>> preminumBookInfo = new HashMap<String,Map<Court,String>>();
    public static void preminumBook(Member member,Court court,String date){
        if(member == null || member.getId()==null || court.courtName==null){
            throw new RuntimeException("info can not be null ");
        }
        if(!member.isPremium()){
            throw new RuntimeException(member.getName() + " is not a premium member,so you can't book ");
        }
        //常驻内存
        Map<Court,String> bookInfoMap = new HashMap<Court,String>();
        bookInfoMap.put(court,date);
        preminumBookInfo.put(member.getId(),bookInfoMap);

        Reservator.getInstance().booking(member.getId(),court.courtName,date,date);
        Map<Court,String> courtInfo = new HashMap<Court,String>();
        courtInfo.put(court,date);

        preminumBookInfo.put(member.getId(),courtInfo);
    }

    public static Map<String, Map<Court, String>> getPreminumBookInfo() {
        return preminumBookInfo;
    }
}
