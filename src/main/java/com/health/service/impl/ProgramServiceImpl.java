package com.health.service.impl;

import com.health.model.po.FoodItem;
import com.health.model.po.Item;
import com.health.model.po.Program;
import com.health.model.vo.FoodItemVO;
import com.health.model.vo.ProgramVO;
import com.health.service.FoodItemService;
import com.health.service.ItemService;
import com.health.service.ProgramService;
import com.health.util.SQLManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService {

    @Autowired
    private SQLManager sqlManager;

    @Autowired
    private ItemService itemService;
    
    @Autowired
    private FoodItemService foodItemService;

    /**
     * 根据ID删除
     */
    @Transactional
    public boolean deleteByPrimaryKey(String no) {

        itemService.deleteByPrimaryKey(no);
        return sqlManager.delete("program.deleteByPrimaryKey", no) > 0 ? true : false;
    }

    /**
     * 添加
     */
    /*@Transactional
    public boolean addProgram(List<ProgramVO> list, String no) {

        for (int i = 0; i < list.size(); i++) {
            ProgramVO po = list.get(i);
            List<Item> items = po.getItemList();
            List<FoodItem> foods = po.getFoodList();
            po.setTeacherNo(no);
            sqlManager.insert("program.insert", po);
            for (int u = 0; u < items.size(); u++) {

                Item item = items.get(u);
                item.setProgramId(po.getId());
                item.setNo(po.getNo());
                itemService.insert(item);
            }
            for(int u = 0; u < items.size(); u++){
            	
            	FoodItem food = foods.get(u);
            	food.setProgramId(po.getId());
            	foodItemService.insert(food);
            }
        }
        return true;
    }*/

    /**
     * 根据ID查询
     */
    public List<ProgramVO> selectByNo(String no) {

        List<ProgramVO> lpv = (List<ProgramVO>) sqlManager.list("program.selectByNo", no);

        for (int i = 0; i < lpv.size(); i++) {
            ProgramVO pv = lpv.get(i);
       //     pv.setItemList(itemService.pageByKeyWord(pv.getId()));
        }
        return lpv;
    }


    /**
     * 分页查询
     */
    public List<Program> page(Program program, Integer page, Integer pageSize) {

        return (List<Program>) sqlManager.list("program.page", program, page, pageSize);
    }

    @Transactional
	public boolean insert(ProgramVO pv) {
		
		Program pm = new Program();
		List<List<Item>> itemss = pv.getItems();
		List<List<FoodItemVO>> foodss = pv.getFoods();
		int length = itemss.size() >= foodss.size() ? itemss.size() : foodss.size();
		if(length == 0) 
			return false;
		for(int i=0;i<length;i++){
			
			pv.setId(null);
			pv.setDays(i+1);
			int pid  = sqlManager.insert("program.insert", pv);
			List<Item> items  = itemss.get(i);
			List<FoodItemVO> foods = foodss.get(i);
			if(items.size()>0){
				for(int u=0;u<items.size();u++){

					Item item = items.get(u);
					item.setNo(pv.getNo());
					item.setProgramId(pid);
					sqlManager.insert("item.insert", item);
				}
			}
			if(foods.size()>0){
			
				for(int u=0;u<foods.size();u++){
					
					FoodItemVO  fo  = foods.get(u);
					FoodItem f1 = new FoodItem();
					FoodItem f2 = new FoodItem();
					FoodItem f3 = new FoodItem();
					f1.setFood(fo.getName1());
					f2.setFood(fo.getName2());
					f3.setFood(fo.getName3());
					f1.setNumber(fo.getNum1());
					f2.setNumber(fo.getNum2());
					f3.setNumber(fo.getNum3());
					f1.setWhen(1);
					f2.setWhen(2);
					f3.setWhen(3);
					f1.setProgramId(pid);
					f1.setProgramId(pid);
					f1.setProgramId(pid);
					sqlManager.insert("foodItem.insert", f1);
					sqlManager.insert("foodItem.insert", f2);
					sqlManager.insert("foodItem.insert", f3);
				}
			}
		}
		return true;
	}

	public ProgramVO getProgram(String no){
		
		ProgramVO pv = new ProgramVO();
		List<Program> programs = (List<Program>)sqlManager.list("program.listByNo", no);
		List<List<Item>> itemss = new ArrayList<List<Item>>();
		List<List<FoodItemVO>> foodss = new ArrayList<List<FoodItemVO>>();
		for(int i=0;i<programs.size();i++){
			Program program = programs.get(i);
			List<Item> items = (List<Item>)sqlManager.list("item.listByPid", program.getId());
			if(items.size() > 0)
				itemss.add(items);
			
			List<FoodItem> foods1 = (List<FoodItem>) sqlManager.list("item.listByPid1", program.getId());
			List<FoodItem> foods2 = (List<FoodItem>) sqlManager.list("item.listByPid2", program.getId());
			List<FoodItem> foods3 = (List<FoodItem>) sqlManager.list("item.listByPid3", program.getId());
			int length = foods1.size();
			if(foods2.size()>length) length = foods2.size();
			if(foods3.size() > length) length = foods3.size();
			List<FoodItemVO> foods = new ArrayList<FoodItemVO>();
			for(int u=0;u<length;u++){
				FoodItemVO fv = new FoodItemVO();
				if(foods1.get(u) != null){
					fv.setName1(foods1.get(u).getFood());
					fv.setNum1(foods1.get(u).getNumber());
				}
				if(foods2.get(u) != null){
					fv.setName1(foods2.get(u).getFood());
					fv.setNum1(foods2.get(u).getNumber());
				}
				if(foods3.get(u) != null){
					fv.setName1(foods3.get(u).getFood());
					fv.setNum1(foods3.get(u).getNumber());
				}
				foods.add(fv);
			}
			foodss.add(foods);
		}
		pv.setFoods(foodss);
		pv.setItems(itemss);
		pv.setCfmd(programs.get(0).getCfmd());
		pv.setNo(programs.get(0).getNo());
		pv.setJszyd(programs.get(0).getJszyd());
		return pv;
	}

	@Transactional
	public boolean update(ProgramVO pv) {
		
		deleteByPrimaryKey(pv.getNo());
		insert(pv);
		return true;
	}

}
