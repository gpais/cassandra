package com.LetsGetDigital.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import com.LetsGetDigital.model.PaymentModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class QuoteDto  implements Serializable {
	
	private UUID reference;
    private PaymentModel paymentModel;
    private BigDecimal total;
    private String baseCurrency;
    private String paymentCurrency;
    private BigDecimal exchangeRate;
    private BigDecimal browseTotal;
    private CarTypeDto carType;
    @JsonProperty
	public UUID getReference() {
		return reference;
	}
	public void setReference(UUID reference) {
		this.reference = reference;
	}
	
    @JsonProperty
	public PaymentModel getPaymentModel() {
		return paymentModel;
	}
	public void setPaymentModel(PaymentModel paymentModel) {
		this.paymentModel = paymentModel;
	}
    @JsonProperty
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
    @JsonProperty
	public String getBaseCurrency() {
		return baseCurrency;
	}
	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}
    @JsonProperty
	public String getPaymentCurrency() {
		return paymentCurrency;
	}
	public void setPaymentCurrency(String paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}
	
    @JsonProperty
	public BigDecimal getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(BigDecimal exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	
    @JsonProperty
	public BigDecimal getBrowseTotal() {
		return browseTotal;
	}
	public void setBrowseTotal(BigDecimal browseTotal) {
		this.browseTotal = browseTotal;
	}
	public CarTypeDto getCarType() {
		return carType;
	}
	public void setCarType(CarTypeDto carType) {
		this.carType = carType;
	}
	
}
