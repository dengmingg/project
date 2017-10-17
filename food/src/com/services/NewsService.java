package com.services;

import java.util.List;

import com.entity.News;

public interface NewsService {
	
//	��ȡ�����б�
	public List<News> getNewsList();
//	��ѯ�ض�ID������
	public News getNewsById(int id);
//	��ȡ����������
	public int getTotalCount();
//	��ҳ��ȡ������Ϣ
	public List<News> getPageNewsList(int pageNo , int pageSize);
}
