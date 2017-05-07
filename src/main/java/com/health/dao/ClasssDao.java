package com.health.dao;

import com.health.model.po.Classs;
import com.health.util.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClasssDao {

	@Autowired
	private SQLManager sqlManager;

	public Classs selectCityById (long id) {
		return (Classs)sqlManager.query("class.selectByPrimaryKey", id);
	}

	public int insert (Classs record) {
		return sqlManager.insert("class.insert", record);
	}

	public int insertSelective (Classs record) {
		return sqlManager.insert("class.insertSelective", record);
	}

	public int updateByPrimaryKeySelective (Classs record) {
		return sqlManager.update("class.updateByPrimaryKeySelective", record);
	}

	public int updateByPrimaryKey (Classs record) {
		return sqlManager.update("class.updateByPrimaryKey", record);
	}

	public int deleteByPrimaryKey (long id) {
		return sqlManager.delete("class.deleteByPrimaryKey", id);
	}

	public List<Classs> pageByKeyWord (Classs record, Integer page, Integer pageSize) {
		return (List<Classs>) sqlManager.list("class.pageByKeyWord", record, page, pageSize);
	}
}
