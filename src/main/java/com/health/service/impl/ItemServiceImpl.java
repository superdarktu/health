package com.health.service.impl;

import com.health.dao.ItemDao;
import com.health.model.po.Item;
import com.health.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by forip on 2017/4/22.
 *
 *
 */

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Item> pageByKeyWord(Item record, Integer page, Integer pageSize) {
        return itemDao.pageByKeyWord(record, page, pageSize);
    }


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return itemDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Item record) {
       return  itemDao.insert(record);
    }

    @Override
    public int insertSelective(Item record) {
        return itemDao.insertSelective(record);
    }

    @Override
    public Item selectByPrimaryKey(Integer id) {
        return itemDao.selectCityById(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Item record) {
        return itemDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Item record) {
        return itemDao.updateByPrimaryKey(record);
    }

}

