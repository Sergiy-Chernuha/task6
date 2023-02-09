package ua.foxminded.sergiychernuha.task6.columnsspace;

import ua.foxminded.sergiychernuha.task6.TableProcessor;
import ua.foxminded.sergiychernuha.task6.tablesspace.TableDescriptor;

public class BasicColumnSupplier implements ColumnSupplier {
	int index;
	TableDescriptor tableType;

	public BasicColumnSupplier(TableDescriptor tableType, int index) {
		super();
		this.index = index;
		this.tableType = tableType;
	}

	@Override
	public ColumnType getType() {
		return TableProcessor.defineSortColumnByIndex(tableType, index);
	}

	@Override
	public Column get() {
		return ColumnFactory.getColumn(getType());
	}
}
