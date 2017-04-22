package com.health.dao;

import com.health.model.po.Class;
import com.health.util.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassDao {

	@Autowired
	private SQLManager sqlManager;

	public Class selectCityById (long id) {
		return (Class)sqlManager.query("classMapper.selectByPrimaryKey", id);
	}

	public int insert (Class record) {
		return sqlManager.insert("classMapper.insert", record);
	}

	public int insertSelective (Class record) {
		return sqlManager.insert("classMapper.insertSelective", record);
	}

	public int updateByPrimaryKeySelective (Class record) {
		return sqlManager.update("classMapper.updateByPrimaryKeySelective", record);
	}

	public int updateByPrimaryKey (Class record) {
		return sqlManager.update("classMapper.updateByPrimaryKey", record);
	}

	public int deleteByPrimaryKey (long id) {
		return sqlManager.delete("classMapper.deleteByPrimaryKey", id);
	}

	public List<Class> pageByKeyWord (Class record, Integer page, Integer pageSize) {
		return (List<Class>) sqlManager.list("classMapper.pageByKeyWord", record, page, pageSize);
	}
}
