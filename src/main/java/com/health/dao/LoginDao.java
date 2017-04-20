package com.health.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.health.util.SQLManager;

@Repository
public class LoginDao {

	@Autowired
	private SQLManager sqlManager;

	public int selectCityById(long id) {
		
		return sqlManager.count("food.count",null);
	}
}
