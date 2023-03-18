package ua.foxminded.sergiychernuha.task6.columnsspace;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ua.foxminded.sergiychernuha.task6.tablesspace.TableDescriptor;
import ua.foxminded.sergiychernuha.task6.tablesspace.tablebank.BestLapTableDescriptor;

class BasicColumnSupplierTest {
	TableDescriptor tableType;

	@BeforeEach
	void init() {
		tableType = new BestLapTableDescriptor();
	}

	@ParameterizedTest
	@CsvSource({ "0,Best Lap Time", "1,Name", "2,Team", "3,Best Lap Time", "3333,Best Lap Time", "-353,Best Lap Time" })
	void whanIndexIsSomeIntegerAndBestLapTableDescriptor_thenMethodGetReturnSuitableOrDefauldColumn(int index,
			String titleColumn) {
		BasicColumnSupplier basicColumnSupplier = new BasicColumnSupplier(tableType, index);

		assertEquals(titleColumn, basicColumnSupplier.get().getTitle());
	}

	@ParameterizedTest
	@CsvSource({ "0,BESTLAPCOLUMN", "1,NAMECOLUMN", "2,TEAMCOLUMN", "3,BESTLAPCOLUMN", "3333,BESTLAPCOLUMN",
			"-353,BESTLAPCOLUMN" })
	void whanIndexIsSomeIntegerAndBestLapTableDescriptor_thenMethodGetTypeReturnSuitableOrDefauldColumnType(int index,
			ColumnType columnType) {
		BasicColumnSupplier basicColumnSupplier = new BasicColumnSupplier(tableType, index);

		assertEquals(columnType, basicColumnSupplier.getType());
	}
}
