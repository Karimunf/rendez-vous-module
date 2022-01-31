package org.ruskov.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimeToDateConverter {

	public static LocalDate convertTimeToLocalDate(long time) {
		return Instant.ofEpochMilli(time).atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static LocalDateTime convertTimeToLocalDateTime(long time) {
		return Instant.ofEpochMilli(time).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
}
