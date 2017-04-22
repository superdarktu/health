package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.health.dao.StudentDao;
import com.health.model.po.Student;
import com.health.service.StudentService;

public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	/**
	 * 根据ID删除
	 */
	public boolean deleteByPrimaryKey(Integer id) {
		
		return studentDao.delete(id);
	}

	/**
	 * 添加
	 */
	public int insert(Student student) {
		
		String no = (studentDao.count()+1)+"";
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<(8-no.length());i++){
			sb.append("0");
		}
		sb.append(no);
		student.setNo(sb.toString());
		return studentDao.insert(student);
	}

	/**
	 * 根据ID查询
	 */
	public Student selectByPrimaryKey(Integer id) {
		
		return studentDao.query(id);
	}

	/**
	 * 修改
	 */
	public boolean update(Student student) {
		
		return studentDao.update(student);
	}
	
	/**
	 * 分页查询
	 */
	public List<Student> page(Student student, Integer page, Integer pageSize) {
		
		return studentDao.list(student, page, pageSize);
	}

}
