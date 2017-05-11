package com.health.service;

import com.health.model.po.Message;

import java.util.List;

public interface MessageService {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    List<Message> list();

}