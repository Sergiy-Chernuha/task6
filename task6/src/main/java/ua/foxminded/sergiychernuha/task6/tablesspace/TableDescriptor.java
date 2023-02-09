package ua.foxminded.sergiychernuha.task6.tablesspace;

import java.util.List;

import ua.foxminded.sergiychernuha.task6.columnsspace.ColumnType;

public interface TableDescriptor {
	String getTitle();
	 List<ColumnType> getColumns();
	 ColumnType getDefaultSortColumnType();
}
