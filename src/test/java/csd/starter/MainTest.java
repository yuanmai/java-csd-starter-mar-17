package csd.starter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MainTest {

	@BeforeClass
	public static void initCourtList(){
		CourtDatabase.courtList.add(new Court().setId(1).setLongitude(5).setLatitude(5));
		CourtDatabase.courtList.add(new Court().setId(2).setLongitude(10).setLatitude(10));
		CourtDatabase.courtList.add(new Court().setId(3).setLongitude(15).setLatitude(15));
		CourtDatabase.courtList.add(new Court().setId(4).setLongitude(200).setLatitude(200));
	}

	@AfterClass
	public static void clearCourtList(){
		CourtDatabase.courtList.clear();
	}

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
		}catch (Exception e){
			e.printStackTrace();
		}
		finally {
			System.setOut(stdout);
			System.setIn(stdin);
		}
	}

	/**
	 * pandalxb
	 * testFindCourt
	 */
	@Test
	public void testFindCourt(){
		String data = "FIND_COURT,15,15";
		InputStream stdin = System.in;
		PrintStream stdout = System.out;
		try {
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			System.setOut(new PrintStream(baos));
			Main.main(null);
			String result = baos.toString();
			Assert.assertEquals("3", result);
		}catch (Exception e){
			e.printStackTrace();
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
