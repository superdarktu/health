package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.health.dao.TeacherDao;
import com.health.model.po.Teacher;
import com.health.service.TeacherService;

public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	private TeacherDao teacherdao;

	/**
	 * 根据ID删除
	 */
	public boolean deleteByPrimaryKey(Integer id) {
		
		return teacherdao.delete(id);
	}

	/**
	 * 添加教练
	 */
	public int insert(Teacher teacher) {
		
		String no = (teacherdao.count()+1)+"";
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<(8-no.length());i++){
			sb.append("0");
		}
		sb.append(no);
		teacher.setNo(sb.toString());
		return teacherdao.insert(teacher);
	}

	/**
	 * 根据ID查询
	 */
	public Teacher selectByPrimaryKey(Integer id) {
		
		return teacherdao.query(id);
	}

	/**
	 * 修改
	 */
	public boolean updateByPrimaryKeySelective(Teacher teacher) {
		
		return teacherdao.update(teacher);
	}

	/**
	 * 获取列表
	 */
	public List<Teacher> page(Teacher teacher, Integer page, Integer pageSize) {
		
		return teacherdao.list(teacher, page, pageSize);
	}

}
