package csd.starter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void test() {
		String data = "ORDER,aa,2017-03-01 11:11:11,30";
		InputStream stdin = System.in;
		PrintStream stdout = System.out;
		try {
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			System.setOut(new PrintStream(baos));
			Main.main(null);
			String result = baos.toString();
			Assert.assertEquals("false", result);
		}
		finally {
			System.setOut(stdout);
			System.setIn(stdin);
		}
	}

	@Test
	public void lambda() {
		//        Function<Integer, Integer> inc = (i) -> i + 1;
		//
		//        assertEquals(Integer.valueOf(2), inc.apply(2));

	}

	@Test
	public void uat() {
		//        Scanner scanner = new Scanner("fake input");
		//        Scanner scanner1 = new Scanner(System.in);
		//
		//        System.setIn();
		//        System.setOut();
		//
		//        Main.main();

	}

}
