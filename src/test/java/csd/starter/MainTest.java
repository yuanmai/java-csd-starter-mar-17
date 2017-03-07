package csd.starter;

import csd.starter.entity.Court;
import csd.starter.entity.OrderForm;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainTest {

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

	@Test
	public void lambda() {
		Function<Integer, Integer> inc = (i) -> i + 1;

		assertEquals(Integer.valueOf(3), inc.apply(2));

		assertEquals(new ArrayList<>(), new ArrayList<>());
	}

	@Test
	public void make_an_order() throws UnsupportedEncodingException {

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		InputStream oldIn = System.in;
		PrintStream oldOut = System.out;

		String in = "1\n1\nsuzf\n12345678\n2017-03-06\n10\n12";
		System.setIn(new BufferedInputStream(new ByteArrayInputStream(in.getBytes("UTF-8"))));
		System.setOut(new PrintStream(byteArrayOutputStream));
		Main.main(null);
		System.setIn(oldIn);
		System.setOut(oldOut);

		System.out.println(byteArrayOutputStream.toString());
		assertTrue("最近场馆", byteArrayOutputStream.toString().contains("订单信息：\n"));
		assertTrue(byteArrayOutputStream.toString().contains(
				"Order{id=1, courtId=1, username='suzf', dates=[2017-03-06 11:00, 2017-03-06 12:00, 2017-03-06 10:00], totalPrice=60.0, phone='12345678', paid=false}\n"));
		System.out.println(byteArrayOutputStream.toString());
	}

	@Test
	public void 按距离展示场馆列表() {

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		InputStream oldIn = System.in;
		PrintStream oldOut = System.out;

		String input = "3\n4,4\n";
		System.setIn(new BufferedInputStream(new ByteArrayInputStream(input.getBytes())));
		System.setOut(new PrintStream(byteArrayOutputStream));
		Main.main(null);
		System.setIn(oldIn);
		System.setOut(oldOut);
		System.out.println(byteArrayOutputStream.toString());
		assertTrue("最近场馆", byteArrayOutputStream.toString().contains("最近场馆：\n"));

		String[] printLine = byteArrayOutputStream.toString().split("最近场馆：\n");

		assertTrue(printLine[1].startsWith("4,五缘湾"));
	}

	@Test
	public void 查询订单并结账成功() {

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		InputStream oldIn = System.in;
		PrintStream oldOut = System.out;

		String input = "4\n1\n40";
		System.setIn(new BufferedInputStream(new ByteArrayInputStream(input.getBytes())));
		System.setOut(new PrintStream(byteArrayOutputStream));

		OrderService.order(form);

		Main.main(null);

		System.setIn(oldIn);
		System.setOut(oldOut);

		System.out.println(byteArrayOutputStream.toString());

		assertTrue("打印订单信息", byteArrayOutputStream.toString().contains("订单信息：\n"));
		assertTrue("打印结账信息", byteArrayOutputStream.toString().contains("结账信息：\n"));
		String[] content1 = byteArrayOutputStream.toString().split("订单信息：\n");
		String[] content2 = byteArrayOutputStream.toString().split("结账信息：\n");

		//		assertTrue(content1[1].startsWith("1，小明，五缘湾，金额：30，未结账"));
		assertTrue(content1[1].startsWith("1,1,suzf,金额：60.0"));
		assertTrue(content2[1].startsWith("1,1,suzf,金额：60.0,收款：40,差额：-20.0"));
	}

}
