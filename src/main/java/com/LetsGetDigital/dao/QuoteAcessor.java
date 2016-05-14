package com.LetsGetDigital.dao;

import java.util.Date;
import java.util.UUID;

import com.LetsGetDigital.model.Quote;
import com.LetsGetDigital.model.QuoteByReference;
import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Param;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Query;

@Accessor
public interface QuoteAcessor {

	@Query("SELECT * FROM mobacar.QuoteSearch")
    Result<Quote> getAll();
	
	
	
	@Query("SELECT * FROM mobacar.QuoteSearch WHERE fromDate = :fromDate and toDate= :toDate and pickupLocation= :pickupLocation and droppOffLocation=:droppOffLocation "
			+ "and pickUpTime= :pickUpTime and dropOffTime=:dropOffTime and countryOfResidence= :countryOfResidence")
	 Result<Quote> getQuotes(
			 @Param("fromDate") Date fromDate,
			 @Param("toDate") Date toDate,
			 @Param("pickupLocation") String pickupLocation,
			 @Param("droppOffLocation") String droppOffLocation,
			 @Param("pickUpTime") String pickUpTime,
			 @Param("dropOffTime") String dropOffTime,
			 @Param("countryOfResidence") String countryOfResidence

			 );
	
	
	@Query("SELECT * FROM mobacar.QuoteByReference where reference=:reference ")
	 Result<QuoteByReference> getQuoteByReference( @Param("reference") UUID reference);
	

	
}
