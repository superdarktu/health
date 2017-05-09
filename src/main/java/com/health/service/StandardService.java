package com.health.service;

import java.util.List;

import com.health.model.po.Standard;

public interface StandardService {
	

    /**
     * 添加
     * @param list
     * @return
     */
    int insert(List<Standard> list);

    /**
     * 根据ID查询
     * @param name
     * @return
     */
    List<Standard> selectByPrimaryKey(String  name);


    List<Standard> selectByAge(Integer age,String sex);

}