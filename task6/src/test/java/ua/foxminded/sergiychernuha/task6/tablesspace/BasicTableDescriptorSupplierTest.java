package ua.foxminded.sergiychernuha.task6.tablesspace;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BasicTableDescriptorSupplierTest {

	@ParameterizedTest
	@CsvSource({ "0,Racers best lap", "1,Racers best lap", "2,Racers names", "3,Racers lap count",
			"4,Racers avg lap time", "-453,Racers best lap" })
	void whanIndexIsSomeInteger_thenMethodGetReturnSuitableOrDefauldColumn(int index, String titleTebleDescriptor) {
		BasicTableDescriptorSupplier basicTableDescriptorSupplier = new BasicTableDescriptorSupplier(index);

		assertEquals(titleTebleDescriptor, basicTableDescriptorSupplier.get().getTitle());
	}

	@ParameterizedTest
	@CsvSource({ "0,BESTLAPTABLE", "1,BESTLAPTABLE", "2,NAMETABLE", "3,LAPCOUNTTABLE", "4,AVGLAPTABLE",
			"-453,BESTLAPTABLE" })
	void whanIndexIsSomeInteger_thenMethodGetTypeReturnSuitableOrDefauldTableType(int index, TableType tableType) {
		BasicTableDescriptorSupplier basicTableDescriptorSupplier = new BasicTableDescriptorSupplier(index);

		assertEquals(tableType, basicTableDescriptorSupplier.getType());
	}
}
