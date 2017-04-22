package com.health.dao;

import com.health.model.po.Food;
import com.health.util.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodDao {

	@Autowired
	private SQLManager sqlManager;

	public Food selectCityById (long id) {
		return (Food)sqlManager.query("classMapper.selectByPrimaryKey", id);
	}

	public int insert (Food record) {
		return sqlManager.insert("classMapper.insert", record);
	}

	public int insertSelective (Food record) {
		return sqlManager.insert("classMapper.insertSelective", record);
	}

	public int updateByPrimaryKeySelective (Food record) {
		return sqlManager.update("classMapper.updateByPrimaryKeySelective", record);
	}

	public int updateByPrimaryKey (Food record) {
		return sqlManager.update("classMapper.updateByPrimaryKey", record);
	}

	public int deleteByPrimaryKey (long id) {
		return sqlManager.delete("classMapper.deleteByPrimaryKey", id);
	}

	public List<Food> pageByKeyWord (Food record, Integer page, Integer pageSize) {
		return (List<Food>) sqlManager.list("classMapper.pageByKeyWord", record, page, pageSize);
	}
}
