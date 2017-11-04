package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Food;
import com.services.FoodService;
import com.services.Impl.FoodServiceImpl;
import com.util.PageSupport;
@WebServlet(urlPatterns={"/ProductList"} ,name="ProductListServlet")
public class ProductListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String currentPage = request.getParameter("pageIndex");
		FoodService foodService = new FoodServiceImpl();
     	if(currentPage == null){
     		//�û��״η���ҳ��
     		currentPage = "1";
     	}
     	//��ǰҳ��
     	int pageIndex = Integer.parseInt(currentPage);

     	//��ȡʳ��������
     	int totalCount = foodService.getTotalCount();
     	//ÿҳ��ʾ����ʳ��
     	int pageSize = 8;
     	PageSupport pageSupport = new PageSupport();
     	pageSupport.setCurrentPageNo(pageIndex);
     	pageSupport.setPageSize(pageSize);
     	pageSupport.setTotalCount(totalCount);
     	
     	//��ҳ��
     	int totalPage = pageSupport.getTotalPageCount();
     	
     	if(pageIndex<=0){
     		pageIndex=1;
     	}else if(pageIndex>totalPage){
     		pageIndex = totalPage;
     	}
     		
        List<Food> list = foodService.getPageFoodList(pageIndex, pageSize);
        request.setAttribute("list", list);
        request.setAttribute("pageIndex", pageIndex);
		
		request.getRequestDispatcher("/WEB-INF/productList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
