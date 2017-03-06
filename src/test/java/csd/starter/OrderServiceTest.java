package csd.starter;

import csd.starter.entity.Order;
import csd.starter.entity.OrderForm;
import csd.starter.entity.OrderPayResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by suzf on 2017/3/5.
 */
public class OrderServiceTest {
    private OrderForm form = new OrderForm();

    @Before
    public void before() {
        //初始预约
        form.setCourtId(1);
        form.setUser("suzf");
        form.setOrderDate("2017-03-05");
        form.setHourStart(10);
        form.setHourEnd(12);
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

}
