package com.LetsGetDigital.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarTypeDto {
    @JsonProperty
	public String getSipp() {
		return sipp;
	}
	public void setSipp(String sipp) {
		this.sipp = sipp;
	}
    @JsonProperty
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	private String sipp;
	private String supplier;
}
