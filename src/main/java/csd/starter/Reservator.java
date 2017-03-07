package csd.starter;

import com.google.common.collect.Maps;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Created by shenzx on 3/5/17.
 */
public class Reservator {
    private Map<String, Order> successOrders = Maps.newConcurrentMap();
    private static Reservator singleton = new Reservator();

    public static Reservator getInstance() {
        return singleton;
    }

    // 场景按天预订
    public Order booking(String memberId, String courtName, String startDate, String endDate) {
        if(!checkBookingDate(startDate, endDate)) {
            return new Order(memberId, courtName, startDate, endDate, false);
        }

        Order order = new Order(memberId, courtName, startDate, endDate, true);
        String courtKey = order.getKey();

        Order successOrder = successOrders.get(courtKey);
        if (successOrder == null) {
            if (checkConflictCourtWithTime(order)) {
                order.setStatus(false);
                return order;
            }
            successOrders.put(courtKey, order);
            return order;
        } else {
            order.setStatus(false);
            return order;
        }

    }

    private boolean checkBookingDate(String startDate, String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            sdf.setLenient(false);
            long sTime = sdf.parse(startDate).getTime();
            long eTime = sdf.parse(endDate).getTime();
            if(sTime > eTime) {
                //todo
                return false;
            }
        } catch (ParseException e) {
            // todo
            return false;
        }
        return true;
    }

    private boolean checkConflictCourtWithTime(Order order) {
        for (Order item : successOrders.values()) {
            if (!item.courtName.equals(order.courtName)) {
                continue;

            } else {
                if (getTime(item.startDate) > getTime(order.endDate)
                        || getTime(item.endDate) < getTime(order.startDate)) {
                    continue;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    private long getTime(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(date).getTime();
        } catch (ParseException e) {
            return 0;
        }
    }

    public void invalidate() {
        successOrders.clear();
    }
}
