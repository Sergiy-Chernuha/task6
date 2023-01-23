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

	public Racer(String id, List<Duration> lapsTime,String recerDescription) {
		super();
		String [] recerDescriptions= recerDescription.split("_");
		this.id = id;
		this.lapsTime = new ArrayList<>(lapsTime);
		this.name = recerDescriptions[0];
		this.teame = recerDescriptions[1];
		
	}

	@Override
	public String toString() {
		return "\nRacer [id=" + id + ", name=" + name + ", teame=" + teame + ", lapsTime=" + lapsTime + "]";
	}

//	del new line every  string



}
