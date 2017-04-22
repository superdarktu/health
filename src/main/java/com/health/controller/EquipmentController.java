package com.health.controller;

import com.health.model.po.Equipment;
import com.health.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @RequestMapping("/test")
    @ResponseBody
    public int home() {
        return equipmentService.deleteByPrimaryKey(1);
    }

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
    public Map listEquipment(@RequestParam(required = false, defaultValue = "1") int page,
                         @RequestParam(required = false, defaultValue = "10") int pageSize,
                         @RequestParam(required = false) String keyWord) {
        Equipment record = new Equipment();
        record.setName(keyWord);
        List<Equipment> list = equipmentService.pageByKeyWord(record, page, pageSize);
        Map resultMap = new HashMap();
        resultMap.put("pageList", list);
        return resultMap;
    }

    /**
     * 增加或修改
     */
    @ResponseBody
    @RequestMapping("save")
    public Map insertOrUpdate(@RequestBody Equipment record) {
        Map resultMap = new HashMap();
        try {
            Integer id = equipmentService.save(record);
            resultMap.put("success", true);
            return resultMap;
        } catch (Exception e) {
            System.out.print(e);
        }
        resultMap.put("success", false);
        return resultMap;
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("remove/{id}")
    public Map remove(@PathVariable("id") int cid) {
        Map resultMap = new HashMap();
        try {
            equipmentService.deleteByPrimaryKey(cid);
            resultMap.put("success", true);
            return resultMap;
        } catch (Exception e) {
            System.out.print(e);
        }
        resultMap.put("success", false);
        return resultMap;
    }
}
