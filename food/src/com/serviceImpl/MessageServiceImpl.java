package com.serviceImpl;

import java.util.List;

import com.dao.MessageDao;
import com.dao.impl.MessageDaoImpl;
import com.entity.Message;
import com.services.MessageService;

public class MessageServiceImpl implements MessageService {

	MessageDao messageDao = new MessageDaoImpl();
	
	public List<Message> getMessageList() {
		
		return messageDao.getMessageList();
	}

}
