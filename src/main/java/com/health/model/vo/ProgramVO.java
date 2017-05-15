package com.health.model.vo;

import com.health.model.po.FoodItem;
import com.health.model.po.Item;
import com.health.model.po.Program;

import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */
public class ProgramVO extends Program {

    private List<Item> itemList;
    
    private List<FoodItem> foodList;
    
    public List<FoodItem> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<FoodItem> foodList) {
		this.foodList = foodList;
	}

	public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
