package ua.foxminded.sergiychernuha.task6.tablesspace;

public enum TableType {
	BESTLAPTABLE("Racers best lap"), NAMETABLE("Racers names"), LAPCOUNTTABLE("Racers lap count"),
	AVGLAPTABLE("Racers avg lap time");

	String name;

	private TableType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
