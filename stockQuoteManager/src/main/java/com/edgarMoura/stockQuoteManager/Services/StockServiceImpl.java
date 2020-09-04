package com.edgarMoura.stockQuoteManager.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgarMoura.stockQuoteManager.models.Stock;
import com.edgarMoura.stockQuoteManager.repositories.StockRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StockServiceImpl implements StockService{

	@Autowired
	private StockRepository stockRepository;
	
	@Override
	public List<Stock> findAll() {
		return this.stockRepository.findAll();
	}

	@Override
	public Stock find(String id) {
		return findById(id);
	}

	@Override
	public Stock create(Stock stock) {
		return stockRepository.save(stock);
	
	}

	@Override
	public Stock update(String id, Stock stock) {
		Stock stockExists = findById(id);
		
		if(stockExists != null) {
			stock.setId(stockExists.getId());
			return this.stockRepository.save(stock);
		}
		
		return null;
	}

	@Override
	public void delete(String id) {
		Stock stock = findById(id);
		
		if(stock != null) this.stockRepository.delete(stock);
		
	}
	
	private Stock findById(String id) {
		return this.stockRepository.findById(id).orElse(null);
	}

	
}
