package com.LetsGetDigital.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuotesResult  implements Serializable{
	
	public SearchCriteriaDto getSearchCriteria() {
		return searchCriteria;
	}
	public void setSearchCriteria(SearchCriteriaDto searchCriteria) {
		this.searchCriteria = searchCriteria;
	}
	
	public List<QuoteDto> getQuotes() {
		return quotes;
	}
	public void setQuotes(List<QuoteDto> quotes) {
		this.quotes = quotes;
	}
	private SearchCriteriaDto searchCriteria;
	private List<QuoteDto> quotes;

}
