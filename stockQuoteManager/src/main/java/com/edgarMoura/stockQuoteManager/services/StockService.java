package com.edgarMoura.stockQuoteManager.services;

import java.util.List;

import com.edgarMoura.stockQuoteManager.models.Stock;

public interface StockService {

	public List<Stock> findAll();
	public Stock find(String id);
	public Stock create(Stock stock);
	public Stock update(String id, Stock stock);
	public void delete(String id);
	
}
