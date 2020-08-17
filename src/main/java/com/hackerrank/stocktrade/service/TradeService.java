package com.hackerrank.stocktrade.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hackerrank.stocktrade.model.Trade;

public interface TradeService {
	public ResponseEntity<List<Trade>> getAllTrades();
	public void eraseAllTrades();
	public ResponseEntity<String> createNewTrade(Trade trade);
	public ResponseEntity<Trade> getById(Long id);
	public ResponseEntity<List<Trade>> getTradeByUserId(Long userId);
	public ResponseEntity<List<Trade>> getTradeByStockSymbol(String symbol);
	public ResponseEntity<List<Trade>> getTradeByIdAndSymbol(Long id, String symbol);
}
