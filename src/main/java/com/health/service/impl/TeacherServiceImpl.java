package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.health.dao.TeacherDao;
import com.health.model.po.Teacher;
import com.health.service.TeacherService;
import com.health.util.SQLManager;

public class TeacherServiceImpl implements TeacherService{
	
	/*@Autowired
	private TeacherDao teacherdao;*/
	
	@Autowired
   	private SQLManager sqlManager;

	/**
	 * 根据ID删除
	 */
	public boolean deleteByPrimaryKey(Integer id) {
		
		return sqlManager.delete("teacher.deleteByPrimaryKey", id) > 0 ? true :false;
	}

	/**
	 * 添加教练
	 */
	public int insert(Teacher teacher) {
		
		String no = (sqlManager.count("teacher.count", null)+1)+"";
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<(8-no.length());i++){
			sb.append("0");
		}
		sb.append(no);
		teacher.setNo(sb.toString());
		return sqlManager.insert("teacher.insert", teacher);
	}

	/**
	 * 根据ID查询
	 */
	public Teacher selectByPrimaryKey(Integer id) {
		
		return (Teacher) sqlManager.query("teacher.selectByPrimaryKey", id);
	}

	/**
	 * 修改
	 */
	public boolean updateByPrimaryKeySelective(Teacher teacher) {
		
		return sqlManager.update("teacher.updateByPrimaryKeySelective", teacher) > 0 ? true :false;
	}

	/**
	 * 获取列表
	 */
	public List<Teacher> page(Teacher teacher, Integer page, Integer pageSize) {
		
		return (List<Teacher>) sqlManager.list("teacher.selectByStr", teacher, page, pageSize);
	}

}
