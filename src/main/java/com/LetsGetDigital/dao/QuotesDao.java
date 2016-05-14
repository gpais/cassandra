package com.LetsGetDigital.dao;

import java.util.List;
import java.util.UUID;

import com.LetsGetDigital.model.CarType;
import com.LetsGetDigital.model.PaymentModel;
import com.LetsGetDigital.model.Quote;
import com.LetsGetDigital.model.QuoteByReference;
import com.LetsGetDigital.model.SearchCriteria;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.TypeCodec;
import com.datastax.driver.core.UserType;
import com.datastax.driver.extras.codecs.enums.EnumNameCodec;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.google.inject.Inject;

public class QuotesDao{

	private Session session;
	private MappingManager  manager;
	private Mapper<Quote> mapper;
	private Mapper<QuoteByReference> quoteByReferenceMapper;

    private  QuoteAcessor quoteAcessor;
    
	@Inject
	public QuotesDao(Cluster sessionFactory) {
		UserType cartype = sessionFactory.getMetadata().getKeyspace("mobacar").getUserType("cartype");
		sessionFactory.getConfiguration().getCodecRegistry().register(
				new CarTypeCodec( com.datastax.driver.core.TypeCodec.userType( cartype),CarType.class),
				new EnumNameCodec<PaymentModel>(PaymentModel.class));
		
		this.session = sessionFactory.connect();
		manager = new MappingManager(session);
		mapper = manager.mapper(Quote.class);
		quoteByReferenceMapper= manager.mapper(QuoteByReference.class);;
		quoteAcessor = manager.createAccessor(QuoteAcessor.class);

	}
	

	
	public void save(Quote quote){
		quoteByReferenceMapper.saveAsync(new QuoteByReference(quote));
		mapper.saveAsync(quote);
		
	}
	
	public List<Quote> findAll(){
		return quoteAcessor.getAll().all();
	}
	
	
	public List<QuoteByReference> findQuoteByReference(UUID id){
		return quoteAcessor.getQuoteByReference(id).all();
	}
	
	public Quote findQuoteByReference(String reference){
		return null;
	

	}


	public List<Quote> findAllBySearchCriteria(QuoteByReference convertFrom) {
		return quoteAcessor.getQuotes(convertFrom.getFromDate(), convertFrom.getToDate(), convertFrom.getPickupLocation(), convertFrom.getDroppOffLocation(), convertFrom.getPickUpTime(), convertFrom.getDropOffTime(), convertFrom.getCountryOfResidence()).all();
	}
	

	public List<Quote> findAllBySearchCriteria(SearchCriteria convertFrom) {
		return quoteAcessor.getQuotes(convertFrom.getFromDate(), convertFrom.getToDate(), convertFrom.getPickupLocation(), convertFrom.getDroppOffLocation(), convertFrom.getPickUpTime(), convertFrom.getDropOffTime(), convertFrom.getCountryOfResidence()).all();
	}
	
	


}
