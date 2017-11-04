package com.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import com.dao.BaseDao;
import com.dao.MessageDao;
import com.entity.Message;

public class MessageDaoImpl extends BaseDao implements MessageDao {

	public int getTotalCount() {
		int total = 0;
		String sql = "SELECT COUNT(1) FROM message";
		Object[] params = {};
		ResultSet rs = this.executeSQL(sql, params);
		try {
			while(rs.next()){
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
		}
		
		return total;
	}

	public List<Message> getMessageList() {
		List<Message> list = new ArrayList<Message>();
		String sql = "SELECT id,userName,phone,email,content,publishDate From messages";
		Object[] params = {};
		rs = this.executeSQL(sql, params);
		try {
			while(rs.next()){
				int id = rs.getInt("id");
				String userName = rs.getString("userName");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String content = rs.getString("content");
				Date publishDate = rs.getDate("publishDate");
				
				Message message = new Message();
				message.setId(id);
				message.setEmail(email);
				message.setUserName(userName);
				message.setContent(content);
				message.setPhone(phone);
				message.setPublishDate(publishDate);
				
				list.add(message);
				
				
			}
					
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
		}
		return list;
	}

}
