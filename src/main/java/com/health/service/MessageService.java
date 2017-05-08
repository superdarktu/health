package com.health.service;

import java.util.List;

import com.health.model.po.Message;

public interface MessageService {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    List<Message> list();

}