package ua.foxminded.sergiychernuha.task6;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ua.foxminded.sergiychernuha.task6.columnsspace.ColumnFactory;
import ua.foxminded.sergiychernuha.task6.columnsspace.ColumnType;
import ua.foxminded.sergiychernuha.task6.tablesspace.TableDescriptor;

public class TableBuilder {

	private TableDescriptor tableDescriptor;
	private Comparator<Racer> sortingDirection;
	private List<Racer> racers;

	public TableBuilder(TableProcessor tableProcessor, List<Racer> racers) {
		super();
		this.tableDescriptor = tableProcessor.getTableDescriptor();
		this.sortingDirection = tableProcessor.getSortingDirection();
		this.racers = racers;
	}

	public String buildTable() {
		Collections.sort(racers, sortingDirection);
		StringBuilder result = new StringBuilder();
		int i = 1;

		for (Racer racer : racers) {
			result.append(i + ". ");
			for (ColumnType column : tableDescriptor.getColumns()) {
				result.append(ColumnFactory.getColumn(column).getData(racer) + " | ");
			}
			result.append("\n");

			if (i == 15) {
				result.append("\n");
			}
			i++;
		}

		return result.toString();
	}
}
