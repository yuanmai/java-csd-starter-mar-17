package csd.starter;


import java.util.*;

/**
 * Created by hongja on 2017/3/5.
 */
public class PremiumMemberBook {
    //常驻内存信息
    private static Map<String, Map<String, String>> premiumBookInfo = new HashMap<>();

    public static void premiumBook(Member member, Court court, String date) {
        if (member == null || member.getId() == null || court.courtName == null) {
            throw new RuntimeException("info can not be null ");
        }
        if (!member.isPremium()) {
            throw new RuntimeException(member.getName() + " is not a premium member,so you can't book ");
        }
        //常驻内存
        Map<String, String> bookInfoMap = new HashMap<>();
        bookInfoMap.put(court.courtName, date);
        premiumBookInfo.put(member.getId(), bookInfoMap);

        Reservator.getInstance().booking(member.getId(), court.courtName, date, date);
        Map<String, String> courtInfo = new HashMap<>();
        courtInfo.put(court.courtName, date);

        premiumBookInfo.put(member.getId(), courtInfo);
    }

    public static Map<String, Map<String, String>> getPremiumBookInfo() {
        return premiumBookInfo;
    }
}
