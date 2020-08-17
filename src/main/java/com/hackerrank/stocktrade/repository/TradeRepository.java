package com.hackerrank.stocktrade.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.model.User;

public interface TradeRepository extends CrudRepository<Trade,Long>{
	List<Trade> findAllByOrderByIdAsc();
	Optional<List<Trade>> findByUserOrderByIdAsc(User user);
	Optional<List<Trade>> findBySymbolOrderByIdAsc(String symbol);
	Optional<List<Trade>> findByUserAndSymbolOrderByIdAsc(User user, String symbol);
	
	
}
