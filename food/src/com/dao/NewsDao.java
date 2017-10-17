package com.dao;

import java.util.List;

import com.entity.News;

public interface NewsDao {
	
//	��ȡ����������
	public int getTotalCount();
//  �������
	public boolean addNews(News news);
//	�޸�����
	public boolean update(News news);
//	ɾ������
	public boolean delete(News news);
//	��ѯȫ��������Ϣ
	public List<News> getNewsList();
//	��ѯ�ض�ID������
	public News getNewsById(int id);
//	��ҳ��ȡ������Ϣ
	public List<News> getPageNewsList(int pageNo,int pageSize);
}
