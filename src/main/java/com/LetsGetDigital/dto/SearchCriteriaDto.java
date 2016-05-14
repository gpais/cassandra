package com.LetsGetDigital.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchCriteriaDto  implements Serializable {
    
	private String pickUpTime;
    private String dropOffTime;
    private String countryOfResidence;
    private String fromDateTime;
	private String toDateTime;
    private String pickupLocation;
    private String droppOffLocation;
    
    @JsonProperty
    public String getFromDateTime() {
		return fromDateTime;
	}
	public void setFromDateTime(String fromDateTime) {
		this.fromDateTime = fromDateTime;
	}
    @JsonProperty
	public String getToDateTime() {
		return toDateTime;
	}
	public void setToDateTime(String toDateTime) {
		this.toDateTime = toDateTime;
	}
    @JsonProperty
	public String getPickupLocation() {
		return pickupLocation;
	}
	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}
    @JsonProperty
	public String getDroppOffLocation() {
		return droppOffLocation;
	}
	public void setDroppOffLocation(String droppOffLocation) {
		this.droppOffLocation = droppOffLocation;
	}
    @JsonProperty
	public String getPickUpTime() {
		return pickUpTime;
	}
	public void setPickUpTime(String pickUpTime) {
		this.pickUpTime = pickUpTime;
	}
	
    @JsonProperty
	public String getDropOffTime() {
		return dropOffTime;
	}
	public void setDropOffTime(String dropOffTime) {
		this.dropOffTime = dropOffTime;
	}
    @JsonProperty
	public String getCountryOfResidence() {
		return countryOfResidence;
	}
	public void setCountryOfResidence(String countryOfResidence) {
		this.countryOfResidence = countryOfResidence;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((countryOfResidence == null) ? 0 : countryOfResidence
						.hashCode());
		result = prime * result
				+ ((dropOffTime == null) ? 0 : dropOffTime.hashCode());
		result = prime
				* result
				+ ((droppOffLocation == null) ? 0 : droppOffLocation.hashCode());
		result = prime * result
				+ ((fromDateTime == null) ? 0 : fromDateTime.hashCode());
		result = prime * result
				+ ((pickUpTime == null) ? 0 : pickUpTime.hashCode());
		result = prime * result
				+ ((pickupLocation == null) ? 0 : pickupLocation.hashCode());
		result = prime * result
				+ ((toDateTime == null) ? 0 : toDateTime.hashCode());
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
		SearchCriteriaDto other = (SearchCriteriaDto) obj;
		if (countryOfResidence == null) {
			if (other.countryOfResidence != null)
				return false;
		} else if (!countryOfResidence.equals(other.countryOfResidence))
			return false;
		if (dropOffTime == null) {
			if (other.dropOffTime != null)
				return false;
		} else if (!dropOffTime.equals(other.dropOffTime))
			return false;
		if (droppOffLocation == null) {
			if (other.droppOffLocation != null)
				return false;
		} else if (!droppOffLocation.equals(other.droppOffLocation))
			return false;
		if (fromDateTime == null) {
			if (other.fromDateTime != null)
				return false;
		} else if (!fromDateTime.equals(other.fromDateTime))
			return false;
		if (pickUpTime == null) {
			if (other.pickUpTime != null)
				return false;
		} else if (!pickUpTime.equals(other.pickUpTime))
			return false;
		if (pickupLocation == null) {
			if (other.pickupLocation != null)
				return false;
		} else if (!pickupLocation.equals(other.pickupLocation))
			return false;
		if (toDateTime == null) {
			if (other.toDateTime != null)
				return false;
		} else if (!toDateTime.equals(other.toDateTime))
			return false;
		return true;
	}
}
