package org.ruskov.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.ruskov.enumerations.RendezvousState;
import org.ruskov.models.Availability;
import org.ruskov.services.AvailabilityService;
import org.ruskov.utils.JsonViews;
import org.ruskov.utils.TimeToDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/availabilities")
@CrossOrigin("*")
public class AvailabilityController {

    private AvailabilityService availabilityService;
    private List<Availability> availabilities;

    @Autowired
    public AvailabilityController(AvailabilityService availabilityService, List<Availability> availabilities) {
        this.availabilityService = availabilityService;
        this.availabilities = availabilities;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @JsonView({JsonViews.defaultCyclingView.class})
    public List<Availability> getAllByIdPractitioner(@PathVariable("id") long id) {
        return availabilityService.findAllByIdPractitioner(id);
    }

    @RequestMapping(value = "/formatted/{id}", method = RequestMethod.GET, produces = "application/json")
    @JsonView({JsonViews.defaultCyclingView.class})
    public List<Availability> getAllByIdPractitionerFormatted(@PathVariable("id") long id,
                                                              @RequestParam("time") long time) {

        LocalDate date = TimeToDateConverter.convertTimeToLocalDate(time);

        LocalDateTime startDate = LocalDateTime.of(date, LocalTime.of(8, 0));
        LocalDateTime limitDate = LocalDateTime.of(date.plusDays(7), LocalTime.of(8, 0));

        return availabilityService.findAllByIdPractitionerBetweenDatesAndFormatted(id, startDate, limitDate,
                RendezvousState.Pending);
    }

    @RequestMapping(value = "/generate/{id}", method = RequestMethod.POST, consumes = "application/json")
    @JsonView({JsonViews.defaultCyclingView.class})
    public List<Availability> populateAvailabilitiesForPractitioner(@PathVariable("id") long id){
    	availabilities.forEach(availability -> availability.setIdPractitioner(id));
		return availabilityService.addAll(availabilities);
	}
}
