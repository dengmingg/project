<%@page import="com.services.FoodService"%>
<%@page import="com.entity.Food"%>
<%@page import="com.entity.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<jsp:useBean id="newsService" class="com.serviceImpl.NewsServiceImpl"/>
<jsp:useBean id="foodService" class="com.serviceImpl.FoodServiceImpl" />
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link href="css/base.css" rel="stylesheet" />
</head>
<body>
    <div id="page">
        <div id="header">
            <div id="menu">
                <div id="corpTitle">美食前线</div>
                <div id="fastNav">
                    <ul>
                        <li><a href="index.jsp">首页</a></li>
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
                   <p>联系我们</p>
                   <hr/>
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
                 
                   <div class="titleText">
                       <span>公司简介</span>
                       <hr />
                       <div class="richContent richContent0"><p style="font-family:宋体, 新宋体;line-height:21px;"><span style="line-height:1.8;font-family:宋体;"> &nbsp;公司有10多年机关食堂承包、学校食堂承包、工厂食堂承包、快餐配送、酒店承包经营管理经验的餐饮服务专家，至今已发展成为一家集食堂承包经营管理、粮食蔬菜副食批发配送、食堂餐饮从业人员培训等为一体的中型餐饮服务企业。</span><span style="line-height:1.8;font-family:宋体;">现在是广东珠三角地区最具实力和影响力的承包企业食堂与学校食堂的餐饮服务公司。</span><br></p><p><span style="line-height:1.8;"></span></p></div>
                   </div>
               </div>
               <div id="container">
                   <!--内容-->
                   <p class="mainTitle">美食菜单</p>
                   <hr/>
                   <div class="productList">
                   		<%
                   			List<Food> list = foodService.getFoodList();
                   			int i=0;
                   			for(Food food : list){
                   				if(i<3){
                   		 %>
                       <div class="product">
                           <a href="details.jsp?id=<%=food.getId()%>"><img src="images/menus/<%=food.getEnglishName()%>.jpg" /></a><br />
                           <span><%=food.getChineseName() %></span>
                       </div>
                       <%
                       			}
                       		i++;
                       		}
                        %>
                       <div class="clear"></div>
                   </div>
                   
                   
                   <div class="topNewsList">
                       <span>公司新闻</span>
                       <hr />
                       <%
                       
                       	List<News> list1 = newsService.getNewsList();
                       	int j=0;
                       	for(News news: list1){
                       		j++;
                       	
                       %>
                       <div class="news" >
                           <div class="newsTitle"><a href="newsDetails.jsp?id=<%=news.getId()%>"><%=news.getTitle() %></a></div>
                           <div class="newsDate"><%=news.getPublishDate() %></div>
                           <div class="clear"></div>
                           <hr/>
                       </div>                      
                       <%} %>            
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

