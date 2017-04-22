package com.health.service.impl;

import com.health.dao.FoodDao;
import com.health.model.po.Food;
import com.health.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by forip on 2017/4/22.
 *
 *
 */

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodDao foodDao;

    @Override
    public List<Food> pageByKeyWord(Food record, Integer page, Integer pageSize) {
        return foodDao.pageByKeyWord(record, page, pageSize);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return foodDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Food record) {
       return  foodDao.insert(record);
    }

    @Override
    public int insertSelective(Food record) {
        return foodDao.insertSelective(record);
    }

    @Override
    public Food selectByPrimaryKey(Integer id) {
        return foodDao.selectCityById(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Food record) {
        return foodDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Food record) {
        return foodDao.updateByPrimaryKey(record);
    }

}
