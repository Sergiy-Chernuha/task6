package ua.foxminded.sergiychernuha.task6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Duration;
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
		List<String> localListStart = new ArrayList<>(listStart);
		List<Duration> lapsTime = new ArrayList<>();
		List<Racer> racers = new ArrayList<>();
		String previousNameId = null;

		for (String timeFinish : listEnd) {
			String nameId = timeFinish.substring(0, 3);

			if (previousNameId != null && !previousNameId.equals(nameId)) {
				racers.add(new Racer(previousNameId, lapsTime, racerDescription.get(previousNameId)));
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
		racers.add(new Racer(previousNameId, lapsTime, racerDescription.get(previousNameId)));

		return addLoserRacers(racers, racerDescription);
	}

	private Duration calculationDurationLap(String start, String finish) {
		DateTimeFormatter formatterInputDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
		LocalDateTime startTime = LocalDateTime.parse(start, formatterInputDateTime);
		LocalDateTime finishTime = LocalDateTime.parse(finish, formatterInputDateTime);

		return Duration.between(startTime, finishTime);
	}

	private List<Racer> addLoserRacers(List<Racer> racers, Map<String, String> racerDescription) {
		List<Racer> everyRacers = new ArrayList<>(racers);
		List<Duration> lapsTimeLoserRacer;

		for (Map.Entry<String, String> oneRacer : racerDescription.entrySet()) {
			if (notContaineKey(oneRacer.getKey(), racers)) {
				lapsTimeLoserRacer = new ArrayList<>();
				lapsTimeLoserRacer.add(Duration.ZERO);
				everyRacers.add(new Racer(oneRacer.getKey(), lapsTimeLoserRacer, oneRacer.getValue()));
			}
		}

		return everyRacers;
	}

	private boolean notContaineKey(String key, List<Racer> racers) {
		boolean result = true;

		for (Racer oneRacer : racers) {
			if (oneRacer.getId().equals(key)) {
				result = false;
			}
		}

		return result;
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
