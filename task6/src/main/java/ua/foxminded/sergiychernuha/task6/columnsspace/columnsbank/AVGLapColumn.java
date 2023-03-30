package ua.foxminded.sergiychernuha.task6.columnsspace.columnsbank;

import java.util.Comparator;

import ua.foxminded.sergiychernuha.task6.ParserFunctions;
import ua.foxminded.sergiychernuha.task6.Racer;
import ua.foxminded.sergiychernuha.task6.columnsspace.Column;
import ua.foxminded.sergiychernuha.task6.columnsspace.ColumnType;

public class AVGLapColumn implements Column,ParserFunctions {

	@Override
	public String getTitle() {
		return ColumnType.AVGLAPCOLUMN.getName();
	}

	@Override
	public String getData(Racer racer) {
		return PARSETOSTRING.apply(AVGLAPTIME.apply(racer));
	}

	@Override
	public Comparator<Racer> getComparator() {
		return Comparator.comparing(AVGLAPTIME::apply);
	}
}
