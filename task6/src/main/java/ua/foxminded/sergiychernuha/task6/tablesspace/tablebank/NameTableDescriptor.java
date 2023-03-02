package ua.foxminded.sergiychernuha.task6.tablesspace.tablebank;

import java.util.Arrays;
import java.util.List;

import ua.foxminded.sergiychernuha.task6.columnsspace.ColumnType;
import ua.foxminded.sergiychernuha.task6.tablesspace.TableDescriptor;
import ua.foxminded.sergiychernuha.task6.tablesspace.TableType;

public class NameTableDescriptor implements TableDescriptor {

	@Override
	public String getTitle() {
		return TableType.NAMETABLE.getName();
	}

	@Override
	public List<ColumnType> getColumns() {
		return Arrays.asList(ColumnType.NUMBERCOLUMN, ColumnType.NAMECOLUMN);
	}

	@Override
	public ColumnType getDefaultSortColumnType() {
		return ColumnType.NAMECOLUMN;
	}
}
