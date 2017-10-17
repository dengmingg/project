package com.dao;

import java.util.List;

import com.entity.News;

public interface NewsDao {
	
//	获取新闻总数量
	public int getTotalCount();
//  添加新闻
	public boolean addNews(News news);
//	修改新闻
	public boolean update(News news);
//	删除新闻
	public boolean delete(News news);
//	查询全部新闻信息
	public List<News> getNewsList();
//	查询特定ID的新闻
	public News getNewsById(int id);
//	分页获取新闻信息
	public List<News> getPageNewsList(int pageNo,int pageSize);
}
