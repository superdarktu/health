package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.po.Student;
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
	public int insert(TestData testData,Student student) {
		
		testData.setStudentId(student.getId());
		testData.setYtb(testData.getWaist()/testData.getHip());
		Double bmr = 0.0;
		if("1".equals(student.getSex())){
			bmr = 66 + 13.7*testData.getWeight()+5*testData.getHeight()-6.8*student.getAge();
		}else{
			bmr = 655 + 9.6*testData.getWeight()+1.8*testData.getHeight()-64.7*student.getAge();
		}
		testData.setBmr(bmr);
		testData.setBmi(testData.getWeight()/testData.getHeight()/testData.getHeight());
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

	public TestData queryByStudentLast(Integer studentId) {
		return (TestData) sqlManager.query("testData.queryByStudentLast", studentId);
	}
	
	public TestData queryByStudentFirst(Integer studentId) {
		return (TestData) sqlManager.query("testData.queryByStudentFirst", studentId);
	}

	@Override
	public List<TestData> pageAll(TestData testData) {
		
		return (List<TestData>) sqlManager.list("testData.page",testData);
	}

}
