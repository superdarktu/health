package com.health.service.impl;

import com.health.dao.ClassDao;
import com.health.model.po.Class;
import com.health.service.ClassService;
import com.health.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by forip on 2017/4/22.
 *
 *
 */

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDao classDao;

    @Override
    public List<Class> pageByKeyWord (Class record, Integer page, Integer pageSize) {
        return classDao.pageByKeyWord(record, page, pageSize);
    }

    @Override
    public int deleteByPrimaryKey (Integer id) {
        return classDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert (Class record) {
       return  classDao.insert(record);
    }

    @Override
    public int insertSelective (Class record) {
        return classDao.insertSelective(record);
    }

    @Override
    public Class selectByPrimaryKey (Integer id) {
        return classDao.selectCityById(id);
    }

    @Override
    public int updateByPrimaryKeySelective (Class record) {
        return classDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey (Class record) {
        return classDao.updateByPrimaryKey(record);
    }

}
