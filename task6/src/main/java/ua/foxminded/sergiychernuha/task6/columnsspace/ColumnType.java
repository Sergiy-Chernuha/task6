package ua.foxminded.sergiychernuha.task6.columnsspace;

public enum ColumnType {
	NUMBERCOLUMN("No"), NAMECOLUMN("Name"), TEAMCOLUMN("Team"), LAPCOUNTCOLUMN("Lap Count"), BESTLAPCOLUMN("Best Lap Time"),
	AVGLAPCOLUMN("AVG Lap Time");

	String name;

	private ColumnType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
