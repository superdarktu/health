package com.health.service;

import java.util.List;

import com.health.model.po.Student;

public interface StudentService {
	
	/**
	 * 根据ID删除
	 * @param id
	 * @return
	 */
    boolean deleteByPrimaryKey(Integer id);

    /**
     * 添加
     * @param student
     * @return
     */
    int insert(Student student);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Student selectByPrimaryKey(Integer id);

    /**
     * 修改
     * @param student
     * @return
     */
    boolean update(Student student);

    /**
     * 分页查询
     * @param student
     * @param page
     * @param pageSize
     * @return
     */
    List<Student> page(Student student,Integer page ,Integer pageSize);
}