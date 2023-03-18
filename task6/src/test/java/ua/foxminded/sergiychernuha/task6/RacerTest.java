package ua.foxminded.sergiychernuha.task6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacerTest {

	@Test
	void whanRecerDescriptionIsNull_thenThrowNullPointerException() {
		String id = "asdf";
		List<Duration> lapsTime = new ArrayList<>();
		String racerDescription = null;

		lapsTime.add(Duration.ZERO);

		assertThrowsExactly(NullPointerException.class, () -> new Racer(id, lapsTime, racerDescription));
	}

	@ParameterizedTest
	@CsvSource({ "''", "_", "aaa_" })
	void whanRecerDescriptionNotContainDilimeterOrNothignAfterDelimeter_thenThrowArrayIndexOutOfBoundsException(
			String racerDescription) {
		String id = "asdf";
		List<Duration> lapsTime = new ArrayList<>();

		lapsTime.add(Duration.ZERO);

		assertThrowsExactly(ArrayIndexOutOfBoundsException.class, () -> new Racer(id, lapsTime, racerDescription));
	}

	@Test
	void whanLapsTimeIsNull_thenThrowNullPointerException() {
		String id = "asdf";
		List<Duration> lapsTime = null;
		String racerDescription = "aaa_bbb";

		assertThrowsExactly(NullPointerException.class, () -> new Racer(id, lapsTime, racerDescription));
	}

	@Test
	void whanLapsTimeIsEmptyList_thenThrowIndexOutOfBoundsException() {
		String id = "asdf";
		List<Duration> lapsTime = new ArrayList<>();
		String racerDescription = "aaa_bbb";

		assertThrowsExactly(IndexOutOfBoundsException.class, () -> new Racer(id, lapsTime, racerDescription));
	}

	@Test
	void whanBestLapTimeEqualsZero_thenMethodGetBestLapTimeByStringReturnDefaultString() {
		List<Duration> lapsTime = new ArrayList<>();
		lapsTime.add(Duration.ZERO);
		Racer recer = new Racer("asdf", lapsTime, "aaa_bbb");
		String expected="-:--.---";

		assertEquals(expected, recer.getBestLapTimeByString());
	}
	
	@Test
	void whanBestLapTimeEqualsNotZero_thenMethodGetBestLapTimeByStringReturnThisTimeOnOurFormat() {
		List<Duration> lapsTime = new ArrayList<>();
		lapsTime.add(Duration.ofMillis(333));
		Racer recer = new Racer("asdf", lapsTime, "aaa_bbb");
		String expected="0:00.333";
		
		assertEquals(expected, recer.getBestLapTimeByString());
	}

}
