package ua.foxminded.sergiychernuha.task6.tablesspace;

import ua.foxminded.sergiychernuha.task6.tablesspace.tablebank.AvgLapDescriptor;
import ua.foxminded.sergiychernuha.task6.tablesspace.tablebank.BestLapTableDescriptor;
import ua.foxminded.sergiychernuha.task6.tablesspace.tablebank.LapCountDescriptor;
import ua.foxminded.sergiychernuha.task6.tablesspace.tablebank.NameTableDescriptor;

public class TableDescriptorFactory {

	private TableDescriptorFactory() {
		super();
	}

	public static TableDescriptor getTable(TableType type) {
		if (type == TableType.NAMETABLE) {
			return new NameTableDescriptor();
		}
		if (type == TableType.LAPCOUNTTABLE) {
			return new LapCountDescriptor();
		}
		if (type == TableType.AVGLAPTABLE) {
			return new AvgLapDescriptor();
		}

		return new BestLapTableDescriptor();
	}
}
