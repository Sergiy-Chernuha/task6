package ua.foxminded.sergiychernuha.task6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParserTest {
	Parser parser;

	@BeforeEach
	void init() {
		parser = new Parser();
	}

	@Test
	void whanEveryArgumentsIsEmpty_thenThrowStringIndexOutOfBoundsException() {
		String startFileName = " ";
		String finishFileName = "";
		String abbreviationFileName = "";

		assertThrowsExactly(StringIndexOutOfBoundsException.class,
				() -> parser.makeListOfRacers(startFileName, finishFileName, abbreviationFileName));
	}

	@Test
	void whanOneOrSeveralArgumentsIsNotContainsNameResource_thenThrowIllegalArgumentException() {
		String startFileName = "start.log";
		String finishFileName = "end.log";
		String abbreviationFileName = "abb";

		assertThrowsExactly(IllegalArgumentException.class,
				() -> parser.makeListOfRacers(startFileName, finishFileName, abbreviationFileName));
	}

	@Test
	void whanAllArgumensIsTrue_thenReturnListWith20Racers() {
		String startFileName = "start.log";
		String finishFileName = "end.log";
		String abbreviationFileName = "abbreviations.txt";
		List<Racer> listOfRacers = parser.makeListOfRacers(startFileName, finishFileName, abbreviationFileName);

		assertEquals(20, listOfRacers.size());
	}

	@Test
	void whanAllArgumensIsTrue_thenInFirstRacerAllFieldsAreCorrect() {
		String startFileName = "start.log";
		String finishFileName = "end.log";
		String abbreviationFileName = "abbreviations.txt";
		List<Racer> listOfRacers = parser.makeListOfRacers(startFileName, finishFileName, abbreviationFileName);
		int indexRacer = 0;

		assertEquals("VBM", listOfRacers.get(indexRacer).getId());
		assertEquals("Valtteri Bottas", listOfRacers.get(indexRacer).getName());
		assertEquals("MERCEDES", listOfRacers.get(indexRacer).getTeame());
		assertEquals(3, listOfRacers.get(indexRacer).getLapCount());
		assertEquals("1:25.750", listOfRacers.get(indexRacer).getBestLapTimeByString());
		assertEquals("1:25.505", listOfRacers.get(indexRacer).getAvgLapTimeByString());
	}

	@Test
	void whanAllArgumensIsTrue_thenInLastRacerAllFieldsAreCorrect() {
		String startFileName = "start.log";
		String finishFileName = "end.log";
		String abbreviationFileName = "abbreviations.txt";
		List<Racer> listOfRacers = parser.makeListOfRacers(startFileName, finishFileName, abbreviationFileName);
		int indexRacer = listOfRacers.size() - 1;

		assertEquals("RKW", listOfRacers.get(indexRacer).getId());
		assertEquals("Robert Kubica", listOfRacers.get(indexRacer).getName());
		assertEquals("WILLIAMS MERCEDES", listOfRacers.get(indexRacer).getTeame());
		assertEquals(0, listOfRacers.get(indexRacer).getLapCount());
		assertEquals("-:--.---", listOfRacers.get(indexRacer).getBestLapTimeByString());
		assertEquals("-:--.---", listOfRacers.get(indexRacer).getAvgLapTimeByString());
	}
}
