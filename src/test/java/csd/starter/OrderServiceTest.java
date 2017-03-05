package csd.starter;

import csd.starter.entity.Order;
import csd.starter.entity.OrderForm;
import csd.starter.entity.OrderPayResult;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by suzf on 2017/3/5.
 */
public class OrderServiceTest {
    @Test
    public void order() {
        //初始预约
        OrderForm form1 = new OrderForm();
        form1.setCourtId(1);
        form1.setUser("suzf");
        form1.setOrderDate("2017-03-05");
        form1.setHourStart(10);
        form1.setHourEnd(12);
        Order order1 = OrderService.order(form1);
        Assert.assertEquals(1, order1.getCourtId());
        Assert.assertEquals(60D, order1.getTotalPrice(), 0);

        //不存在场地预约
        OrderForm form2 = new OrderForm();
        form2.setCourtId(999999);
        form2.setUser("suzf");
        form2.setOrderDate("2017-03-05");
        form2.setHourStart(10);
        form2.setHourEnd(12);
        Assert.assertNull(OrderService.order(form2));

        //重复预约测试
        OrderForm form3 = new OrderForm();
        form3.setCourtId(1);
        form3.setUser("suzf");
        form3.setOrderDate("2017-03-05");
        form3.setHourStart(10);
        form3.setHourEnd(12);
        Assert.assertNull(OrderService.order(form3));
    }

    @Test
    public void payOrder() {
        //初始预约
        OrderForm form1 = new OrderForm();
        form1.setCourtId(1);
        form1.setUser("suzf");
        form1.setOrderDate("2017-03-05");
        form1.setHourStart(10);
        form1.setHourEnd(12);
        Order order1 = OrderService.order(form1);
        Assert.assertEquals(1, order1.getCourtId());
        Assert.assertEquals(60D, order1.getTotalPrice(), 0);

        //订单不存在
        Assert.assertEquals(OrderPayResult.ORDER_NOT_FOUND, OrderService.payOrder(2, 30D));
        //金额不足
        Assert.assertEquals(OrderPayResult.NOT_ENOUGH, OrderService.payOrder(1, 30D));
        //金额正常
        Assert.assertEquals(OrderPayResult.SUCCESS, OrderService.payOrder(1, 60D));
        //已付款
        Assert.assertEquals(OrderPayResult.PAID, OrderService.payOrder(1, 60D));

    }

}
