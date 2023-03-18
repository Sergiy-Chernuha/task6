package ua.foxminded.sergiychernuha.task6;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ua.foxminded.sergiychernuha.task6.columnsspace.ColumnType;
import ua.foxminded.sergiychernuha.task6.tablesspace.TableType;
import ua.foxminded.sergiychernuha.task6.tablesspace.tablebank.BestLapTableDescriptor;

class TableProcessorTest {
	TableProcessor tableProcessor;

	@BeforeEach
	void init() {
		tableProcessor = new TableProcessor();
	}

	@Test
	void whanCallMethodGetTableTypeRequest_thenReturnCorrectString() {
		String expected = "Select index of table type(some other number for default):\n" + "1. Racers best lap;\n"
				+ "2. Racers names;\n" + "3. Racers lap count;\n" + "4. Racers avg lap time;\n";

		assertEquals(expected, tableProcessor.getTableTypeRequest());
	}

	@ParameterizedTest
	@CsvSource({ "1,BESTLAPTABLE", "2,NAMETABLE", "3,LAPCOUNTTABLE", "4,AVGLAPTABLE", "5,BESTLAPTABLE",
			"0,BESTLAPTABLE", "35436543,BESTLAPTABLE", "-354,BESTLAPTABLE" })
	void whanCallMethodDefineTableTypeByIndexWithSomeInteger_thenReturnСorrespondingOrDefaultTableType(int index,
			TableType tableType) {

		assertEquals(tableType, TableProcessor.defineTableTypeByIndex(index));
	}

	@Test
	void whanCallMethodGetSortColumnRequestWithBestLapTableDescriptor_thenReturnCorrectString() {
		String expected = "Select index of sorting column(some other number for default):\n" + "1. Name;\n"
				+ "2. Team;\n" + "3. Best Lap Time;\n";

		assertEquals(expected, tableProcessor.getSortColumnRequest(new BestLapTableDescriptor()));
	}

	@ParameterizedTest
	@CsvSource({ "1,NAMECOLUMN", "2,TEAMCOLUMN", "3,BESTLAPCOLUMN", "4,BESTLAPCOLUMN", "5,BESTLAPCOLUMN",
			"0,BESTLAPCOLUMN", "35436543,BESTLAPCOLUMN", "-354,BESTLAPCOLUMN" })
	void whanCallMethodDefineSortColumnByIndexWithSomeInteger_thenReturnСorrespondingOrDefaultTableType(int index,
			ColumnType columnType) {

		assertEquals(columnType, TableProcessor.defineSortColumnByIndex(new BestLapTableDescriptor(), index));
	}

	@ParameterizedTest
	@CsvSource({ "BESTLAPCOLUMN,Ascending by best lap time", "NAMECOLUMN,Alphabetically by Name",
			"LAPCOUNTCOLUMN,Descending by Lap Count", "AVGLAPCOLUMN,Ascending by avg lap time",
			"TEAMCOLUMN,Alphabetically by Team", })
	void whanCallMethodGetSortingDirectionRequestWithEachColumnsType_thenReturnСorrespondingString(
			ColumnType columnType, String expectedSort) {
		String expected = "Default sorting is " + expectedSort + "\nInput 1, if you want reverse sorting";

		assertEquals(expected, tableProcessor.getSortingDirectionRequest(columnType));
	}
}
