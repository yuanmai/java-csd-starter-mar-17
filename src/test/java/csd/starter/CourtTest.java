package csd.starter;

import csd.starter.entity.Court;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * todo describe this file
 *
 * @author linluxian
 * @version 1.0 2017/3/7
 * @since 1.0
 */
public class CourtTest {
	@Test
	public void testToString() {
		Set orderedTime = new HashSet<String>();
		orderedTime.add("time1");
		orderedTime.add("time2");
		Court court = new Court(1, "name", 1, orderedTime, 2, 2);
		System.out.println(court.toString());
		assertEquals("1,name,1,[time1, time2],(2,2)", court.toString());
	}
}
