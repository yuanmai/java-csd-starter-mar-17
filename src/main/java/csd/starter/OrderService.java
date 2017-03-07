package csd.starter;

import csd.starter.entity.Court;
import csd.starter.entity.Order;
import csd.starter.entity.OrderForm;
import csd.starter.entity.OrderPayResult;

import java.util.*;

/**
 * Created by liangxg on 2017/3/5.
 */
public class OrderService {

    private static List<Court> courts = new ArrayList<Court>();

    private static Map<Integer, Order> orders = new TreeMap<>();

    static {
        Set set = new HashSet();
        courts.add(new Court(1, "奥网城", 20, set, 1, 1));
        courts.add(new Court(2, "奥林匹克", 15, set, 3, 2));
        courts.add(new Court(3, "京鼎", 20, set, 3, 3));
        courts.add(new Court(4, "五缘湾", 25, set, 4, 4));
        courts.add(new Court(5, "云顶山庄", 30, set, 2, 2));
    }

    public static void clearOrders() {
        orders.clear();
        for (Court court : courts) {
            court.setOrderedTime(new HashSet<String>());
        }
    }

    public static List<Court> getCourt() {
        return courts;
    }


    public static List<Court> getNearestCourt(int x, int y) {
        return getNearestCourt(x, y, getCourt());
    }

    static List<Court> getNearestCourt(final int x, final int y, List<Court> cs) {
        Collections.sort(cs, new Comparator<Court>() {
            @Override
            public int compare(Court o1, Court o2) {
                int a = (int) (Math.pow(o1.getX() - x, 2) + Math.pow(o1.getY() - y, 2));
                int b = (int) (Math.pow(o2.getX() - x, 2) + Math.pow(o2.getY() - y, 2));
                return a - b;
            }
        });
        return cs;
    }

    private static Court getCourt(int id) {
        for (Court court : courts) {
            if (court.getId() == id) {
                return court;
            }
        }
        return null;
    }

    /**
     * 预约场地，冲突时，预约失败
     *
     * @param form
     * @return
     */
    public static Order order(OrderForm form) {
        if (isCourtAvailiable(form)) {
            return creatOrder(form);
        }
        return null;
    }

    /**
     * 判断场地是否可用
     *
     * @param form
     * @return
     */
    private static boolean isCourtAvailiable(OrderForm form) {
        //判断场地是否存在
        Court court = getCourt(form.getCourtId());
        if (court == null) {
            return false;
        }
        //判断场地是否时间冲突
        if (isOrderTimeConflict(court, form)) {
            return false;
        }
        return true;
    }

    /**
     * 新增订单
     *
     * @param form
     * @return
     */
    private static Order creatOrder(OrderForm form) {
        Court court = getCourt(form.getCourtId());
        Set<String> orderedTimes = form.getOrderTimes();
        Order order = new Order();
        order.setCourtId(form.getCourtId());
        order.setUsername(form.getUser());
        order.setDates(orderedTimes);
        order.setId(orders.size() + 1);
        order.setTotalPrice(court.getPrice() * orderedTimes.size());
        court.getOrderedTime().addAll(orderedTimes);
        orders.put(order.getId(), order);
        return order;
    }

    /**
     * 判断场地已预订时段是否与当前提交预订时段冲突
     *
     * @param court
     * @return
     */
    private static boolean isOrderTimeConflict(Court court, OrderForm form) {
        Set<String> orderTimes = form.getOrderTimes();
        Set<String> allSet = new HashSet<>();
        allSet.addAll(court.getOrderedTime());
        allSet.addAll(orderTimes);
        if (allSet.size() != court.getOrderedTime().size() + orderTimes.size()) {
            return true;
        }
        return false;
    }

    public static Order getOrder(int i) {
        return orders.get(i);
    }

    public static OrderPayResult payOrder(int i, double money) {
        Order order = getOrder(i);
        if (order == null) {
            return OrderPayResult.ORDER_NOT_FOUND;
        }
        if (order.isPaid()) {
            return OrderPayResult.PAID;
        }
        if (order.getTotalPrice() > money) {
            return OrderPayResult.NOT_ENOUGH;
        }
        order.setPaid(true);
        return OrderPayResult.SUCCESS;
    }
}
