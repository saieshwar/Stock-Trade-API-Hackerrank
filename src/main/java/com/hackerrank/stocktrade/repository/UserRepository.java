package com.hackerrank.stocktrade.repository;

import org.springframework.data.repository.CrudRepository;

import com.hackerrank.stocktrade.model.User;

public interface UserRepository extends CrudRepository<User,Long>{

}
