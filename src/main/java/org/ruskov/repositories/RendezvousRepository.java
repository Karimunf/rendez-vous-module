package org.ruskov.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.ruskov.enumerations.RendezvousState;
import org.ruskov.models.Rendezvous;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezvousRepository extends CrudRepository<Rendezvous, Long> {

	public List<Rendezvous> findAllByIdPractitioner(long id);

	@Query("select r from Rendezvous r where r.idPractitioner=?1 and r.horaire>=?2 and r.horaire<=?3 and r.state=?4")
	public List<Rendezvous> findAllByIdPractitionerAndBetweenDates(long id, LocalDateTime startDate,
			LocalDateTime endDate, RendezvousState state);

	public Rendezvous findByHoraireAndIdPatient(LocalDateTime horaire, long id);

	public Rendezvous findByHoraireAndIdPractitioner(LocalDateTime horaire, long id);
}
