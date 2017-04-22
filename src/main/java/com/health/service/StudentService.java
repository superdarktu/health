package com.health.service;

import java.util.List;

import com.health.model.po.Student;

public interface StudentService {
	
    boolean deleteByPrimaryKey(Integer id);

    int insert(Student student);

    Student selectByPrimaryKey(Integer id);

    boolean update(Student student);

    List<Student> page(Student student,Integer page ,Integer pageSize);
}