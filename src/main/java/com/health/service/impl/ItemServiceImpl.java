package com.health.service.impl;

import com.health.dao.ItemDao;
import com.health.model.po.Item;
import com.health.service.ItemService;
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
public class ItemServiceImpl implements ItemService {

   /* @Autowired
    private ItemDao itemDao;*/
    
    @Autowired
   	private SQLManager sqlManager;

    @Override
    public List<Item> pageByKeyWord(Item item, Integer page, Integer pageSize) {
        return (List<Item>) sqlManager.list("item.pageByKeyWord", item, page, pageSize);
    }


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sqlManager.delete("item.deleteByPrimaryKey", id);
    }

    @Override
    public int insert(Item item) {
       return  sqlManager.insert("item.insert", item);
    }

    @Override
    public int insertSelective(Item item) {
        return sqlManager.insert("item.insertSelective", item);
    }

    @Override
    public Item selectByPrimaryKey(Integer id) {
        return (Item)sqlManager.query("item.selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(Item item) {
        return sqlManager.update("item.updateByPrimaryKeySelective", item);
    }

    @Override
    public int updateByPrimaryKey(Item item) {
        return sqlManager.update("item.updateByPrimaryKey", item);
    }

}

