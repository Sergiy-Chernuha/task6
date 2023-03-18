package ua.foxminded.sergiychernuha.task6;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Racer {
	private String id;
	private String name;
	private String teame;
	private Duration bestLapTime;
	private Duration avgLapTime;
	private int lapCount;

	public Racer(String id, List<Duration> lapsTime, String recerDescription) {
		super();
		String[] recerDescriptions = recerDescription.split("_");
		this.id = id;
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
		return (bestLapTime == Duration.ZERO ? Duration.ofDays(1) : bestLapTime);
	}

	public String getBestLapTimeByString() {
		return parseToString(bestLapTime);
	}

	public Duration getAvgLapTime() {
		return (avgLapTime == Duration.ZERO ? Duration.ofDays(1) : avgLapTime);
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
		Duration avgLap = Duration.ZERO;

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

	private String parseToString(Duration inputDuration) {
		LocalTime zeroTime = LocalTime.MIDNIGHT;
		DateTimeFormatter dtm = DateTimeFormatter.ofPattern("m:ss.SSS");

		return (inputDuration != Duration.ZERO) ? zeroTime.plus(inputDuration.abs()).format(dtm) : "-:--.---";
	}
}
