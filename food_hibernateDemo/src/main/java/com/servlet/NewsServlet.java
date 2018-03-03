package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.NewsDao;
import com.dao.impl.NewsDaoImpl;
import com.entity.News;
import com.util.PageSupport;
@WebServlet(urlPatterns={"/News"} ,name="NewsServlet")
public class NewsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NewsDao newsService = new NewsDaoImpl();
		String  currentPage = request.getParameter("pageIndex");
		if(currentPage==null){
    		currentPage = "1";
    	}
      	int pageIndex = Integer.parseInt(currentPage);
      	
      	int pageSize = 3;
      	int totalCount = newsService.getTotalCount();
    	
    	PageSupport pageSupport = new PageSupport();
       	pageSupport.setCurrentPageNo(pageIndex);
     	pageSupport.setPageSize(pageSize);
     	pageSupport.setTotalCount(totalCount);
  
    	
    	int totalPage = pageSupport.getTotalPageCount();
    		
    	if(pageIndex<=0){
     		pageIndex=1;
     	}else if(pageIndex>totalPage){
     		pageIndex = totalPage;
     	}
   		
   		List<News> list = newsService.getPageNewsList(pageIndex, pageSize);
   		request.setAttribute("list", list);
   		request.setAttribute("pageIndex", pageIndex);
		
		request.getRequestDispatcher("/WEB-INF/news.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
