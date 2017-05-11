package com.health.model.vo;

import com.health.model.po.Item;
import com.health.model.po.Program;

import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */
public class ProgramVO extends Program {

    private List<Item> itemList;

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
