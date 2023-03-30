package ua.foxminded.sergiychernuha.task6;

import java.time.LocalDateTime;

public class Lap {
	private LocalDateTime start;
	private LocalDateTime finish;

	public Lap(LocalDateTime start, LocalDateTime finish) {
		super();
		this.start = start;
		this.finish = finish;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public LocalDateTime getFinish() {
		return finish;
	}
}
