package com.LetsGetDigital.model;

import com.datastax.driver.mapping.annotations.Column;


public class CarType {
	public CarType(){

	}
	public CarType(String supplier,String sipp){
		this.supplier=supplier;
		this.sipp=sipp;
	}
	public String getSipp() {
		return sipp;
	}
	public void setSipp(String sipp) {
		this.sipp = sipp;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	private String sipp;
	
	private String supplier;

}
