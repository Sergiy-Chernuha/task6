package ua.foxminded.sergiychernuha.task6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Parser {
	public List<Racer> makeListOfRacers(String startFileName, String finishFileName, String abbreviationFileName) {
		List<String> listStart = parseToLines(startFileName);
		List<String> listEnd = parseToLines(finishFileName);
		Map<String, String> racerDescription = parseListToMap(parseToLines(abbreviationFileName));
		List<String> localFinishList = new ArrayList<>(listEnd);

		List<Lap> laps = new ArrayList<>();
		List<Racer> racers = new ArrayList<>();
		String previousNameId = null;

		for (String startTime : listStart) {
			String nameId = startTime.substring(0, 3);
			if (previousNameId != null && !previousNameId.equals(nameId)) {
				racers.add(new Racer(previousNameId, laps, racerDescription.get(previousNameId)));
				laps.clear();
			}

			int i = 0;
			for (String finishTime : localFinishList) {
				if (nameId.equals(finishTime.substring(0, 3))) {
					laps.add(calculationLap(startTime.substring(3), finishTime.substring(3)));
					localFinishList.remove(finishTime);
					break;
				}
				i++;
				if (i == localFinishList.size() && laps.isEmpty()) {
					laps.add(calculationLap(startTime.substring(3), ""));
				}
			}
			previousNameId = nameId;
		}

		racers.add(new Racer(previousNameId, laps, racerDescription.get(previousNameId)));

		return racers;
	}

	private Lap calculationLap(String start, String finish) {
		DateTimeFormatter formatterInputDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
		LocalDateTime startTime = LocalDateTime.parse(start, formatterInputDateTime);
		LocalDateTime finishTime = finish.equals("") ? LocalDateTime.MAX
				: LocalDateTime.parse(finish, formatterInputDateTime);

		return new Lap(startTime, finishTime);
	}

	private List<String> parseToLines(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();

		try (InputStream is = classLoader.getResourceAsStream(fileName)) {
			if (is == null)
				throw new IllegalArgumentException("File " + fileName + " not exists in resources");
			try (InputStreamReader isr = new InputStreamReader(is); BufferedReader reader = new BufferedReader(isr)) {
				return reader.lines().collect(Collectors.toList());
			}
		} catch (IOException e) {
			throw new RuntimeException("Unable to read file " + fileName);
		}
	}

	private Map<String, String> parseListToMap(List<String> list) {
		return list.stream().collect(Collectors.toMap(x -> x.substring(0, 3), x -> x.substring(4)));
	}
}
