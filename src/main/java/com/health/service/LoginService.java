package com.health.service;

import com.health.model.po.Login;

public interface LoginService {
	
    boolean deleteByPrimaryKey(Integer id);

    int insert(Login login);

    Login login(String username , String password);

    boolean update(Login login);

}