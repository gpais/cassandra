package com.LetsGetDigital.model;

import java.util.Date;
import java.util.UUID;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace="mobacar",name="QuoteByReference")
public class QuoteByReference {
	
	public QuoteByReference(){
		
	}
	
	
	public QuoteByReference(Quote quote){
		this.reference=quote.getReference();
		this.countryOfResidence=quote.getCountryOfResidence();
		this.dropOffTime=quote.getDropOffTime();
		this.pickUpTime=quote.getPickUpTime();
		this.droppOffLocation=quote.getDroppOffLocation();
		this.pickupLocation=quote.getPickupLocation();
		this.fromDate=quote.getFromDate();
		this.toDate=quote.getToDate();
	}
	
	@PartitionKey(0)
	private UUID reference;
    
    @Column(name="fromDate")
    private Date fromDate;
    
    @Column(name="toDate")
    private Date toDate;
    
    @Column(name="pickupLocation")
    private String pickupLocation;
//    
    @Column(name="droppOffLocation")
    private String droppOffLocation;
    
    @Column(name="pickUpTime")
    private String pickUpTime;
    
    @Column(name="dropOffTime")
    private String dropOffTime;
    
    @Column(name="countryOfResidence")
    private String countryOfResidence;
    
    public UUID getReference() {
		return reference;
	}

	public void setReference(UUID reference) {
		this.reference = reference;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public String getDroppOffLocation() {
		return droppOffLocation;
	}

	public void setDroppOffLocation(String droppOffLocation) {
		this.droppOffLocation = droppOffLocation;
	}

	public String getPickUpTime() {
		return pickUpTime;
	}

	public void setPickUpTime(String pickUpTime) {
		this.pickUpTime = pickUpTime;
	}

	public String getDropOffTime() {
		return dropOffTime;
	}

	public void setDropOffTime(String dropOffTime) {
		this.dropOffTime = dropOffTime;
	}

	public String getCountryOfResidence() {
		return countryOfResidence;
	}

	public void setCountryOfResidence(String countryOfResidence) {
		this.countryOfResidence = countryOfResidence;
	}


    
}
