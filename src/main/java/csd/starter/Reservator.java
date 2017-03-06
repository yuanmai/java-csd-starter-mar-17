package csd.starter;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.text.SimpleDateFormat;
import java.util.List;
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


    public Order booking(String memberId, String courtName, String startDate, String endDate) {

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

    private boolean checkConflictCourtWithTime(Order order) {
        for (Order item : successOrders.values()) {
            if (item.courtName.equals(order.courtName)
                    && (
                        getTime(item.startDate) > getTime(order.endDate)
                            || getTime(item.endDate) < getTime(order.startDate)
                    )
                    ) {
                return false;
            }
        }
        return successOrders.isEmpty()?false:true;
    }

    private long getTime(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(date).getTime();
        } catch (Exception ex) {
            return 0;
        }
    }
}
