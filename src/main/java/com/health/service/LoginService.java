package com.health.service;

import com.health.model.po.Login;

public interface LoginService {
	
    boolean deleteByPrimaryKey(Integer id);

    int insert(Login login);

    Login login(Login login);

    boolean update(Login login);

}