package ua.foxminded.sergiychernuha.task6.columnsspace.columnsbank;

import java.util.Comparator;

import ua.foxminded.sergiychernuha.task6.ParserFunctions;
import ua.foxminded.sergiychernuha.task6.Racer;
import ua.foxminded.sergiychernuha.task6.columnsspace.Column;
import ua.foxminded.sergiychernuha.task6.columnsspace.ColumnType;

public class LapCountColumn implements Column, ParserFunctions {

	@Override
	public String getTitle() {
		return ColumnType.LAPCOUNTCOLUMN.getName();
	}

	@Override
	public String getData(Racer racer) {
		return "" + lAPCOUNT.apply(racer);
	}

	@Override
	public Comparator<Racer> getComparator() {
		return Comparator.comparing(lAPCOUNT::apply);
	}
}
