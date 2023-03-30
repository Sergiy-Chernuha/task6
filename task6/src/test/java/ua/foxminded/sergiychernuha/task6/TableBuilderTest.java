package ua.foxminded.sergiychernuha.task6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ua.foxminded.sergiychernuha.task6.columnsspace.ColumnType;
import ua.foxminded.sergiychernuha.task6.tablesspace.TableDescriptor;

@ExtendWith(MockitoExtension.class)
class TableBuilderTest {
	@Mock
	TableProcessor tableProcessor;

	@Mock
	TableDescriptor tableDescriptor;

	@Mock
	List<ColumnType> columns;

	@Mock
	List<Racer> racers;

	@InjectMocks
	TableBuilder tableBuilder = new TableBuilder();

	@BeforeEach
	void init() {
		when(tableProcessor.getTableDescriptor()).thenReturn(tableDescriptor);
		when(tableDescriptor.getColumns()).thenReturn(columns);
		when(tableProcessor.getSortingDirection()).thenReturn(Comparator.comparing(ParserFunctions.BESTDURATION));
		when(tableProcessor.getDividerAfterRowOnBestLapTable()).thenReturn(-1);
		tableBuilder = new TableBuilder(tableProcessor, racers);
	}

	@Test
	void whanEveryFieldsInTableBuilderIsMocks_thenMethodBuildTableByStreamReturnEmptyString() {
		assertEquals("", tableBuilder.buildTableByStream());
		verify(racers, times(1)).stream();
		verify(racers, times(0)).size();
		verify(columns, times(1)).stream();
		verify(columns, times(2)).size();
		verify(columns, times(0)).get(0);
		verify(tableDescriptor, times(1)).getColumns();
	}
}
