package ua.foxminded.sergiychernuha.task6.columnsspace.columnsbank;

import java.util.Comparator;

import ua.foxminded.sergiychernuha.task6.Racer;
import ua.foxminded.sergiychernuha.task6.columnsspace.Column;
import ua.foxminded.sergiychernuha.task6.columnsspace.ColumnType;

public class NumberColumn implements Column {

	@Override
	public String getTitle() {
		return ColumnType.NUMBERCOLUMN.getName();
	}

	@Override
	public String getData(Racer racer) {
		return "";
	}

	@Override
	public Comparator<Racer> getComparator() {
		return Comparator.comparing(Racer::getName);
	}
}
