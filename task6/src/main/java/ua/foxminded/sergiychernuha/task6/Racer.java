package ua.foxminded.sergiychernuha.task6;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Racer {
	String id;
	String name;
	String teame;
	List<Duration> lapsTime;
	Duration bestLapTime;
	Duration avgLapTime;
	int lapCount;

	public Racer(String id, List<Duration> lapsTime, String recerDescription) {
		super();
		String[] recerDescriptions = recerDescription.split("_");
		this.id = id;
		this.lapsTime = new ArrayList<>(lapsTime);
		this.name = recerDescriptions[0];
		this.teame = recerDescriptions[1];
		this.bestLapTime = calculateBestLapTime(lapsTime);
		this.avgLapTime = calculateAvgLapTime(lapsTime);
		this.lapCount = calculateLapCount(lapsTime);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTeame() {
		return teame;
	}

	public Duration getBestLapTime() {
		return bestLapTime;
	}

	public String getBestLapTimeByString() {
		return parseToString(bestLapTime);
	}

	public Duration getAvgLapTime() {
		return avgLapTime;
	}

	public String getAvgLapTimeByString() {
		return parseToString(avgLapTime);
	}

	public int getLapCount() {
		return lapCount;
	}

	private Duration calculateBestLapTime(List<Duration> lapsTime) {
		Duration bestLap = lapsTime.get(0);

		for (int i = 1; i < lapsTime.size(); i++) {
			if (bestLap.getNano() < lapsTime.get(i).getNano()) {
				bestLap = lapsTime.get(i);
			}
		}

		return bestLap;
	}

	private Duration calculateAvgLapTime(List<Duration> lapsTime) {
		Duration avgLap = Duration.ofSeconds(0);

		for (Duration lap : lapsTime) {
			avgLap = avgLap.plus(lap);
		}

		return avgLap.dividedBy(lapsTime.size());
	}

	private int calculateLapCount(List<Duration> lapsTime) {
		int result = 0;

		if (!lapsTime.isEmpty() && lapsTime.get(0) != null && lapsTime.get(0).getNano() != 0) {
			result = lapsTime.size();
		}

		return result;
	}

	public String parseToString(Duration inputDuration) {
		LocalTime zeroTime = LocalTime.MIDNIGHT;
		DateTimeFormatter dtm = DateTimeFormatter.ofPattern("m:ss.SSS");

		return zeroTime.plus(inputDuration.abs()).format(dtm);
	}
}
