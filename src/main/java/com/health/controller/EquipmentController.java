package com.health.controller;

import com.health.model.po.Equipment;
import com.health.model.ro.ResultRO;
import com.health.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;


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
    public ResultRO listEquipment(int page, int pageSize, String name) {
        Equipment record = new Equipment();
        record.setName(name);
        return new ResultRO(equipmentService.pageByKeyWord(record, page, pageSize));
    }

    /**
     * 增加或修改
     */
    @ResponseBody
    @RequestMapping("save")
    public ResultRO insertOrUpdate(Equipment record) {

        if (record.getId() == null) {
            if(record.getName() == null)
                return new ResultRO("名字不能为空");
            if (equipmentService.insert(record) > 0) {
                return new ResultRO(true,"equipment");
            }
        } else {
            if (equipmentService.updateByPrimaryKeySelective(record) > 0) {
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

        if (equipmentService.deleteByPrimaryKey(id) > 0) {
            return new ResultRO(true,"equipment");
        }
        return new ResultRO("删除失败");
    }
}
