package com.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.NewsDao;
import com.entity.News;

public class NewsDaoImpl extends BaseDao implements NewsDao {

//	��ҳ��ȡ�����б�
	public List<News> getPageNewsList(int pageNo , int pageSize){
		List<News> list = new ArrayList<News>();
		String sql = "SELECT id,title,content,userId,publishDate FROM news WHERE 1=1 order by id LIMIT ?,?";
		Object[] params = {(pageNo-1)*pageSize, pageSize};
		ResultSet rs =this.executeSQL(sql, params);

			try {
				while(rs.next()){
					int id = rs.getInt("id");
					String title = rs.getString("title");
					String content = rs.getString("content");
					int userId = rs.getInt("userId");
					Date publishDate = rs.getDate("publishDate");
					
					News news = new News();
					news.setId(id);
					news.setTitle(title);
					news.setContent(content);
					news.setPublishDate(publishDate);
					news.setUserId(userId);
									
					list.add(news);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return list;
		
	}
	
	
	
//	��ȡ����������
	public int getTotalCount(){
		int total = 0;
		String  sql ="SELECT COUNT(1) FROM news";
		Object[] params={};
		ResultSet rs = this.executeSQL(sql, params);
		try {
			while(rs.next()){
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
		
	}
	
//	��������
	public boolean addNews(News news) {
		boolean flag = false;
		String sql = "insert into news(id,title,content,pulishDate,userId) values(?,?,?,?,?)";
		Object[] params ={news.getId(),news.getTitle(),news.getContent(),news.getPublishDate(),news.getUserId()};
		int i = this.executeupdate(sql, params);
		if(i>0){
			System.out.println("�������ųɹ���");
			flag = true;
		}	
		return flag;
		
	}
//�޸�����
	public boolean update(News news) {
		boolean flag = false;
		String sql = "update news set title=? where id=?";
		Object[] params = {news.getTitle(),news.getId()};
		int i = this.executeupdate(sql, params);
		if (i > 0) {
			System.out.println("�޸����ű���ɹ���");
			flag = true;
		}
		return flag;
	}
//ɾ������
	public boolean delete(News news) {
		boolean flag = false;
		String sql = "delete  from news where id=?";
		Object[] params ={news.getId()};
		int i = this.executeupdate(sql,params);
		if (i > 0) {
			System.out.println("ɾ�����ųɹ���");
			flag = true;
		}
		return flag;
	}
//��ѯ����
	public List<News> getNewsList() {
		List<News> list = new ArrayList<News>();
		String sql ="select * from news ";
		Object[] params = {};
		rs = this.executeSQL(sql, params);
		try {
			while(rs.next()){
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int userId = rs.getInt("userId");
				Date publishDate = rs.getDate("publishDate");
				
				News news = new News();
				news.setId(id);
				news.setTitle(title);
				news.setContent(content);
				news.setPublishDate(publishDate);
				news.setUserId(userId);
			
				
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeResource();
		}
		
		return list;
	}

//	��ѯ�ض�ID������
	public News getNewsById(int id) {
		News news = new News();
		String sql = "SELECT title,content,publishDate,userId from news WHERE id = ?";
		Object[] params = {id};
		rs = this.executeSQL(sql, params);
		try {
			while(rs.next()){
				
				String title = rs.getString("title");
				String content = rs.getString("content");
				int userId = rs.getInt("userId");
				Date publishDate = rs.getDate("publishDate");
				
				news.setTitle(title);
				news.setContent(content);
				news.setPublishDate(publishDate);
				news.setUserId(userId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
		}
		return news;
	}
}
