package com.health.service;

import java.util.List;

import com.health.model.po.Student;
import com.health.model.po.TestData;

public interface TestDataService {
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
    boolean delete(Integer id);

    /**
     * 添加
     * @param testData
     * @return
     */
    int insert(TestData testData,Student student);

    /**
     * 查询
     * @param id
     * @return
     */
    TestData query(Integer id);
    
    /**
     * 查询
     * @param id
     * @return
     */
    TestData queryByStudentLast(Integer id);

    /**
     * 修改
     * @param testData
     * @return
     */
    boolean update(TestData testData);
    
    /**
     * 分页查询
     * @param testData
     * @param page
     * @param pageSize
     * @return
     */
    List<TestData> page(TestData testData,Integer page ,Integer pageSize);
    
    /**
     * 分页查询
     * @param testData
     * @return
     */
    List<TestData> pageAll(TestData testData);

}