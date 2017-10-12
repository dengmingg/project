<%@page import="com.util.PageSupport"%>
<%@page import="com.services.FoodService"%>
<%@page import="com.serviceImpl.FoodServiceImpl"%>
<%@page import="com.entity.Food"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="foodService" class="com.serviceImpl.FoodServiceImpl" />
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link href="css/base.css" rel="stylesheet" />
    <script src="script/jquery-1.11.3.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$("#input1").bind("keyup",function(){
    		 var a=$(this).val();
				$("#a").html(a);
    		});
    		$("#delete").bind("click",function(){
    			$("#input1").val("");
    		});
    	});
  </script>
</head>
<body>
    <div id="page">
        <div id="header">
            <div id="menu">
                <div id="corpTitle">美食前线</div>
                <div id="fastNav">
                    <ul>
                        <li>首页</li>
                        <li><a href="productList.jsp">产品展示</a></li>
                        <li><a href="news.jsp">新闻动态</a></li>
                        <li><a href="message.jsp">留言板</a></li>
                        <li>联系我们</li>
                    </ul>
                </div>
                <div class="clear"></div>
            </div>
            <div id="logo"></div>
            <div class="clear"></div>
        </div>
        <div id="main">
            <div id="nav">
                <div class="search">
                    产品搜索
                </div>
                <div class="searchTitle">
                    <table>
                        <tr>
                            <td><input type="text" id="input1"class="title" value=""/></td><td><img src="images/go.gif" /></td>
                        </tr>
                    </table>
                </div>
                <div class="category">
                   <ul>
                       <li><a href ="productCategoryList.jsp?categoryId=1">精品粤菜</a></li>                      
                       <li><a href ="productCategoryList.jsp?categoryId=2">麻辣川菜</a></li>
                       <li><a href ="productCategoryList.jsp?categoryId=3">经典湘菜</a></li>
                       <li><a href ="productCategoryList.jsp?categoryId=4">咸香鲁菜</a></li>
                   </ul>                
                </div>
                <div class="onlineService">在线客服</div>
                <hr />
                <a><span class="searchOnline">&nbsp;</span>在线客服一</a>
                <a><span class="searchOnline">&nbsp;</span>在线客服二</a>
                <hr/>
                <div class="worktime">
                    <span class="worker-header-img">&nbsp;</span>
                    <span><b>工作时间</b></span>
                </div>
                <div class="serOnline-list-h "><span>周一至周五 ：8:30-17:30</span></div>
                <div class="serOnline-list-h lastData"><span>周六至周日 ：9:00-17:00</span></div>
                <hr/>
                <div class="serOnline-contact"><div class="marBL-10"><span class="contact-header-img">&nbsp;</span><span style="font-size:15px;"><b>联系方式</b></span></div><div class="serOnline-list-h"><span>陈经理：13000000000</span></div></div>
                <div class="clear"></div>
            </div>
            <div id="container">
                <!--内容-->
               <div class="productTitle">
                   <span class="list">产品列表</span>
                   <hr class="solid"/>
                   	当前条件:<span id="a"></span><a href="" id="delete">[删除]</a>
                   <hr/>
               </div>
                <div class="productList">
                 <%
				String currentPage = request.getParameter("pageIndex");
                 	if(currentPage == null){
                 		//用户首次访问页面
                 		currentPage = "1";
                 	}
                 	//当前页面
                 	int pageIndex = Integer.parseInt(currentPage);
            
                 	//获取食物总数量
                 	int totalCount = foodService.getTotalCount();
                 	//每页显示几个食物
                 	int pageSize = 8;
                 	PageSupport pageSupport = new PageSupport();
                 	pageSupport.setCurrentPageNo(pageIndex);
                 	pageSupport.setPageSize(pageSize);
                 	pageSupport.setTotalCount(totalCount);
                 	
                 	//总页数
                 	int totalPage = pageSupport.getTotalPageCount();
                 	
                 	if(pageIndex<=0){
                 		pageIndex=1;
                 	}else if(pageIndex>totalPage){
                 		pageIndex = totalPage;
                 	}
               			
                 		
                       	List<Food> list = foodService.getPageFoodList(pageIndex, pageSize);
                       	   	                         	                      
                       	for(Food food: list){
                       	int i = 0;
                       		 
                   	%> 
                    <div class="productDetail">
                        <a href="details.jsp?id=<%=food.getId()%>"><img src="images/menus/<%=food.getEnglishName() %>.jpg" /></a><br/>
                        <span><%=food.getChineseName()%></span>
                    </div>
                    <% 
                    i++;}  
                    %>  
                    <div class="clear"></div>
                </div>
                <div class="pager">
                <a href="productList.jsp?pageIndex=<%=pageIndex-1%>">上一页</a>&nbsp;&nbsp;
                <a href="productList.jsp?pageIndex=<%=pageIndex+1%>">下一页</a>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <div id="footer">
            <p><a>首页|</a><a>关于我们|</a><a>联系我们</a></p>
            <p>@©2016 网站样板-餐饮 版权所有</p>
            <p>技术支持：广州广力 | 手机版 | 管理登录</p>
        </div>
    </div>
</body>
</html>

