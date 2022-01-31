package org.ruskov.configurations;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.ruskov.enumerations.DayType;
import org.ruskov.models.Availability;
import org.ruskov.models.Hour;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AvailabilityBeanGenerator {

	@Bean("availability1")
	@Scope("prototype")
	public Availability generateAvailability1() {
		Availability av = new Availability();

		av.setDay(DayType.Lundi);

		List<Hour> hours = new ArrayList<>();

		LocalTime time = LocalTime.of(8, 0);

		for (int i = 0; i < 20; ++i) {
			Hour hour = new Hour(time.getHour(), time.getMinute(), false);
			hour.setAvailability(av);
			hours.add(hour);
			time = time.plusMinutes(30);
		}

		av.setHours(hours);
		return av;
	}

	@Bean("availability2")
	@Scope("prototype")
	public Availability generateAvailability2() {
		Availability av = new Availability();

		av.setDay(DayType.Mardi);
		List<Hour> hours = new ArrayList<>();

		LocalTime time = LocalTime.of(8, 0);

		for (int i = 0; i < 20; ++i) {
			Hour hour = new Hour(time.getHour(), time.getMinute(), false);
			hour.setAvailability(av);
			hours.add(hour);
			time = time.plusMinutes(30);
		}

		av.setHours(hours);
		return av;
	}

	@Bean("availability3")
	@Scope("prototype")
	public Availability generateAvailability3() {
		Availability av = new Availability();

		av.setDay(DayType.Mercredi);
		List<Hour> hours = new ArrayList<>();

		LocalTime time = LocalTime.of(8, 0);

		for (int i = 0; i < 20; ++i) {
			Hour hour = new Hour(time.getHour(), time.getMinute(), false);
			hour.setAvailability(av);
			hours.add(hour);
			time = time.plusMinutes(30);
		}

		av.setHours(hours);
		return av;
	}

	@Bean("availability4")
	@Scope("prototype")
	public Availability generateAvailability4() {
		Availability av = new Availability();

		av.setDay(DayType.Jeudi);
		List<Hour> hours = new ArrayList<>();

		LocalTime time = LocalTime.of(8, 0);

		for (int i = 0; i < 20; ++i) {
			Hour hour = new Hour(time.getHour(), time.getMinute(), false);
			hour.setAvailability(av);
			hours.add(hour);
			time = time.plusMinutes(30);
		}

		av.setHours(hours);
		return av;
	}

	@Bean("availability5")
	@Scope("prototype")
	public Availability generateAvailability5() {
		Availability av = new Availability();

		av.setDay(DayType.Vendredi);
		List<Hour> hours = new ArrayList<>();

		LocalTime time = LocalTime.of(8, 0);

		for (int i = 0; i < 20; ++i) {
			Hour hour = new Hour(time.getHour(), time.getMinute(), false);
			hour.setAvailability(av);
			hours.add(hour);
			time = time.plusMinutes(30);
		}

		av.setHours(hours);
		return av;
	}

	@Bean("availability6")
	@Scope("prototype")
	public Availability generateAvailability6() {
		Availability av = new Availability();

		av.setDay(DayType.Samedi);
		List<Hour> hours = new ArrayList<>();

		LocalTime time = LocalTime.of(8, 0);

		for (int i = 0; i < 20; ++i) {
			Hour hour = new Hour(time.getHour(), time.getMinute(), false);
			hour.setAvailability(av);
			hours.add(hour);
			time = time.plusMinutes(30);
		}

		av.setHours(hours);
		return av;
	}

	@Bean("availability7")
	@Scope("prototype")
	public Availability generateAvailability7() {
		Availability av = new Availability();

		av.setDay(DayType.Dimanche);
		List<Hour> hours = new ArrayList<>();

		LocalTime time = LocalTime.of(8, 0);

		for (int i = 0; i < 20; ++i) {
			Hour hour = new Hour(time.getHour(), time.getMinute(), false);
			hour.setAvailability(av);
			hours.add(hour);
			time = time.plusMinutes(30);
		}

		av.setHours(hours);
		return av;
	}

	@Bean("availabilities")
	@Scope("prototype")
	public List<Availability> generateAvailabilities(){

		List<Availability> availabilities = new ArrayList<>();

		availabilities.add(generateAvailability1());
		availabilities.add(generateAvailability2());
		availabilities.add(generateAvailability3());
		availabilities.add(generateAvailability4());
		availabilities.add(generateAvailability5());
		availabilities.add(generateAvailability6());
		availabilities.add(generateAvailability7());

		return availabilities;
	}
}
