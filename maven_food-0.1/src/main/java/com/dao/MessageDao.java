package com.dao;

import java.util.List;

import com.entity.Message;

public interface MessageDao {
	
//	获取留言总数量
	public int getTotalCount();
	
//	查询全部留言信息
	public List<Message> getMessageList();
}
