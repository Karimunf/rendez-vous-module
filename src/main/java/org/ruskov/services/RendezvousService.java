package org.ruskov.services;

import java.time.LocalDateTime;
import java.util.List;

import org.ruskov.enumerations.RendezvousState;
import org.ruskov.models.Rendezvous;
import org.ruskov.repositories.RendezvousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RendezvousService {

	private RendezvousRepository rendezvousRepository;

	@Autowired
	public RendezvousService(RendezvousRepository rendezvousRepository) {
		this.rendezvousRepository = rendezvousRepository;
	}

	public Rendezvous findByHoraireAndIdPractitioner(LocalDateTime horaire, long id) {
		return rendezvousRepository.findByHoraireAndIdPractitioner(horaire, id);
	}

	public Rendezvous findByHoraireAndIdPatient(LocalDateTime horaire, long id) {
		return rendezvousRepository.findByHoraireAndIdPatient(horaire, id);
	}

	public Rendezvous add(Rendezvous rdv) {
		return rendezvousRepository.save(rdv);
	}

	public List<Rendezvous> findAllByIdPractitioner(long id) {
		return rendezvousRepository.findAllByIdPractitioner(id);
	}

	public List<Rendezvous> findAllByIdPractitionerAndBetweenDates(long id, LocalDateTime startDate,
			LocalDateTime limitDate, RendezvousState state) {
		return rendezvousRepository.findAllByIdPractitionerAndBetweenDates(id, startDate, limitDate, state);
	}
}
