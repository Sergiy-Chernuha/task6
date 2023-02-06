package ua.foxminded.sergiychernuha.task6.columnsspace;

import java.util.function.Supplier;

public interface ColumnSupplier extends Supplier<Column>{
	ColumnType getType();
}
