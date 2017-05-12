package com.health.service.impl;

import com.health.model.po.Standard;
import com.health.service.StandardService;
import com.health.util.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StandardServiceImpl implements StandardService {

    @Autowired
    private SQLManager sqlManager;


    /**
     * 添加
     */
    @Transactional
    public int insert(List<Standard> list) {

        if (list.size() <= 0) return 0;
        Integer result =0;

        sqlManager.delete("standard.delete",list.get(0).getName());
        for (int i = 0; i < list.size(); i++) {

            result = sqlManager.insert("standard.insert", list.get(i));
        }
        return result;
    }


    public List<Standard> selectByPrimaryKey(String name) {

        return (List<Standard>) sqlManager.list("standard.selectByPrimaryKey", name);
    }

    public List<Standard> selectByAge(Integer age, String sex) {

        Standard standard = new Standard();
        standard.setStartAge(age);
        standard.setSex(sex);
        return (List<Standard>) sqlManager.list("standard.list", standard);
    }


}
