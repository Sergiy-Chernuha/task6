package ua.foxminded.sergiychernuha.task6;

import java.util.ArrayList;
import java.util.List;

public class Racer {
	private final String id;
	private final String name;
	private final String teame;
	private final List<Lap> laps;

	public Racer(String id, List<Lap> laps, String recerDescription) {
		super();
		String[] racerDescriptions = recerDescription.split("_");
		this.id = id;
		this.name = racerDescriptions[0];
		this.teame = racerDescriptions[1];
		this.laps = new ArrayList<>(laps);
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

	public List<Lap> getLaps() {
		return laps;
	}
}
