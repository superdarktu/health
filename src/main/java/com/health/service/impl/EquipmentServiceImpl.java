package com.health.service.impl;

import com.health.dao.EquipmentDao;
import com.health.model.po.Equipment;
import com.health.service.EquipmentService;
import com.health.util.SQLManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by forip on 2017/4/22.
 *
 *
 */

@Service
public class EquipmentServiceImpl implements EquipmentService {

    /*@Autowired
    private EquipmentDao equipmentDao;*/
    
    @Autowired
	private SQLManager sqlManager;

    @Override
    public List<Equipment> pageByKeyWord(Equipment equipment, Integer page, Integer pageSize) {
        return (List<Equipment>) sqlManager.list("equipment.pageByKeyWord", equipment, page, pageSize);
    }
    
    public List<Equipment> pageByName(Equipment equipment) {
        return (List<Equipment>) sqlManager.list("equipment.pageByName", equipment);
    }

    @Override
    public int save(Equipment equipment) {
        /*if (equipment.getId() == null) {
            return equipmentDao.insertSelective(equipment);
        } else {
            return equipmentDao.updateByPrimaryKeySelective(equipment);
        }*/
    	return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sqlManager.delete("equipment.deleteByPrimaryKey", id);
    }

    @Override
    public int insert(Equipment equipment) {
       return  sqlManager.insert("equipment.insert", equipment);
    }

    @Override
    public int insertSelective(Equipment equipment) {
        return sqlManager.insert("equipment.insertSelective", equipment);
    }

    @Override
    public Equipment selectByPrimaryKey(Integer id) {
        return (Equipment)sqlManager.query("equipment.selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(Equipment equipment) {
        return sqlManager.update("equipment.updateByPrimaryKeySelective", equipment);
    }

    @Override
    public int updateByPrimaryKey(Equipment equipment) {
        return sqlManager.update("equipment.updateByPrimaryKey", equipment);
    }

}
