package com.edgarMoura.stockQuoteManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edgarMoura.stockQuoteManager.models.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

}
