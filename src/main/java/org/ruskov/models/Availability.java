package org.ruskov.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.ruskov.enumerations.DayType;
import org.ruskov.utils.JsonViews;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "availability")
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonView({JsonViews.defaultCyclingView.class})
    private Long id;

    @Column(name = "id_practitioner")
    @JsonView({JsonViews.defaultCyclingView.class})
    private long idPractitioner;

    @Enumerated(EnumType.STRING)
    @Column(name = "day")
    @JsonView({JsonViews.defaultCyclingView.class})
    private DayType day;

    @OneToMany(mappedBy = "availability", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonView({JsonViews.defaultCyclingView.class})
    private List<Hour> hours = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPractitioner() {
        return idPractitioner;
    }

    public void setIdPractitioner(long idPractitioner) {
        this.idPractitioner = idPractitioner;
    }

    public DayType getDay() {
        return day;
    }

    public void setDay(DayType day) {
        this.day = day;
    }

    public List<Hour> getHours() {
        return hours;
    }

    public void setHours(List<Hour> hours) {
        this.hours = hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Availability that = (Availability) o;
        return day == that.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day);
    }

    @Override
    public String toString() {
        return "Availability{" +
                "day=" + day +
                '}';
    }
}
