package ua.foxminded.sergiychernuha.task6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class QualificationRaceApp {
	public static void main(String[] args) {
		
		Parser parser = new Parser();
		parser.makeListOfRacers();
		

//		List<String> inputListStart = new ArrayList<>();

//		try (BufferedReader bF = new BufferedReader(new FileReader("start.log"))) {
//			String line;
//			while ((line = bF.readLine()) != null) {
//				System.out.println(line);
//				inputListStart.add(line);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(inputListStart.get(0));
//
//		String timeLine1 = "2019-07-12_12:00:30.754";
//		String timeLine2 = inputListStart.get(0).substring(3);
//		String abr = inputListStart.get(0).substring(0,3);
//		System.out.println(abr);
//		System.out.println(timeLine1);
//		System.out.println(timeLine2);

//		_________________________
//		Date doFormat = null;
//		SimpleDateFormat format2=  new SimpleDateFormat("HH:mm:ss.S");
//		SimpleDateFormat format3;
//		try {
//			doFormat = format2.parse(timeLine1);
//			System.out.println(doFormat.getTime());
//		} catch (ParseException e) {
//						e.printStackTrace();
//		}
//
//		System.out.println(format2.format(doFormat));
//	______________________
//		DateTimeFormatter formatterInputDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
//		LocalDateTime startTime = LocalDateTime.parse(timeLine1, formatterInputDateTime);
//		LocalDateTime finishTime = LocalDateTime.parse(timeLine2, formatterInputDateTime);
//		LocalTime zeroTime= LocalTime.of(0,0,0,0);

//		DateTimeFormatter dtm2 = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
//		System.out.println(time1.format(dtm2));
//		System.out.println(time2.format(dtm2));
		
//		DateTimeFormatter dtm3 = DateTimeFormatter.ofPattern("m:ss.SSS");
//		Duration duration = Duration.between(startTime, finishTime);
//		System.out.println(duration.toString());
//	
//	
//		System.out.println(zeroTime.plus(duration.abs()).format(dtm3));


	}
}
