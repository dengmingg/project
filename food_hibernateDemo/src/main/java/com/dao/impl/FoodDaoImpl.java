package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.FoodDao;
import com.dao.HibernateUtil;
import com.entity.Category;
import com.entity.Food;

public class FoodDaoImpl implements FoodDao {

	
//	��ȡʳ��������
	public int getTotalCount(){
		Session sess = HibernateUtil.openSession();
		Number total = 0;
		try {
			String  hql ="Select  Count(*) from Food  ";
			Query query = sess.createQuery(hql);
			total = (Number) query.uniqueResult();

		} catch (RuntimeException e) {
			
		}
		return (Integer)total.intValue();
		
	}
//	��ҳ��ȡʳ���б�
	public List<Food> getPageFoodList(int pageNo , int pageSize){
		Session sess = HibernateUtil.openSession();
		List<Food> list = new ArrayList<Food>();
			try {
				String hql = "from Food";
				Query query = sess.createQuery(hql);
				query.setFirstResult(pageSize*(pageNo-1));
				query.setMaxResults(pageSize);
				list = query.list();
			} catch (RuntimeException e) {
				
			}
		return list;
		
	}
//	����ʳ��
	public boolean addFood(Food food) {
		Session sess = HibernateUtil.openSession();
		Transaction tx = null;
		boolean flag = false;
		try {
			tx = sess.beginTransaction();
			sess.save(food);
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
//  �޸�ʳ��
	public boolean update(Food food) {
		Session sess = HibernateUtil.openSession();
		Transaction tx = null;
		boolean flag = false;
		try {
			tx = sess.beginTransaction();
			sess.update(food);
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
//  ɾ��ʳ��
	public boolean delete(int id) {
		Session sess = HibernateUtil.openSession();
		Transaction tx = null;
		boolean flag = false;
		try {
			tx = sess.beginTransaction();
			
			sess.delete(sess.get(Food.class, id));
			tx.commit();
			flag = true;
			System.out.println("ɾ��ʳ��ɹ���");
		}catch(RuntimeException e){
			if(tx!=null)
				tx.rollback();
		}
		finally{
			sess.close();
		}	
		return flag;
	}
//  ��ѯȫ��ʳ��
	public List<Food> getFoodList() {
		Session sess = HibernateUtil.openSession();
		try {
			return	sess.createQuery("from Food").list();
		} finally{
			sess.close();
		}
	}
//	��ѯ�ض�ʳ����Ϣ
	public Food getFoodById(int id) {
		Session sess = HibernateUtil.openSession();
		try {
			return (Food)sess.get(Food.class, id);
		}finally{
			sess.close();
		}
		
			
		
	}

//	����ʳ������ѯʳ��
	public List<Food> getFoodByCategoryId(int categoryId) {
		List<Food> list = new ArrayList<Food>();
		Session sess = HibernateUtil.openSession();
		
		try {
			String hql = "from Food fd where fd.category.id = ?";
			Query query = sess.createQuery(hql);
			
			list = (List<Food>)query.setInteger(0, categoryId).list();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}finally{
			sess.close();
		}
		return list;
	}
//	����ʳ���������Ʋ�ѯʳ��
	public Food getFoodByChineseName(String chineseName) {
		Session sess = HibernateUtil.openSession();
		Food food = new Food();
		try {
			String hql = "from Food food where food.chineseName=?";
			Query query = sess.createQuery(hql);
			food = (Food)query.setString(0, chineseName);
		} catch (RuntimeException e) {
			 
		}finally{
			sess.close();
		}
		return food;
	}


}
