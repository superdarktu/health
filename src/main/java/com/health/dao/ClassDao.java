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
		return (Class)sqlManager.query("class.selectByPrimaryKey", id);
	}

	public int insert (Class record) {
		return sqlManager.insert("class.insert", record);
	}

	public int insertSelective (Class record) {
		return sqlManager.insert("class.insertSelective", record);
	}

	public int updateByPrimaryKeySelective (Class record) {
		return sqlManager.update("class.updateByPrimaryKeySelective", record);
	}

	public int updateByPrimaryKey (Class record) {
		return sqlManager.update("class.updateByPrimaryKey", record);
	}

	public int deleteByPrimaryKey (long id) {
		return sqlManager.delete("class.deleteByPrimaryKey", id);
	}

	public List<Class> pageByKeyWord (Class record, Integer page, Integer pageSize) {
		return (List<Class>) sqlManager.list("class.pageByKeyWord", record, page, pageSize);
	}
}
