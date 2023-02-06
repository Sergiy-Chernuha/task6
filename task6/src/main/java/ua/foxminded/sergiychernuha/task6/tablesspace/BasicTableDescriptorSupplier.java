package ua.foxminded.sergiychernuha.task6.tablesspace;

public class BasicTableDescriptorSupplier implements TableDescriptorSupplier {
	TableType type;

	public BasicTableDescriptorSupplier(int index) {
		super();
		this.type = getTableTypeByIndex(index);
	}

	@Override
	public TableDescriptor get() {
		return TableDescriptorFactory.getTable(type);
	}

	@Override
	public TableType getType() {
		return this.type;
	}

	public static String tableTypeRequest() {
		StringBuilder result = new StringBuilder();
		int i = 1;

		result.append("Select index of table type(some other for default)" + "\n");
		for (TableType s : TableType.values()) {
			result.append(i + ". " + s.getName() + ";\n");
			i++;
		}

		return result.toString();
	}

	public TableType getTableTypeByIndex(int typeNumber) {
		TableType result = null;
		int i = 1;

		for (TableType s : TableType.values()) {
			if (typeNumber == i) {
				result = s;
			}
			i++;
		}

		return (result == null ? TableType.BESTLAPTABLE : result);
	}
}
