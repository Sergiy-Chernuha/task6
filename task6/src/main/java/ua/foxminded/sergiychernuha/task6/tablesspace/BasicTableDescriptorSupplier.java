package ua.foxminded.sergiychernuha.task6.tablesspace;

import ua.foxminded.sergiychernuha.task6.TableProcessor;

public class BasicTableDescriptorSupplier implements TableDescriptorSupplier {
	int index;

	public BasicTableDescriptorSupplier(int index) {
		super();
		this.index = index;
	}

	@Override
	public TableType getType() {
		return TableProcessor.defineTableTypeByIndex(index);
	}

	@Override
	public TableDescriptor get() {
		return TableDescriptorFactory.getTable(this.getType());
	}
}
