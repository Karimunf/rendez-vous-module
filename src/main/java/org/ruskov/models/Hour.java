package org.ruskov.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.ruskov.utils.JsonViews;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "hour")
public class Hour {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@JsonView({ JsonViews.defaultCyclingView.class })
	private Long id;

	@Column(name = "hour")
	@JsonView({ JsonViews.defaultCyclingView.class })
	private long hour;

	@Column(name = "minutes")
	@JsonView({ JsonViews.defaultCyclingView.class })
	private long minutes;

	@Column(name = "is_active", columnDefinition = "boolean default false",nullable = false)
	@JsonView({ JsonViews.defaultCyclingView.class })
	private Boolean isActive;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_availability", referencedColumnName = "id")
	private Availability availability;

	public Hour() {
		this.isActive = false;
	}

	public Hour(long hour, long minutes, boolean isActive) {
		this.hour = hour;
		this.minutes = minutes;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getHour() {
		return hour;
	}

	public void setHour(long hour) {
		this.hour = hour;
	}

	public long getMinutes() {
		return minutes;
	}

	public void setMinutes(long minutes) {
		this.minutes = minutes;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Availability getAvailability() {
		return availability;
	}

	public void setAvailability(Availability availability) {
		this.availability = availability;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (hour ^ (hour >>> 32));
		result = prime * result + (int) (minutes ^ (minutes >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hour other = (Hour) obj;
		if (hour != other.hour)
			return false;
		if (minutes != other.minutes)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hour [hour=" + hour + ", minutes=" + minutes + "]";
	}

}
