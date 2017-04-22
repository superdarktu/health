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

	/**
	 * 删除
	 */
	public boolean deleteByPrimaryKey(Integer id) {
		
		Login login = new Login();
		login.setId(id);
		return loginDao.delete(login);
	}

	/**
	 * 添加
	 */
	public int insert(Login login) {
		
		return loginDao.insert(login);
	}

	/**
	 * 登录
	 */
	public Login login(String username , String password) {
		
		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);
		return loginDao.login(login);
	}

	/**
	 * 修改
	 */
	public boolean update(Login login) {
		
		return loginDao.update(login);
	}
	

}
