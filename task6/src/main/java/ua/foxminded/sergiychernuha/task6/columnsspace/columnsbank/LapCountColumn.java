package ua.foxminded.sergiychernuha.task6.columnsspace.columnsbank;

import java.util.Comparator;

import ua.foxminded.sergiychernuha.task6.Racer;
import ua.foxminded.sergiychernuha.task6.columnsspace.Column;
import ua.foxminded.sergiychernuha.task6.columnsspace.ColumnType;

public class LapCountColumn implements Column {

	@Override
	public String getTitle() {
		return ColumnType.LAPCOUNTCOLUMN.getName();
	}

	@Override
	public String getData(Racer racer) {
		return "" + racer.getLapCount();
	}

	@Override
	public Comparator<Racer> getComparator() {
		return (racer1, racer2) -> Integer.compare(racer2.getLapCount(), racer1.getLapCount());
	}
}
