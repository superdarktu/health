package com.health.service.impl;

import com.health.model.po.Food;
import com.health.service.FoodService;
import com.health.util.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by forip on 2017/4/22.
 */

@Service
public class FoodServiceImpl implements FoodService {

    /*@Autowired
    private FoodDao foodDao;*/

    @Autowired
    private SQLManager sqlManager;

    @Override
    public List<Food> pageByKeyWord(Food food, Integer page, Integer pageSize) {
        return (List<Food>) sqlManager.list("food.pageByKeyWord", food, page, pageSize);
    }

    public List<Food> pageByName(Food food) {
        return (List<Food>) sqlManager.list("food.pageByKeyWord", food);
    }

    @Override
    public int save(Food food) {
        /*if (food.getId() == null) {
            return foodDao.insertSelective(food);
        } else {
            return foodDao.updateByPrimaryKeySelective(food);
        }*/
        return 0;
    }

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return sqlManager.delete("food.deleteByPrimaryKey", id);
    }

    @Override
    public int insert(Food food) {
        return sqlManager.insert("food.insert", food);
    }

    @Override
    public int insertSelective(Food food) {
        return sqlManager.insert("food.insertSelective", food);
    }

    @Override
    public Food selectByPrimaryKey(Integer id) {
        return (Food) sqlManager.query("food.selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(Food food) {
        return sqlManager.update("food.updateByPrimaryKeySelective", food);
    }

    @Override
    public int updateByPrimaryKey(Food food) {
        return sqlManager.update("food.updateByPrimaryKey", food);
    }

}
