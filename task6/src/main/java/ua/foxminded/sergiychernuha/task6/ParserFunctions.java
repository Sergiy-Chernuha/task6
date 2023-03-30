package ua.foxminded.sergiychernuha.task6;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.function.Function;

public interface ParserFunctions {

	public static final Function<Lap, Duration> lAPDURATION = lap -> lap.getFinish() == LocalDateTime.MAX
			? ChronoUnit.FOREVER.getDuration()
			: Duration.between(lap.getStart(), lap.getFinish());

	public static final Function<Racer, Lap> BESTLAP = racer -> racer.getLaps().stream()
			.max(Comparator.comparing(lAPDURATION)).orElse(new Lap(LocalDateTime.now(), LocalDateTime.now()));

	public static final Function<Racer, Duration> BESTDURATION = racer -> lAPDURATION.apply(BESTLAP.apply(racer));

	public static final Function<Racer, Duration> AVGLAPTIME = racer -> racer.getLaps().stream().map(lAPDURATION)
			.reduce(Duration.ZERO, (x, y) -> x.plus(y)).dividedBy(racer.getLaps().size());

	public static final Function<Duration, String> PARSETOSTRING = lapTime -> {
		LocalTime zeroTime = LocalTime.MIDNIGHT;
		DateTimeFormatter dtm = DateTimeFormatter.ofPattern("m:ss.SSS");

		return (lapTime.toDays() < 1) ? zeroTime.plus(lapTime.abs()).format(dtm) : "-:--.---";
	};

	public static final Function<Racer, Integer> lAPCOUNT = racer -> (racer.getLaps().get(0)
			.getFinish() == LocalDateTime.MAX) ? 0 : racer.getLaps().size();
}
