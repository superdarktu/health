package com.health.dao;

import com.health.model.po.Item;
import com.health.util.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDao {

	@Autowired
	private SQLManager sqlManager;

	public Item selectCityById (long id) {
		return (Item)sqlManager.query("classMapper.selectByPrimaryKey", id);
	}

	public int insert (Item record) {
		return sqlManager.insert("classMapper.insert", record);
	}

	public int insertSelective (Item record) {
		return sqlManager.insert("classMapper.insertSelective", record);
	}

	public int updateByPrimaryKeySelective (Item record) {
		return sqlManager.update("classMapper.updateByPrimaryKeySelective", record);
	}

	public int updateByPrimaryKey (Item record) {
		return sqlManager.update("classMapper.updateByPrimaryKey", record);
	}

	public int deleteByPrimaryKey (long id) {
		return sqlManager.delete("classMapper.deleteByPrimaryKey", id);
	}

	public List<Item> pageByKeyWord (Item record, Integer page, Integer pageSize) {
		return (List<Item>) sqlManager.list("classMapper.pageByKeyWord", record, page, pageSize);
	}
}
