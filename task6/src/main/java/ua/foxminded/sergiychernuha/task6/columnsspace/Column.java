package ua.foxminded.sergiychernuha.task6.columnsspace;

import java.util.Comparator;

import ua.foxminded.sergiychernuha.task6.Racer;

public interface Column {
	String getTitle();
	String getData(Racer racer);
	Comparator<Racer> getComparator();
}
