package ua.foxminded.sergiychernuha.task6;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ua.foxminded.sergiychernuha.task6.columnsspace.ColumnFactory;
import ua.foxminded.sergiychernuha.task6.columnsspace.ColumnType;
import ua.foxminded.sergiychernuha.task6.tablesspace.TableDescriptor;

public class TableBuilder {

	private TableDescriptor tableDescriptor;
	private List<ColumnType> columns;
	private Comparator<Racer> sortingRule;
	private List<Racer> racers;
	private int dividerAfterRowOnBestLapTable;
	
	public TableBuilder() {
		super();
	}

	public TableBuilder(TableProcessor tableProcessor, List<Racer> racers) {
		super();
		this.tableDescriptor = tableProcessor.getTableDescriptor();
		this.columns = tableDescriptor.getColumns();
		this.sortingRule = tableProcessor.getSortingDirection();
		this.racers = racers;
		this.dividerAfterRowOnBestLapTable = tableProcessor.getDividerAfterRowOnBestLapTable();
	}

	public String buildTableByStream() {
		AtomicInteger x = new AtomicInteger(1);

		List<List<String>> dataLists = racers.stream().sorted(sortingRule)
				.map(racer -> columns.stream().map(columnType -> (ColumnFactory.getColumn(columnType)).getData(racer))
						.collect(Collectors.toList()))
				.peek(oneLine -> oneLine.set(0, x.getAndIncrement() + ".")).collect(Collectors.toList());

		int[] columnWidths = getColumnWidths(dataLists);
		String rowTemplate = buildRowTemplate(columnWidths);
		List<String> titleList = columns.stream().map(ColumnType::getName).collect(Collectors.toList());
		String header = buildRow(rowTemplate, titleList);
		Stream<String> bodyTable = dataLists.stream().map(data -> buildRow(rowTemplate, data)).map(row -> {
			if (dividerAfterRowOnBestLapTable != -1) {
				if (dividerAfterRowOnBestLapTable == 1 && row.substring(0, 3).equals(15 + ".")) {
					return row + "\n";
				}
				if (dividerAfterRowOnBestLapTable == 2 && row.substring(0, 2).equals((racers.size() - 15) + ".")) {
					return row + "\n";
				}
			}

			return row;
		});

		return Stream.concat(Stream.of(header), bodyTable).collect(Collectors.joining("\n"));
	}

	private String buildRow(String rowTemplate, List<String> dataOfRow) {
		return String.format(rowTemplate, dataOfRow.toArray());
	}

	private String buildRowTemplate(int[] columnWidths) {
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < columnWidths.length; i++) {
			result.append("%-" + columnWidths[i] + "s |");
		}

		return result.toString();
	}

	private int[] getColumnWidths(List<List<String>> dataLists) {
		int[] columnWidths = new int[columns.size()];

		for (int i = 0; i < columns.size(); i++) {
			columnWidths[i] = columns.get(i).getName().length();
		}

		for (List<String> line : dataLists) {
			for (int i = 0; i < line.size(); i++) {

				if (columnWidths[i] < line.get(i).length()) {
					columnWidths[i] = line.get(i).length();
				}
			}
		}

		return columnWidths;
	}
}
