package com.dao;

import java.util.List;

import com.entity.Message;

public interface MessageDao {
	
//	��ȡ����������
	public int getTotalCount();
	
//	��ѯȫ��������Ϣ
	public List<Message> getMessageList();
}
