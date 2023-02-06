package ua.foxminded.sergiychernuha.task6.columnsspace.columnsbank;

import java.util.Comparator;

import ua.foxminded.sergiychernuha.task6.Racer;
import ua.foxminded.sergiychernuha.task6.columnsspace.Column;
import ua.foxminded.sergiychernuha.task6.columnsspace.ColumnType;

public class LapCountColumn implements Column {
	ColumnType columnType;

	@Override
	public String getTitle() {
		return columnType.name();
	}

	@Override
	public String getData(Racer racer) {
		return "" + racer.getLapCount();
	}

	@Override
	public Comparator<Racer> getComparator() {
		return (racer1, racer2) -> Integer.compare(racer1.getLapCount(), racer2.getLapCount());
	}
}
