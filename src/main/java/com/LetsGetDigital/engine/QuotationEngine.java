package com.LetsGetDigital.engine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import com.LetsGetDigital.model.CarType;
import com.LetsGetDigital.model.PaymentModel;
import com.LetsGetDigital.model.Quote;
import com.LetsGetDigital.model.SearchCriteria;
import java.util.UUID;

public class QuotationEngine {
	
	private final String[] sipps={"EBMR", "ECMR","CBAN","CCAR","FDAR"};
	private final String[] supplier={"HERTZ", "BUDGET","EASYRENT","SUPRICE"};
	private Random randoom= new Random();

	Supplier<CarType> generateRandoomCarType=()-> {
			int sippsCount=sipps.length-1;
			int supppliersCount=supplier.length-1;
			CarType cartype=new CarType();
			cartype.setSipp(sipps[randoom.nextInt(sippsCount)]);
			cartype.setSupplier(supplier[randoom.nextInt(supppliersCount)]);
			return cartype;
		};

	public List<Quote> getQuotes(final SearchCriteria search){
	
		BiFunction<SearchCriteria, Integer, List<Quote>> searchQuotes=(a,b)->{
			List<Quote> quotes= new ArrayList<Quote>();
			for(int i=0;i<b;i++){
				Quote quote= new Quote();
				quote.setCountryOfResidence(search.getCountryOfResidence());
                quote.setDropOffTime(search.getDropOffTime());
                quote.setDroppOffLocation(search.getDroppOffLocation());
                quote.setFromDate(search.getFromDate());
                quote.setPickupLocation( search.getPickupLocation());
				quote.setPickUpTime(search.getPickUpTime());
				quote.setToDate(search.getToDate());
				quote.setBaseCurrency("EUR");
				quote.setPaymentCurrency("EUR");
				quote.setReference(UUID.randomUUID());
				quote.setTotal(new BigDecimal(130.50));
				quote.setBrowseTotal(new BigDecimal(130.50));
				quote.setExchangeRate(new BigDecimal(1.00));
				quote.setPaymentModel(PaymentModel.PrePaid);
				quote.setCartype(generateRandoomCarType.get());
				quotes.add(quote);
			}
			return quotes;
		};
		
		return searchQuotes.apply(search,10);
		
	}
}
