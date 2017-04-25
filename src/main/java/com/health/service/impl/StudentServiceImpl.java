package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.health.dao.StudentDao;
import com.health.model.po.Student;
import com.health.service.StudentService;
import com.health.util.SQLManager;

public class StudentServiceImpl implements StudentService{

	/*@Autowired
	private StudentDao studentDao;*/
	
	@Autowired
   	private SQLManager sqlManager;
	
	/**
	 * 根据ID删除
	 */
	public boolean deleteByPrimaryKey(Integer id) {
		
		return sqlManager.delete("student.deleteByPrimaryKey", id) > 0 ? true :false;
	}

	/**
	 * 添加
	 */
	public int insert(Student student) {
		
		String no = (sqlManager.count("student.count", null)+1)+"";
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<(8-no.length());i++){
			sb.append("0");
		}
		sb.append(no);
		student.setNo(sb.toString());
		return sqlManager.insert("student.insert", student);
	}

	/**
	 * 根据ID查询
	 */
	public Student selectByPrimaryKey(Integer id) {
		
		return (Student) sqlManager.query("student.selectByPrimaryKey", id);
	}

	/**
	 * 修改
	 */
	public boolean update(Student student) {
		
		return sqlManager.update("student.updateByPrimaryKeySelective", student) > 0 ? true :false;
	}
	
	/**
	 * 分页查询
	 */
	public List<Student> page(Student student, Integer page, Integer pageSize) {
		
		return (List<Student>) sqlManager.list("student.selectByStr", student, page, pageSize);
	}

}
