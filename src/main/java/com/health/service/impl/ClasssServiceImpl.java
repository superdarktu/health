package com.health.service.impl;

import com.health.model.po.Classs;
import com.health.service.ClasssService;
import com.health.util.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by forip on 2017/4/22.
 */

@Service
public class ClasssServiceImpl implements ClasssService {

    /*@Autowired
    private ClasssDao ClasssDao;*/

    @Autowired
    private SQLManager sqlManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<Classs> pageByKeyWord(Classs record, Integer page, Integer pageSize) {
        return (List<Classs>) sqlManager.list("class.pageByKeyWord", record, page, pageSize);
    }


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sqlManager.delete("class.deleteByPrimaryKey", id);
    }

    @Override
    public int insert(Classs record) {
        return sqlManager.insert("class.insert", record);
    }

    @Override
    public int insertSelective(Classs record) {
        return sqlManager.insert("class.insertSelective", record);
    }

    @Override
    public Classs selectByPrimaryKey(Integer id) {
        return (Classs) sqlManager.query("class.selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(Classs record) {
        return sqlManager.update("class.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKey(Classs record) {
        return sqlManager.update("class.updateByPrimaryKey", record);
    }

    public List<Classs> pageByName(String name) {

        Classs record = new Classs();
        record.setName(name);

        return (List<Classs>) sqlManager.list("class.pageByName", record);
    }

}
