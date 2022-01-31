package org.ruskov.repositories;

import java.util.List;

import org.ruskov.models.Availability;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailabilityRepository extends CrudRepository<Availability, Long> {

	List<Availability> findAllByIdPractitioner(long id);
}
