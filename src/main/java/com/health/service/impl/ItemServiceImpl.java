package com.health.service.impl;

import com.health.model.po.Item;
import com.health.service.ItemService;
import com.health.util.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by forip on 2017/4/22.
 */

@Service
public class ItemServiceImpl implements ItemService {

   /* @Autowired
    private ItemDao itemDao;*/

    @Autowired
    private SQLManager sqlManager;

    public List<Item> pageByKeyWord(Integer programId) {
        return (List<Item>) sqlManager.list("item.selectByPrimaryKey", programId);
    }

    public int deleteByPrimaryKey(String no) {
        return sqlManager.delete("item.deleteByPrimaryKey", no);
    }

    public int insert(Item item) {
        return sqlManager.insert("item.insert", item);
    }


}

