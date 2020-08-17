package com.hackerrank.stocktrade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.model.User;
import com.hackerrank.stocktrade.repository.TradeRepository;
import com.hackerrank.stocktrade.repository.UserRepository;

@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	private TradeRepository tradeRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseEntity<List<Trade>> getAllTrades() {

		return new ResponseEntity<>(tradeRepository.findAllByOrderByIdAsc(), HttpStatus.OK);
	}

	@Override
	public void eraseAllTrades() {

		tradeRepository.deleteAll();

	}

	@Override
	public ResponseEntity<String> createNewTrade(Trade trade) {
		Optional<Trade> fetchedTrade = tradeRepository.findById(trade.getId());
		if (!fetchedTrade.isPresent()) {
			userRepository.save(trade.getUser());
			tradeRepository.save(trade);
			return new ResponseEntity<>(HttpStatus.CREATED);

		} else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<Trade> getById(Long id) {
		if (tradeRepository.findById(id).isPresent()) {
			return new ResponseEntity<>(tradeRepository.findById(id).get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<List<Trade>> getTradeByUserId(Long userId) {
		Optional<User> user = userRepository.findById(userId);

		if (user.isPresent()) {
			Optional<List<Trade>> trade = tradeRepository.findByUserOrderByIdAsc(user.get());
			if (trade.isPresent())
				return new ResponseEntity<>(trade.get(), HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<List<Trade>> getTradeByStockSymbol(String symbol) {
		Optional<List<Trade>> trade = tradeRepository.findBySymbolOrderByIdAsc(symbol);
		if (trade.isPresent())
			return new ResponseEntity<>(trade.get(), HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@Override
	public ResponseEntity<List<Trade>> getTradeByIdAndSymbol(Long id, String symbol) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			Optional<List<Trade>> trade = tradeRepository.findByUserAndSymbolOrderByIdAsc(user.get(), symbol);
			if (trade.isPresent()) {
				return new ResponseEntity<>(trade.get(), HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
