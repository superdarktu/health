package com.health.service.impl;

import com.health.dao.ClassDao;
import com.health.model.po.Class;
import com.health.service.ClassService;
import com.health.util.SQLManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by forip on 2017/4/22.
 */

@Service
public class ClassServiceImpl implements ClassService {

    /*@Autowired
    private ClassDao classDao;*/
    
    @Autowired
	private SQLManager sqlManager;

    @SuppressWarnings("unchecked")
	@Override
    public List<Class> pageByKeyWord(Class record, Integer page, Integer pageSize) {
        return (List<Class>) sqlManager.list("class.pageByKeyWord", record, page, pageSize);
    }

    @Override
    public int save(Class record) {
        /*if (record.getId() == null) {
            return classDao.insertSelective(record);
        } else {
            return classDao.updateByPrimaryKeySelective(record);
        }*/
    	return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sqlManager.delete("class.deleteByPrimaryKey", id);
    }

    @Override
    public int insert(Class record) {
       return  sqlManager.insert("class.insert", record);
    }

    @Override
    public int insertSelective(Class record) {
        return sqlManager.insert("class.insertSelective", record);
    }

    @Override
    public Class selectByPrimaryKey(Integer id) {
        return (Class)sqlManager.query("class.selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(Class record) {
        return sqlManager.update("class.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKey(Class record) {
        return sqlManager.update("class.updateByPrimaryKey", record);
    }

}
