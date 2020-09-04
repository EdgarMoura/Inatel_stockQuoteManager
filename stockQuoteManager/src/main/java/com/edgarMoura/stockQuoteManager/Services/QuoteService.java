package com.edgarMoura.stockQuoteManager.Services;

import java.util.List;

import com.edgarMoura.stockQuoteManager.models.Quote;

public interface QuoteService {

	public List<Quote> findAll();
	public Quote find(Long id);
	public Quote create(Quote quote, String stockId);
	public Quote update(Long id, Quote quote);
	public void delete(Long id);
}
