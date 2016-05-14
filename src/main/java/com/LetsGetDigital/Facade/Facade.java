package com.LetsGetDigital.Facade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import com.LetsGetDigital.dao.QuoteAcessor;
import com.LetsGetDigital.dao.QuotesDao;
import com.LetsGetDigital.dto.QuoteDto;
import com.LetsGetDigital.dto.QuotesResult;
import com.LetsGetDigital.dto.SearchCriteriaDto;
import com.LetsGetDigital.engine.QuotationEngine;
import com.LetsGetDigital.model.Quote;
import com.LetsGetDigital.model.QuoteByReference;
import com.LetsGetDigital.model.SearchCriteria;
import com.LetsGetDigital.util.Converter;
import com.google.inject.Inject;

public class Facade {

	private QuotesDao quotesDao;
	private QuotationEngine quotationEngine;

	@Inject
	public Facade(QuotationEngine quotationEngine, QuotesDao quotesDao) {
		this.quotesDao = quotesDao;
		this.quotationEngine = quotationEngine;
	}

	public SearchCriteriaDto getSearchCriteriaSample() {

		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setCountryOfResidence("France");
		searchCriteria.setPickUpTime("10:00");
		searchCriteria.setDropOffTime("10:00");
		Calendar calendar = Calendar.getInstance();
		searchCriteria.setFromDate(calendar.getTime());

		calendar.add(Calendar.DAY_OF_MONTH, 5);
		searchCriteria.setToDate(calendar.getTime());

		searchCriteria.setPickupLocation("PARIS");
		searchCriteria.setDroppOffLocation("PARIS");

		return Converter.convertTo(searchCriteria);
	}

	public QuotesResult getQuoteByReference(UUID reference){
    	QuotesResult result = new QuotesResult();
	    List<QuoteByReference> quoteByReference = this.quotesDao.findQuoteByReference(reference);
		result.setSearchCriteria(Converter.convertTo(quoteByReference.get(0)));
		
	    List<Quote> quotes = this.quotesDao.findAllBySearchCriteria(quoteByReference.get(0)) ;

		result.setQuotes(new ArrayList<QuoteDto>());
		result.getQuotes().add(Converter.convertTo(quotes.get(0)));
    	return result;
		
	}
	public QuotesResult getQuotes(SearchCriteriaDto search) {
    	QuotesResult result = new QuotesResult();
    	result.setSearchCriteria(search);
    	Function<List<Quote>, List<QuoteDto>> convertToDtos = a->{
    		List<QuoteDto> quoteDtos= new ArrayList<>();
    		a.stream()
    		.forEach(b-> {
    			this.quotesDao.save(b);
    			quoteDtos.add(Converter.convertTo(b));
    			
    		});
    		return quoteDtos;
    	};
    	
//     	List<Quote> quotes=quotesDao.findAll();
    	List<Quote> quotes=quotesDao.findAllBySearchCriteria(Converter.convertFrom(search));

    	if(quotes != null && quotes.size() != 0){
        	result.setQuotes(convertToDtos.apply(quotes));
        	return result;
    	}
    	
    	SearchCriteria searchModel = Converter.convertFrom(search);
//    	this.searchCriteriaDao.save(searchModel);
    	quotes=this.quotationEngine.getQuotes(searchModel);
    	
    	result.setQuotes(convertToDtos.apply(quotes));
    	return result;
    }

}
