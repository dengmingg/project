package com.serviceImpl;

import java.util.List;

import com.dao.NewsDao;
import com.dao.impl.NewsDaoImpl;
import com.entity.News;
import com.services.NewsService;

public class NewsServiceImpl implements NewsService{
	private NewsDao newsdao;
	
	public  NewsServiceImpl(){
		newsdao = new NewsDaoImpl();
	}
//	��ȡ�����б�
	public List<News> getNewsList() {
		return newsdao.getNewsList();
	}
//	��ѯ�ض�ID������
	public News getNewsById(int id) {
		return newsdao.getNewsById(id);
	}
//	��ȡ����������
	public int getTotalCount() {
		return newsdao.getTotalCount();
	}
//	��ҳ��ȡ������Ϣ
	public List<News> getPageNewsList(int pageNo , int pageSize){
		return newsdao.getPageNewsList(pageNo, pageSize);
	}
}
