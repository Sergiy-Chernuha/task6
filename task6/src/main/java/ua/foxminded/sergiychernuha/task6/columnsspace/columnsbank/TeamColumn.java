package ua.foxminded.sergiychernuha.task6.columnsspace.columnsbank;

import java.util.Comparator;

import ua.foxminded.sergiychernuha.task6.Racer;
import ua.foxminded.sergiychernuha.task6.columnsspace.Column;
import ua.foxminded.sergiychernuha.task6.columnsspace.ColumnType;

public class TeamColumn implements Column {

	@Override
	public String getTitle() {
		return ColumnType.TEAMCOLUMN.getName();
	}

	@Override
	public String getData(Racer racer) {
		return racer.getTeame();
	}

	@Override
	public Comparator<Racer> getComparator() {
		return (racer1, racer2) -> racer1.getTeame().compareTo(racer2.getTeame());
	}
}
