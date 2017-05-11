package com.health.dao;

import com.health.model.po.Equipment;
import com.health.util.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by forip on 2017/4/22.
 */
@Repository
public class EquipmentDao {

    @Autowired
    private SQLManager sqlManager;

    public Equipment selectCityById(long id) {
        return (Equipment) sqlManager.query("equipment.selectByPrimaryKey", id);
    }

    public int insert(Equipment record) {
        return sqlManager.insert("equipment.insert", record);
    }

    public int insertSelective(Equipment record) {
        return sqlManager.insert("equipment.insertSelective", record);
    }

    public int updateByPrimaryKeySelective(Equipment record) {
        return sqlManager.update("equipment.updateByPrimaryKeySelective", record);
    }

    public int updateByPrimaryKey(Equipment record) {
        return sqlManager.update("equipment.updateByPrimaryKey", record);
    }

    public int deleteByPrimaryKey(long id) {
        return sqlManager.delete("equipment.deleteByPrimaryKey", id);
    }

    public List<Equipment> pageByKeyWord(Equipment record, Integer page, Integer pageSize) {
        return (List<Equipment>) sqlManager.list("equipment.pageByKeyWord", record, page, pageSize);
    }
}
