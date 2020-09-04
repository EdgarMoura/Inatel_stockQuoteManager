package com.edgarMoura.stockQuoteManager.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgarMoura.stockQuoteManager.models.Quote;
import com.edgarMoura.stockQuoteManager.models.Stock;
import com.edgarMoura.stockQuoteManager.repositories.QuoteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository quoteRepository;
	
	@Autowired
	private StockService stockService;
	
	@Override
	public List<Quote> findAll() {
		return this.quoteRepository.findAll();
	}

	@Override
	public Quote find(Long id) {
		return findById(id);
	}

	@Override
	public Quote create(Quote quote, String stockId) {	
		Stock stock = stockService.find(stockId);
		quote.setStock(stock);
		return this.quoteRepository.save(quote);
	}

	@Override
	public Quote update(Long id, Quote quote) {
		Quote quoteExists = findById(id);			
		
		if(quoteExists != null) {
			quote.setId(quoteExists.getId());
			return quoteRepository.save(quote);
		}
		
		return null;
	}

	@Override
	public void delete(Long id) {
		Quote quoteExists = findById(id);		
		
		if(quoteExists != null) quoteRepository.delete(quoteExists);	
		
	}

	private Quote findById(Long id) {
		return this.quoteRepository.findById(id).orElse(null);
	}
}
