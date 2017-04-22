package com.health.service;

import java.util.List;

import com.health.model.po.Teacher;

public interface TeacherService {
	
    boolean deleteByPrimaryKey(Integer id);

    int insert(Teacher teacher);

    Teacher selectByPrimaryKey(Integer id);

    boolean updateByPrimaryKeySelective(Teacher teacher);

    List<Teacher> page(Teacher teacher,Integer page,Integer pageSize);
}