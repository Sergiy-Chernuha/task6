package ua.foxminded.sergiychernuha.task6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {

	public List<Racer> makeListOfRacers(String start, String finish, String abbreviation) {
		List<String> listStart = this.parseToLaps(start);
		List<String> listEnd = this.parseToLaps(finish);
		Map<String, String> recerDescription = parseToAbbreviations(abbreviation);
		List<String> localListStart = new ArrayList<>(listStart);
		List<Duration> lapsTime = new ArrayList<>();
		List<Racer> racers = new ArrayList<>();
		String previousNameId = null;

		for (String timeFinish : listEnd) {
			String nameId = timeFinish.substring(0, 3);

			if (previousNameId != null && !previousNameId.equals(nameId)) {
				racers.add(new Racer(previousNameId, lapsTime, recerDescription.get(previousNameId)));
				lapsTime.clear();
			}

			for (String timeStart : localListStart) {
				if (nameId.equals(timeStart.substring(0, 3))) {
					lapsTime.add(calculationDurationLap(timeStart.substring(3), timeFinish.substring(3)));
					localListStart.remove(timeStart);
					break;
				}
			}
			previousNameId = nameId;
		}
		racers.add(new Racer(previousNameId, lapsTime, recerDescription.get(previousNameId)));

		return racers;
	}

	private Duration calculationDurationLap(String start, String finish) {
		DateTimeFormatter formatterInputDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
		LocalDateTime startTime = LocalDateTime.parse(start, formatterInputDateTime);
		LocalDateTime finishTime = LocalDateTime.parse(finish, formatterInputDateTime);

		return Duration.between(startTime, finishTime);
	}

	private List<String> parseToLaps(String fileName) {
		List<String> resultList = new ArrayList<>();

		try (BufferedReader bF = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = bF.readLine()) != null) {
				resultList.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return resultList;
	}

	private Map<String, String> parseToAbbreviations(String fileName) {
		Map<String, String> resultMap = new HashMap<>();

		try (BufferedReader bF = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = bF.readLine()) != null) {
				resultMap.put(line.substring(0, 3), line.substring(4));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return resultMap;
	}

}
