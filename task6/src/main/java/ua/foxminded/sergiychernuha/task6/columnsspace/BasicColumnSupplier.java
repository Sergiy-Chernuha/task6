package ua.foxminded.sergiychernuha.task6.columnsspace;

import ua.foxminded.sergiychernuha.task6.tablesspace.TableType;

public class BasicColumnSupplier implements ColumnSupplier{

	@Override
	public ColumnType getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Column get() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSortingChange(TableType tableType) {
		StringBuilder result= new StringBuilder();
		result.append("Default sorting is "
				+tableType+ "\nDo you want change sorting? Input 1, if yes");
		
		return result.toString();
	}
}
