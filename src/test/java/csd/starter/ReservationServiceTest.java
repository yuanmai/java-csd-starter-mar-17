package csd.starter;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ReservationServiceTest {

	ReservationService service = new ReservationService();

	@Test
	public void reserve_avaliable() {
		Assert.assertTrue(service.reserve("场地1", Arrays.asList(1, 2)));
	}

	@Test
	public void reserve_unavaliable() {
		String court = "场地1";
		service.reserve(court, Arrays.asList(1, 2));
		Assert.assertTrue(!service.reserve(court, Arrays.asList(1)));
	}

}
