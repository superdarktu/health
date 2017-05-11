package com.health.service;

import com.health.model.po.Login;

public interface LoginService {

    /**
     * 删除
     *
     * @param id
     * @return
     */
    boolean deleteByPrimaryKey(Integer id);

    /**
     * 添加
     *
     * @param login
     * @return
     */
    int insert(Login login);

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    Login login(String username, String password);

    /**
     * 修改
     *
     * @param login
     * @return
     */
    boolean update(Login login);

}