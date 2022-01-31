package org.ruskov.utils;

import java.util.HashMap;
import java.util.Map;

public class DaysMap {

	public static final Map<String, String> DAYS_EG_TO_FR = new HashMap<>();

	static {
		DAYS_EG_TO_FR.put("MONDAY", "Lundi");
		DAYS_EG_TO_FR.put("TUESDAY", "Mardi");
		DAYS_EG_TO_FR.put("WEDNESDAY", "Mercredi");
		DAYS_EG_TO_FR.put("THURSDAY", "Jeudi");
		DAYS_EG_TO_FR.put("FRIDAY", "Vendredi");
		DAYS_EG_TO_FR.put("SATURDAY", "Samedi");
		DAYS_EG_TO_FR.put("SUNDAY", "Dimanche");
	}

}
