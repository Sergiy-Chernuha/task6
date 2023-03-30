package ua.foxminded.sergiychernuha.task6;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacerTest {

	@Test
	void whanRecerDescriptionIsNull_thenThrowNullPointerException() {
		String id = "asdf";
		List<Lap> laps = new ArrayList<>();
		String racerDescription = null;

		laps.add(null);

		assertThrowsExactly(NullPointerException.class, () -> new Racer(id, laps, racerDescription));
	}

	@ParameterizedTest
	@CsvSource({ "''", "_", "aaa_" })
	void whanRecerDescriptionNotContainDilimeterOrNothignAfterDelimeter_thenThrowArrayIndexOutOfBoundsException(
			String racerDescription) {
		String id = "asdf";
		List<Lap> laps = new ArrayList<>();

		laps.add(null);

		assertThrowsExactly(ArrayIndexOutOfBoundsException.class, () -> new Racer(id, laps, racerDescription));
	}

	@Test
	void whanLapsTimeIsNull_thenThrowNullPointerException() {
		String id = "asdf";
		List<Lap> laps = null;
		String racerDescription = "aaa_bbb";

		assertThrowsExactly(NullPointerException.class, () -> new Racer(id, laps, racerDescription));
	}
}
