package com.LetsGetDigital.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.LetsGetDigital.dto.CarTypeDto;
import com.LetsGetDigital.dto.QuoteDto;
import com.LetsGetDigital.dto.SearchCriteriaDto;
import com.LetsGetDigital.model.PaymentModel;
import com.LetsGetDigital.model.Quote;
import com.LetsGetDigital.model.QuoteByReference;
import com.LetsGetDigital.model.SearchCriteria;

public class Converter {

  private static  SimpleDateFormat dateFormatter = new SimpleDateFormat( "dd/MM/yyyy");
   
  
	public static SearchCriteriaDto convertTo(QuoteByReference searchCriteria){
		String fromDateTime=dateFormatter.format(searchCriteria.getFromDate());
		String toDateTime=dateFormatter.format(searchCriteria.getToDate());

		SearchCriteriaDto dto= new SearchCriteriaDto();
		dto.setCountryOfResidence(searchCriteria.getCountryOfResidence());
		dto.setDropOffTime(searchCriteria.getDropOffTime());
		dto.setPickUpTime(searchCriteria.getPickUpTime());
		dto.setFromDateTime(fromDateTime);
		dto.setToDateTime(toDateTime);
		dto.setPickupLocation(searchCriteria.getPickupLocation());
		dto.setDroppOffLocation(searchCriteria.getDroppOffLocation());
		
		return dto;
		
	}
	
	
	public static SearchCriteriaDto convertTo(SearchCriteria searchCriteria){
		String fromDateTime=dateFormatter.format(searchCriteria.getFromDate());
		String toDateTime=dateFormatter.format(searchCriteria.getToDate());

		SearchCriteriaDto dto= new SearchCriteriaDto();
		dto.setCountryOfResidence(searchCriteria.getCountryOfResidence());
		dto.setDropOffTime(searchCriteria.getDropOffTime());
		dto.setPickUpTime(searchCriteria.getPickUpTime());
		dto.setFromDateTime(fromDateTime);
		dto.setToDateTime(toDateTime);
		dto.setPickupLocation(searchCriteria.getPickupLocation());
		dto.setDroppOffLocation(searchCriteria.getDroppOffLocation());
		
		return dto;
		
	}
	

	public static SearchCriteria convertFrom(SearchCriteriaDto dto){
		SearchCriteria searchCriteria= new SearchCriteria();
		searchCriteria.setCountryOfResidence(dto.getCountryOfResidence());
		searchCriteria.setDropOffTime(dto.getDropOffTime());
		searchCriteria.setPickUpTime(dto.getPickUpTime());
		try {
			Date fromDateTime = dateFormatter.parse(dto.getFromDateTime());
			Date toDateTime=dateFormatter.parse(dto.getToDateTime());
			searchCriteria.setFromDate(fromDateTime);
			searchCriteria.setToDate(toDateTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		searchCriteria.setPickupLocation(dto.getPickupLocation());
		searchCriteria.setDroppOffLocation(dto.getDroppOffLocation());
		return searchCriteria;
		
	}
	
	
	public static QuoteDto convertTo(Quote quote){
		QuoteDto dto = new QuoteDto();
		dto.setReference(quote.getReference());
		dto.setBaseCurrency(quote.getBaseCurrency());
		dto.setPaymentCurrency(quote.getPaymentCurrency());
		dto.setTotal(quote.getTotal());
		dto.setBrowseTotal(quote.getBrowseTotal());
		dto.setPaymentModel(quote.getPaymentModel());
		dto.setExchangeRate(quote.getExchangeRate());
		dto.setCarType(new CarTypeDto());
		dto.getCarType().setSipp(quote.getCartype().getSipp());
		dto.getCarType().setSupplier(quote.getCartype().getSupplier());
		return dto;
		
		
		
	}

}
