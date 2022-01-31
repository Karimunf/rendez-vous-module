package org.ruskov.dtos;

import org.ruskov.enumerations.RendezvousState;

public class RendezvousDTO {

    private long idPatient;
    private long idPractitioner;
    private long horaire;
    private RendezvousState state;

    public long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(long idPatient) {
        this.idPatient = idPatient;
    }

    public long getIdPractitioner() {
        return idPractitioner;
    }

    public void setIdPractitioner(long idPractitioner) {
        this.idPractitioner = idPractitioner;
    }

    public long getHoraire() {
        return horaire;
    }

    public void setHoraire(long horaire) {
        this.horaire = horaire;
    }

    public RendezvousState getState() {
        return state;
    }

    public void setState(RendezvousState state) {
        this.state = state;
    }
}
