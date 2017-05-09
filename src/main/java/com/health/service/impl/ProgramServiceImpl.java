package com.health.service.impl;

import java.util.List;

import com.health.model.po.Item;
import com.health.model.vo.ProgramVO;
import com.health.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.po.Program;
import com.health.service.ProgramService;
import com.health.util.SQLManager;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProgramServiceImpl implements ProgramService{
	
	@Autowired
   	private SQLManager sqlManager;

	@Autowired
	private ItemService itemService;

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
	@Transactional
	public boolean addProgram(List<ProgramVO> list,String no) {

		for(int i=0;i<list.size();i++){
			ProgramVO po = list.get(i);
			List<Item> items = po.getItemList();
			po.setTeacherNo(no);
			sqlManager.insert("program.insert", po);
			for(int u=00;u<items.size();u++){

				Item item = items.get(u);
				item.setProgramId(po.getId());
				item.setNo(po.getNo());
				itemService.insert(item);
			}
		}
		return true;
	}

	/**
	 * 根据ID查询
	 */
	public List<ProgramVO> selectByNo(String no) {

		List<ProgramVO> lpv = (List<ProgramVO>)sqlManager.list("program.selectByNo",no);

		for(int i=0;i<lpv.size();i++){
			ProgramVO pv = lpv.get(i);
			pv.setItemList(itemService.pageByKeyWord(pv.getId()));
		}
		return lpv;
	}


	/**
	 * 分页查询
	 */
	public List<Program> page(Program program, Integer page, Integer pageSize) {
		
		return (List<Program>) sqlManager.list("program.page", program, page, pageSize);
	}

}
