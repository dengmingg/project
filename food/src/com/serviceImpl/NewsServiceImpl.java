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
//	获取新闻列表
	public List<News> getNewsList() {
		return newsdao.getNewsList();
	}
//	查询特定ID的新闻
	public News getNewsById(int id) {
		return newsdao.getNewsById(id);
	}
//	获取新闻总数量
	public int getTotalCount() {
		return newsdao.getTotalCount();
	}
//	分页获取新闻信息
	public List<News> getPageNewsList(int pageNo , int pageSize){
		return newsdao.getPageNewsList(pageNo, pageSize);
	}
}
