package com.LetsGetDigital.controller;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.LetsGetDigital.Facade.Facade;
import com.LetsGetDigital.dto.QuotesResult;
import com.LetsGetDigital.dto.SearchCriteriaDto;
import com.google.inject.Inject;


@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuotationSearchController {
	
	private Facade facade;

	
	
	
	@Inject
	public QuotationSearchController(Facade facade){
		this.facade=facade;
}


	
	@javax.ws.rs.POST
    @Path("/quotes")
    public QuotesResult getQuotes(SearchCriteriaDto search) {
        return this.facade.getQuotes(search);
    }

	
	@javax.ws.rs.GET
    @Path("/quotes/{reference}")
    public QuotesResult getQuotes(@PathParam("reference") UUID reference) {
        return this.facade.getQuoteByReference(reference);
    }
	
	
//	@javax.ws.rs.POST
//    @Path("/quotes")
//    public QuotesResult getQuotes(SearchCriteriaDto search) {
//        return this.facade.getQuotes(search);
//    }

	
	@javax.ws.rs.GET
    @Path("/")
    public SearchCriteriaDto getSearchCriteriaSample() {
        return facade.getSearchCriteriaSample();
    }

}
