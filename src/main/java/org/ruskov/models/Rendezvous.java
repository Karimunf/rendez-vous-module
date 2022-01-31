package org.ruskov.models;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.ruskov.enumerations.RendezvousState;
import org.ruskov.utils.JsonViews;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "rendezvous")
public class Rendezvous {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@JsonView({ JsonViews.defaultCyclingView.class })
	private long id;

	@Column(name = "horaire")
	@JsonView({ JsonViews.defaultCyclingView.class })
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime horaire;

	@Column(name = "state")
	@Enumerated(EnumType.STRING)
	@JsonView({ JsonViews.defaultCyclingView.class })
	private RendezvousState state;

	@Column(name = "id_practitioner")
	private long idPractitioner;

	@Column(name = "id_patient")
	private long idPatient;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getHoraire() {
		return horaire;
	}

	public void setHoraire(LocalDateTime horaire) {
		this.horaire = horaire;
	}

	public RendezvousState getState() {
		return state;
	}

	public void setState(RendezvousState state) {
		this.state = state;
	}

	public long getIdPractitioner() {
		return idPractitioner;
	}

	public void setIdPractitioner(long idPractitioner) {
		this.idPractitioner = idPractitioner;
	}

	public long getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(long idPatient) {
		this.idPatient = idPatient;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Rendezvous that = (Rendezvous) o;
		return idPractitioner == that.idPractitioner && idPatient == that.idPatient && horaire.equals(that.horaire) && state == that.state;
	}

	@Override
	public int hashCode() {
		return Objects.hash(horaire, state, idPractitioner, idPatient);
	}
}
