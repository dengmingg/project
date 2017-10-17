package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.News;
import com.serviceImpl.NewsServiceImpl;
import com.services.NewsService;

public class NewsDetailsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NewsService newsService = new NewsServiceImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		News news = newsService.getNewsById(id);
		int totalCount = newsService.getTotalCount();
		if(id<=1){
			id= 2;
        }else if(id>=totalCount){
        	id = totalCount-1;
        }
		request.setAttribute("news", news);
		request.setAttribute("id", id);
		request.getRequestDispatcher("/WEB-INF/newsDetails.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
