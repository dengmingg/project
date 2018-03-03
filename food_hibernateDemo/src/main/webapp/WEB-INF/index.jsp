<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link href="css/base.css" rel="stylesheet" />
</head>
<body>
    <div id="page">
    	<%@include file="/WEB-INF/common/header.jsp"%>
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
                   		
                   	   <c:forEach items="${list}" var="food" varStatus="status">
                   	   <c:if  test="${status.count<4 }">
                       <div class="product">
                           <a href="Details?id=${food.id }"><img src="images/menus/${food.englishName }.jpg" /></a><br />
                           <span>${food.chineseName }</span>
                       </div>
                       </c:if>
                       </c:forEach>
                       
                       <div class="clear"></div>
                   </div>
                   <div class="topNewsList">
                       <span>公司新闻</span>
                       <hr />
                       
                       <c:forEach items="${list1}" var="news" varStatus="status">
                       <div class="news" >
                           <div class="newsTitle"><a href="NewsDetails?id=${news.id }">${news.title }</a></div>
                           <div class="newsDate">${news.publishDate}</div>
                           <div class="clear"></div>
                           <hr/>
                       </div>
                       </c:forEach>
                   </div>
                   
               </div>
               <div class="clear"></div>
        </div>
        <%@include file="/WEB-INF/common/footer.jsp"%>
    </div>
</body>
</html>

