package br.ce.wcaquino.taskbackend.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {

	private static String pattern = "dd/MM/yyyy";

	public static boolean isEqualOrFutureDate(LocalDate date) {
		return isEqualOrFutureDate(date,LocalDate.now());
	}

	public static boolean isEqualOrFutureDate(LocalDate date, LocalDate compareted) {
		return date.isEqual(compareted) || date.isAfter(compareted);
	}

	public static boolean isEqualOrFutureDate(Date data) {
		return isEqualOrFutureDate(toLocalDate(data));
	}

	public static boolean isEqualOrFutureDate(Date data, Date compareted) {
		return isEqualOrFutureDate(toLocalDate(data),toLocalDate(compareted));
	}

	public static LocalDate toLocalDate(Date data){
		return Instant.ofEpochMilli(data.getTime())
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
	}

	public static Date toDate(String date){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}


}
