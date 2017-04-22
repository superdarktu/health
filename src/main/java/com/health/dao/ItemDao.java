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
		return (Item)sqlManager.query("item.selectByPrimaryKey", id);
	}

	public int insert (Item record) {
		return sqlManager.insert("item.insert", record);
	}

	public int insertSelective (Item record) {
		return sqlManager.insert("item.insertSelective", record);
	}

	public int updateByPrimaryKeySelective (Item record) {
		return sqlManager.update("item.updateByPrimaryKeySelective", record);
	}

	public int updateByPrimaryKey (Item record) {
		return sqlManager.update("item.updateByPrimaryKey", record);
	}

	public int deleteByPrimaryKey (long id) {
		return sqlManager.delete("item.deleteByPrimaryKey", id);
	}

	public List<Item> pageByKeyWord (Item record, Integer page, Integer pageSize) {
		return (List<Item>) sqlManager.list("item.pageByKeyWord", record, page, pageSize);
	}
}
