package ua.foxminded.sergiychernuha.task6;

import java.time.Duration;
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
		this.bestLapTime = countBestLapTime(lapsTime);
		this.avgLapTime = countAvgLapTime(lapsTime);
		this.lapCount = lapsTime.size();
	}

	private Duration countBestLapTime(List<Duration> lapsTime) {
		Duration bestLap = lapsTime.get(0);

		for (int i = 1; i < lapsTime.size(); i++) {
			if (bestLap.getNano() < lapsTime.get(i).getNano()) {
				bestLap = lapsTime.get(i);
			}
		}

		return bestLap;
	}

	private Duration countAvgLapTime(List<Duration> lapsTime) {
		Duration avgLap = Duration.ofSeconds(0);

		for (Duration lap : lapsTime) {
			avgLap = avgLap.plus(lap);
		}

		return avgLap.dividedBy(lapsTime.size());
	}

	@Override
	public String toString() {
		return "\nRacer [id=" + id + ", name=" + name + ", teame=" + teame + ", lapsTime=" + lapsTime + ", bestLapTime="
				+ bestLapTime + ", avgLapTime=" + avgLapTime + ", lapCount=" + lapCount + "]";
	}

//	del new line every  string

}
