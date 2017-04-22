package com.health.service.impl;

import com.health.dao.EquipmentDao;
import com.health.model.po.Equipment;
import com.health.service.EquipmentService;
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

    @Autowired
    private EquipmentDao equipmentDao;

    @Override
    public List<Equipment> pageByKeyWord(Equipment record, Integer page, Integer pageSize) {
        return equipmentDao.pageByKeyWord(record, page, pageSize);
    }

    @Override
    public int save(Equipment record) {
        if (record.getId() == null) {
            return equipmentDao.insertSelective(record);
        } else {
            return equipmentDao.updateByPrimaryKeySelective(record);
        }
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return equipmentDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Equipment record) {
       return  equipmentDao.insert(record);
    }

    @Override
    public int insertSelective(Equipment record) {
        return equipmentDao.insertSelective(record);
    }

    @Override
    public Equipment selectByPrimaryKey(Integer id) {
        return equipmentDao.selectCityById(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Equipment record) {
        return equipmentDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Equipment record) {
        return equipmentDao.updateByPrimaryKey(record);
    }

}
