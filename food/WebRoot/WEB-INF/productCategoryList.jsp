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
    <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
    	
</head>
<body>
    <div id="page">
        <div id="header">
            <div id="menu">
                <div id="corpTitle">美食前线</div>
                <div id="fastNav">
                    <ul>
                        <li>首页</li>
                        <li><a href="ProductListServlet">产品展示</a></li>
                        <li><a href="NewsServlet">新闻动态</a></li>
                        <li><a href="MessageServlet">留言板</a></li>
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
                            <td><input type="text" class="title" /></td><td><img src="images/go.gif" /></td>
                        </tr>
                    </table>
                </div>
                <div class="category">
                   <ul>
                       <li><a href ="ProductCategoryListServlet?categoryId=1">精品粤菜</a></li>                      
                       <li><a href ="ProductCategoryListServlet?categoryId=2">麻辣川菜</a></li>
                       <li><a href ="ProductCategoryListServlet?categoryId=3">经典湘菜</a></li>
                       <li><a href ="ProductCategoryListServlet?categoryId=4">咸香鲁菜</a></li>
                   </ul>                
                </div>
                <div class="onlineService">在线客服</div>
                <hr />
                <a><span class="searchOnline">&nbsp;</span>在线客服一</a>
                <a><span class="searchOnline">&nbsp;</span>在线客服二</a>
                <hr />
                <div class="worktime">
                    <span class="worker-header-img">&nbsp;</span>
                    <span><b>工作时间</b></span>
                </div>
                <div class="serOnline-list-h "><span>周一至周五 ：8:30-17:30</span></div>
                <div class="serOnline-list-h lastData"><span>周六至周日 ：9:00-17:00</span></div>
                <hr />
                <div class="serOnline-contact"><div class="marBL-10"><span class="contact-header-img">&nbsp;</span><span style="font-size:15px;"><b>联系方式</b></span></div><div class="serOnline-list-h"><span>陈经理：13000000000</span></div></div>
                <div class="clear"></div>
            </div>
            <div id="container">
                <!--内容-->
               <div class="productTitle">
                   <span class="list">产品列表</span>
                   <hr class="solid"/>
                   <span >当前条件:水煮牛肉<a>[删除]</a></span>
                   <hr/>
               </div>
               <div class="productList">
               		<c:forEach items="${list }" var="food">
                    <div class="productDetail">
                        <a href="DetailsServlet?id=${food.id }"><img src="images/menus/${food.englishName }.jpg" /></a><br/>
                        <span>${food.chineseName }</span>
                    </div>
                    </c:forEach>
                    <div class="clear"></div>
               </div>
               
               <div class="pager">
               <a href="">上一页</a>&nbsp;&nbsp;
               <a href="">下一页</a>
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


