package com.services;

import java.util.List;

import com.entity.News;

public interface NewsService {
	
//	获取新闻列表
	public List<News> getNewsList();
//	查询特定ID的新闻
	public News getNewsById(int id);
//	获取新闻总数量
	public int getTotalCount();
//	分页获取新闻信息
	public List<News> getPageNewsList(int pageNo , int pageSize);
}
