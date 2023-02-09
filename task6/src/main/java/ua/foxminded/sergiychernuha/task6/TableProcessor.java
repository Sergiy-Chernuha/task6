package ua.foxminded.sergiychernuha.task6;

import java.util.Comparator;

import ua.foxminded.sergiychernuha.task6.columnsspace.Column;
import ua.foxminded.sergiychernuha.task6.columnsspace.ColumnType;
import ua.foxminded.sergiychernuha.task6.tablesspace.TableDescriptor;
import ua.foxminded.sergiychernuha.task6.tablesspace.TableType;

public class TableProcessor {

	private TableDescriptor tableDescriptor;
	private Column sortColumn;
	private Comparator<Racer> sortingDirection;

	public TableProcessor() {
		super();
	}

	public TableDescriptor getTableDescriptor() {
		return tableDescriptor;
	}

	public void setTableDescriptor(TableDescriptor tableDescriptor) {
		this.tableDescriptor = tableDescriptor;
	}

	public Column getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(Column sortColumn) {
		this.sortColumn = sortColumn;
	}

	public Comparator<Racer> getSortingDirection() {
		return sortingDirection;
	}

	public void setSortingDirection(Comparator<Racer> sortingDirection) {
		this.sortingDirection = sortingDirection;
	}

	public String getTableTypeRequest() {
		StringBuilder result = new StringBuilder();
		int i = 1;

		result.append("Select index of table type(some other number for default):" + "\n");
		for (TableType s : TableType.values()) {
			result.append(i + ". " + s.getName() + ";\n");
			i++;
		}

		return result.toString();
	}

	public static TableType defineTableTypeByIndex(int typeNumber) {
		TableType result = null;
		int i = 1;

		for (TableType s : TableType.values()) {
			if (typeNumber == i) {
				result = s;
			}
			i++;
		}

		return (result == null ? TableType.BESTLAPTABLE : result);
	}

	public String getSortColumnRequest(TableDescriptor tableType) {
		StringBuilder result = new StringBuilder();
		int i = 1;

		result.append("Select index of sorting column(some other number for default):" + "\n");

		for (ColumnType s : tableType.getColumns()) {
			result.append(i + ". " + s.getName() + ";\n");
			i++;
		}

		return result.toString();
	}

	public static ColumnType defineSortColumnByIndex(TableDescriptor tableType, int index) {
		int i = 1;

		for (ColumnType s : tableType.getColumns()) {
			if (index == i) {
				return s;
			}
			i++;
		}

		return tableType.getDefaultSortColumnType();
	}

	public String getSortingDirectionRequest(ColumnType columnType) {
		String defaultSort = "";

		switch (columnType) {
		case BESTLAPCOLUMN:
			defaultSort = "Ascending by best lap time";
			break;
		case NAMECOLUMN:
			defaultSort = "Alphabetically by Name";
			break;
		case LAPCOUNTCOLUMN:
			defaultSort = "Descending by Lap Count";
			break;
		case AVGLAPCOLUMN:
			defaultSort = "Ascending by avg lap time";
			break;
		default:
			defaultSort = "Alphabetically by Team";
		}

		return "Default sorting is " + defaultSort + "\nInput 1, if you want reverse sorting";
	}

	public Comparator<Racer> defineSortingDirection(Column column, int index) {
		Comparator<Racer> comparator = column.getComparator();

		return (index == 1) ? comparator.reversed() : comparator;
	}
}
