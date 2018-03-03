package com.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.HibernateUtil;
import com.dao.MessageDao;
import com.entity.Message;

public class MessageDaoImpl implements MessageDao {

	public int getTotalCount() {
		Session sess = HibernateUtil.openSession();
		Number total = 0;
		String  hql ="Select  Count(*) from  message";
		try {
			Query query = sess.createQuery(hql);
			total = (Number) query.uniqueResult();
		} catch (RuntimeException e) {
			
		}finally{
			sess.close();
		}
		
		return (Integer)total.intValue();
	}

	public List<Message> getMessageList() {
		List<Message> list = new ArrayList<Message>();
		Session sess = HibernateUtil.openSession();
		try {
			
			String hql = "from Message";
			list = sess.createQuery(hql).list();
		} catch (RuntimeException e) {
			
		}finally{
			sess.close();
		}
		return list;
	}

}
