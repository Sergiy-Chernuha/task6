package ua.foxminded.sergiychernuha.task6.tablesspace.tablebank;

import java.util.Arrays;
import java.util.List;

import ua.foxminded.sergiychernuha.task6.columnsspace.ColumnType;
import ua.foxminded.sergiychernuha.task6.tablesspace.TableDescriptor;
import ua.foxminded.sergiychernuha.task6.tablesspace.TableType;

public class AvgLapDescriptor implements TableDescriptor {
	String title = TableType.AVGLAPTABLE.getName();
	List<ColumnType> columns = Arrays.asList(ColumnType.NUMBEROFCOLUMN,ColumnType.NAMECOLUMN, ColumnType.TEAMCOLUMN, ColumnType.AVGLAPCOLUMN);
	ColumnType defaultSortColumnType = ColumnType.AVGLAPCOLUMN;

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public List<ColumnType> getColumns() {
		return columns;
	}

	@Override
	public ColumnType getDefaultSortColumnType() {
		return defaultSortColumnType;
	}
}
