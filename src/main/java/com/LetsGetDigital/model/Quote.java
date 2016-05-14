package com.LetsGetDigital.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.ws.rs.Encoded;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.Frozen;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace="mobacar",name="QuoteSearch")
public class Quote {
    @Column(name="reference")
	private UUID reference;

    @Column(name="paymentModel")
    private PaymentModel paymentModel;
    
    @Column(name="total")
    private BigDecimal total;
    
    @Column(name="baseCurrency")
    private String baseCurrency;
    
    @Column(name="paymentCurrency")
    private String paymentCurrency;
    
    @Column(name="exchangeRate")
    private BigDecimal exchangeRate;
    
    @Column(name="browseTotal")
    private BigDecimal browseTotal;
    
    @Column (name = "cartype")
    @Frozen("frozen<mobacar.cartype>")
    private CarType cartype;
    
    @PartitionKey(0)
    private Date fromDate;
    
    @PartitionKey(1)
    private Date toDate;
    
    @PartitionKey(2)
    private String pickupLocation;
//    
    @PartitionKey(3)
    private String droppOffLocation;
    
    @PartitionKey(4)
    private String pickUpTime;
    
    @PartitionKey(5)
    private String dropOffTime;
    
    @PartitionKey(6)
    private String countryOfResidence;
    
  
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

	
    public UUID getReference() {
		return reference;
	}

	public void setReference(UUID reference) {
		this.reference = reference;
	}

	public PaymentModel getPaymentModel() {
		return paymentModel;
	}

	public void setPaymentModel(PaymentModel paymentModel) {
		this.paymentModel = paymentModel;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public String getPaymentCurrency() {
		return paymentCurrency;
	}

	public void setPaymentCurrency(String paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}

	public BigDecimal getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(BigDecimal exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public BigDecimal getBrowseTotal() {
		return browseTotal;
	}

	public void setBrowseTotal(BigDecimal browseTotal) {
		this.browseTotal = browseTotal;
	}




	
	public CarType getCartype() {
		return cartype;
	}

	public void setCartype(CarType cartype) {
		this.cartype = cartype;
	}


    
    

}
