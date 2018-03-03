package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.HibernateUtil;
import com.dao.NewsDao;
import com.entity.News;

public class NewsDaoImpl implements NewsDao {

//	分页获取新闻列表
	public List<News> getPageNewsList(int pageNo , int pageSize){
		List<News> list = new ArrayList<News>();
		Session sess = HibernateUtil.openSession();
			try {
				String hql = "from News";
				Query query = sess.createQuery(hql);
				query.setFirstResult(pageSize*(pageNo-1));
				query.setMaxResults(pageSize);
				list = query.list();
			} catch (RuntimeException e) {
				
			}
		return list;
		
	}
	
	
	
//	获取新闻总数量
	public int getTotalCount(){
		Session sess = HibernateUtil.openSession();
		Number total = 0;
		try {
			String  hql ="Select  Count(*) from News";
			Query query = sess.createQuery(hql);
			total = (Number) query.uniqueResult();

		} catch (RuntimeException e) {
			
		}
		return (Integer)total.intValue();
		
	}
	
//	插入新闻
	public boolean addNews(News news) {
		Session sess = HibernateUtil.openSession();
		Transaction tx = null;
		boolean flag = false;
		try {
			tx = sess.beginTransaction();
			sess.save(news);
			tx.commit();
			flag = true;
		}catch(RuntimeException e){
			if(tx!=null)
				tx.rollback();
			
		}
		finally{
			sess.close();
		}	
		return flag;
	}
//修改新闻
	public boolean update(News news) {
		Session sess = HibernateUtil.openSession();
		Transaction tx = null;
		boolean flag = false;
		try {
			tx = sess.beginTransaction();
			sess.update(news);
			tx.commit();
			flag = true;
		}catch(RuntimeException e){
			if(tx!=null)
				tx.rollback();
		}
		finally{
			sess.close();
		}	
		return flag;
	}
//删除新闻
	public boolean delete(int id) {
		boolean flag = false;
		Session sess = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			sess.delete(sess.get(News.class, id));
			tx.commit();
			flag = true;
			System.out.println("删除食物成功！");
		}catch(RuntimeException e){
			if(tx!=null)
				tx.rollback();
		}
		finally{
			sess.close();
		}	
		return flag;
	}
//查询新闻
	public List<News> getNewsList() {
		List<News> list = new ArrayList<News>();
		Session sess = HibernateUtil.openSession();
		String hql ="from News ";
		try {
			list = sess.createQuery(hql).list();
		} catch (RuntimeException e) {
		}finally {
			sess.close();
		}
		
		return list;
	}

//	查询特定ID的新闻
	public News getNewsById(int id) {
		Session sess = HibernateUtil.openSession();
		News news = new News();
		try {
			return (News)sess.get(News.class, id);
		}finally{
			sess.close();
		}
	}
}
