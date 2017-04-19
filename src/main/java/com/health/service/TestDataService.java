package com.health.service;

import com.health.model.po.TestData;

public interface TestDataService {
    int deleteByPrimaryKey(Integer id);

    int insert(TestData record);

    int insertSelective(TestData record);

    TestData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestData record);

    int updateByPrimaryKey(TestData record);
}