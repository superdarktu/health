package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.po.TestData;
import com.health.service.TestDataService;
import com.health.util.SQLManager;

@Service
public class TestDataServiceImpl implements TestDataService{

	@Autowired
	private SQLManager sqlManager;
	
	/**
	 * 删除
	 */
	public boolean delete(Integer id) {
		
		return sqlManager.delete("testData.delete", id) > 0 ? true : false;
	}

	/**
	 * 添加
	 */
	public int insert(TestData testData) {
		
		return sqlManager.insert("testData.insert", testData);
	}

	/**
	 * 查询
	 */
	public TestData query(Integer id) {
		
		return (TestData) sqlManager.query("testData.query", id);
	}

	/**
	 * 修改
	 */
	public boolean update(TestData testData) {
		
		return sqlManager.update("testData.update", testData) > 0 ? true : false;
	}

	/**
	 * 分页查询
	 */
	public List<TestData> page(TestData testData, Integer page, Integer pageSize) {
		
		return (List<TestData>) sqlManager.list("testData.page", testData, page, pageSize);
	}

}
