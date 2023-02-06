package ua.foxminded.sergiychernuha.task6.tablesspace;

import java.util.function.Supplier;

public interface TableDescriptorSupplier extends Supplier<TableDescriptor> {
	TableType getType();
}
