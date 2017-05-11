package com.health.dao;

import com.health.model.po.Login;
import com.health.util.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {

    @Autowired
    private SQLManager sqlManager;

    public Login selectCityById(Integer id) {

        return (Login) sqlManager.query("login.selectByPrimaryKey", id);
    }

    public Login login(Login login) {

        return (Login) sqlManager.query("login.login", login);
    }

    public boolean update(Login login) {

        return sqlManager.update("login.updateByPrimaryKey", login) > 0 ? true : false;
    }

    public boolean delete(Login login) {

        return sqlManager.delete("login.deleteByPrimaryKey", login) > 0 ? true : false;
    }

    public Integer insert(Login login) {

        return (Integer) sqlManager.insert("login.insert", login);
    }
}
