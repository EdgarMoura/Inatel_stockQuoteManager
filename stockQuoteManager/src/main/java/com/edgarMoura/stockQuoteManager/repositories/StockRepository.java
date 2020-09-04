package com.edgarMoura.stockQuoteManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edgarMoura.stockQuoteManager.models.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {

}
