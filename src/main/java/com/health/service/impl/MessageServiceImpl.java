package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.po.Message;
import com.health.service.MessageService;
import com.health.util.SQLManager;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Autowired
    private SQLManager sqlManager;

	public int deleteByPrimaryKey(Integer id) {
		
		return sqlManager.insert("message.delete", id);
	}

	public int insert(Message record) {
		
		return  sqlManager.insert("message.insert", record);
	}


	public List<Message> list() {
		
		return (List<Message>) sqlManager.list("message.list",null);
	}


}
