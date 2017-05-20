package com.health.model.vo;

import com.health.model.po.FoodItem;
import com.health.model.po.Item;
import com.health.model.po.Program;

import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */
public class ProgramVO extends Program {
	

	private List<List<Item>> items;
    
    private List<List<FoodItemVO>> foods;

	public List<List<Item>> getItems() {
		return items;
	}

	public void setItems(List<List<Item>> items) {
		this.items = items;
	}

	public List<List<FoodItemVO>> getFoods() {
		return foods;
	}

	public void setFoods(List<List<FoodItemVO>> foods) {
		this.foods = foods;
	}


}
