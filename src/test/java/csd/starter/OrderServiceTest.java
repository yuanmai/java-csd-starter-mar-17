package csd.starter;

import csd.starter.entity.Court;
import csd.starter.entity.Order;
import csd.starter.entity.OrderForm;
import csd.starter.entity.OrderPayResult;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by suzf on 2017/3/5.
 */
public class OrderServiceTest {
    private OrderForm form = new OrderForm();
    private List<Court> courts = new LinkedList<>();

    @Before
    public void before() {
        //初始预约
        form.setCourtId(1);
        form.setUser("suzf");
        form.setOrderDate("2017-03-05");
        form.setHourStart(10);
        form.setHourEnd(12);

        Set set = new HashSet();
        courts.add(new Court(1, "奥网城", 20, set, 1, 1));
        courts.add(new Court(2, "奥林匹克", 15, set, 3, 2));
        courts.add(new Court(3, "京鼎", 20, set, 3, 3));
        courts.add(new Court(4, "五缘湾", 25, set, 4, 4));
        courts.add(new Court(5, "云顶山庄", 30, set, 2, 2));
    }

    @After
    public void after() {
        OrderService.clearOrders();
    }

    @Test
    public void firstCourtOrderShouldBeSuccess() {

        Order order = OrderService.order(form);

        assertEquals(1, order.getCourtId());

        assertEquals(60D, order.getTotalPrice(), 0);
    }

    @Test
    public void nonexistCourtOrderShouldBeNull() {
        //不存在场地预约
        form.setCourtId(999999);

        assertNull(OrderService.order(form));
    }

    @Test
    public void repeatedCourtOrderShouldBeNull() {
        form.setCourtId(2);
        //重复预约测试
        OrderService.order(form);

        assertNull(OrderService.order(form));
    }

    @Test
    public void payNonexistOrderShouldFail() {
        OrderService.order(form);
        //订单不存在
        assertEquals(OrderPayResult.ORDER_NOT_FOUND, OrderService.payOrder(9999, 60D));
    }

    @Test
    public void payOrderWithLessMoneyShouldBeFail() {
        OrderService.order(form);
        //金额不足
        assertEquals(OrderPayResult.NOT_ENOUGH, OrderService.payOrder(1, 30D));
    }

    @Test
    public void payOrderWithEnoughMoneyShouldBeSuccess() {
        OrderService.order(form);
        //金额正常
        assertEquals(OrderPayResult.SUCCESS, OrderService.payOrder(1, 60D));
    }

    @Test
    public void payPaidOrderShouldBeFail() {
        OrderService.order(form);
        OrderService.payOrder(1, 60D);
        //已付款
        assertEquals(OrderPayResult.PAID, OrderService.payOrder(1, 60D));
    }



    @Test
    public void queryNearestCourtList(){
        List<Court> list = OrderService.getNearestCourt(1, 2, courts);
        Assert.assertEquals(1, list.get(0).getId());

        list = OrderService.getNearestCourt(4, 3, courts);
        Assert.assertEquals(3, list.get(0).getId());
        Assert.assertEquals(4, list.get(1).getId());
        Assert.assertEquals(2, list.get(2).getId());

    }

    @Test
    public void 周期预约(){

        OrderService.order(form);
        OrderService.payOrder(1, 60D);

    }




}
