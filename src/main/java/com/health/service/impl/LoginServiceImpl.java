package com.health.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.dao.LoginDao;
import com.health.model.po.Login;
import com.health.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao loginDao;
	
	public int deleteByPrimaryKey(Integer id) {
		
		return loginDao.selectCityById(1);
	}

	@Override
	public int insert(Login record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Login record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Login selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Login record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Login record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
