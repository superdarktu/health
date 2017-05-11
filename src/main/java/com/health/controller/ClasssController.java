package com.health.controller;

import com.health.model.po.Classs;
import com.health.model.ro.ResultRO;
import com.health.service.ClasssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/classs")
public class ClasssController {

    @Autowired
    private ClasssService ClasssService;


    /**
     * 首页跳转
     */
    @RequestMapping("toIndex")
    public int toIndex() {
        return 111;
    }

    /**
     * 查询list
     */
    @ResponseBody
    @RequestMapping("list")
    public ResultRO listClasss(int page, int pageSize, String name) {
        Classs record = new Classs();
        record.setName(name);
        return new ResultRO(ClasssService.pageByKeyWord(record, page, pageSize));
    }

    @ResponseBody
    @RequestMapping("search")
    public ResultRO search(String name) {

        return new ResultRO("查询失败");
    }

    /**
     * 增加或修改
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultRO insertOrUpdate(Classs record) {

        if (record.getId() == null) {
            if(record.getName() == null)
                return new ResultRO("名字不能为空");
            if (ClasssService.insert(record) > 0) {
                return new ResultRO(true,"class");
            }
        } else {
            if (ClasssService.updateByPrimaryKeySelective(record) > 0) {
                return new ResultRO(true);
            }
        }

        return new ResultRO("保存失败");
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("delete")
    public ResultRO remove(Integer id) {

        if (ClasssService.deleteByPrimaryKey(id) > 0) {
            return new ResultRO(true,"class");
        }
        return new ResultRO("删除失败");
    }
}
