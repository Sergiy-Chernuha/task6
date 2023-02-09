package ua.foxminded.sergiychernuha.task6.columnsspace;

import ua.foxminded.sergiychernuha.task6.columnsspace.columnsbank.AVGLapColumn;
import ua.foxminded.sergiychernuha.task6.columnsspace.columnsbank.BestLapColumn;
import ua.foxminded.sergiychernuha.task6.columnsspace.columnsbank.LapCountColumn;
import ua.foxminded.sergiychernuha.task6.columnsspace.columnsbank.NameColumn;
import ua.foxminded.sergiychernuha.task6.columnsspace.columnsbank.TeamColumn;

public class ColumnFactory {

	private ColumnFactory() {
		super();
	}

	public static Column getColumn(ColumnType type) {
		if (type==ColumnType.NAMECOLUMN) {
			return new NameColumn();
		}
		if (type==ColumnType.AVGLAPCOLUMN) {
			return new AVGLapColumn();
		}
		if (type==ColumnType.LAPCOUNTCOLUMN) {
			return new LapCountColumn();
		}
		if (type==ColumnType.TEAMCOLUMN) {
			return new TeamColumn();
		}
		
		return new BestLapColumn();
	}
}
