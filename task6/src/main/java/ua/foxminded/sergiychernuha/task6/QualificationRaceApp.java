package ua.foxminded.sergiychernuha.task6;

public class QualificationRaceApp {
	public static void main(String[] args) {

		Parser parser = new Parser();
		System.out.println(parser.makeListOfRacers("start.log", "end.log", "abbreviations.txt"));

	}
}
