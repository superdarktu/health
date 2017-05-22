package com.health.service;

import com.health.model.po.Standard;

import java.util.List;

public interface StandardService {


    /**
     * 添加
     *
     * @param list
     * @return
     */
    int insert(List<Standard> list);

    /**
     * 根据ID查询
     *
     * @param name
     * @return
     */
    List<Standard> selectByPrimaryKey(String name);


    List<Standard> selectByAge(Integer age, String sex);
    
    List<Standard> getYiban(Integer age,String sex);

}