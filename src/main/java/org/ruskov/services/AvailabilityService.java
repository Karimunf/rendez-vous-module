package org.ruskov.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.ruskov.enumerations.DayType;
import org.ruskov.enumerations.RendezvousState;
import org.ruskov.models.Availability;
import org.ruskov.models.Hour;
import org.ruskov.models.Rendezvous;
import org.ruskov.repositories.AvailabilityRepository;
import org.ruskov.utils.DaysMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityService {

	private AvailabilityRepository availabilityRepository;
	private RendezvousService rendezvousService;

	@Autowired
	public AvailabilityService(AvailabilityRepository availabilityRepository, RendezvousService rendezvousService) {
		this.availabilityRepository = availabilityRepository;
		this.rendezvousService = rendezvousService;
	}

	public Availability add(Availability availability) {
		return availabilityRepository.save(availability);
	}

	public List<Availability> addAll(Iterable<Availability> availabilities){
		return (List<Availability>) availabilityRepository.saveAll(availabilities);
	}

	public List<Availability> findAllByIdPractitioner(long id) {

		List<Availability> availabilities = availabilityRepository.findAllByIdPractitioner(id);
		availabilities = sortPractitionerAvailabilitiesAndHours(availabilities);
		return availabilities;
	}

	public List<Availability> findAllByIdPractitionerBetweenDatesAndFormatted(long id, LocalDateTime startDate,
			LocalDateTime limitDate, RendezvousState state) {

		List<Availability> availabilities = availabilityRepository.findAllByIdPractitioner(id);
		List<Rendezvous> rendezvous = rendezvousService.findAllByIdPractitionerAndBetweenDates(id, startDate, limitDate,
				state);

		for (Availability availability : availabilities) {

			for (Rendezvous rdv : rendezvous) {

				String availabilityDay = availability.getDay().toString();
				String rdvDay = DaysMap.DAYS_EG_TO_FR.get(rdv.getHoraire().getDayOfWeek().toString());

				if (availabilityDay.equals(rdvDay)) {
					Hour hourToRemove = new Hour(rdv.getHoraire().getHour(), rdv.getHoraire().getMinute(), false);
					availability.getHours().remove(hourToRemove);
					break;
				}
			}
		}
		availabilities = getAvailabilitiesSortedByStartingDate(availabilities, startDate);

		return availabilities;
	}

	private List<Availability> sortPractitionerAvailabilitiesAndHours(List<Availability> availabilities) {

		List<Availability> res = new ArrayList<>();

		for (DayType type : DayType.values()) {

			for (Availability av : availabilities) {
				if (type.equals(av.getDay())) {
					Collections.sort(av.getHours(),
							Comparator.comparing(Hour::getHour).thenComparing(Hour::getMinutes));
					res.add(av);
					break;
				}
			}
		}

		return res;
	}

	private List<Availability> getAvailabilitiesSortedByStartingDate(List<Availability> availabilities,
			LocalDateTime startDate) {

		List<Availability> res = new ArrayList<>();

		LocalDateTime _startDate = startDate;

		for (int i = 0; i < 7; ++i) {
			String currentDay = DaysMap.DAYS_EG_TO_FR.get(_startDate.getDayOfWeek().toString());
			for (Availability av : availabilities) {

				String availabilityDay = av.getDay().toString();

				if (availabilityDay.equals(currentDay)) {
					res.add(av);
					break;
				}
			}
			_startDate = _startDate.plusDays(1);
		}
		return res;
	}
}
