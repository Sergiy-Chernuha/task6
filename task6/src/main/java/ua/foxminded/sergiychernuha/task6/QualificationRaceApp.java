package ua.foxminded.sergiychernuha.task6;

import java.util.List;
import java.util.Scanner;

import ua.foxminded.sergiychernuha.task6.columnsspace.BasicColumnSupplier;
import ua.foxminded.sergiychernuha.task6.tablesspace.BasicTableDescriptorSupplier;

public class QualificationRaceApp {
	public static void main(String[] args) {

		Parser parser = new Parser();
		List<Racer> listOfRacers = parser.makeListOfRacers("start.log", "end.log", "abbreviations.txt");
		TableProcessor ourTable = new TableProcessor();
		int index = 0;
		BasicTableDescriptorSupplier myTableSupplier;
		BasicColumnSupplier myColumnSupplier;

		try (Scanner sc = new Scanner(System.in)) {
			System.out.print(ourTable.getTableTypeRequest());
			index = sc.nextInt();
			myTableSupplier = new BasicTableDescriptorSupplier(index);
			ourTable.setTableDescriptor(myTableSupplier.get());

			System.out.print(ourTable.getSortColumnRequest(myTableSupplier.get()));
			index = sc.nextInt();
			myColumnSupplier = new BasicColumnSupplier(myTableSupplier.get(), index);
			ourTable.setSortColumn(myColumnSupplier.get());

			System.out.println(ourTable.getSortingDirectionRequest(myColumnSupplier.getType()));
			index = sc.nextInt();
			ourTable.setSortingDirection(ourTable.defineSortingDirection(myColumnSupplier.get(), index));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		TableBuilder resultTable = new TableBuilder(ourTable, listOfRacers);
		System.out.println(resultTable.buildTable());
	}
}
