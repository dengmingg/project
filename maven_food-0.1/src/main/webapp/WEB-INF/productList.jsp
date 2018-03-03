<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
        <%@include file="/WEB-INF/common/header.jsp"%>
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
                       <li><a href ="ProductCategoryList?categoryId=1">精品粤菜</a></li>                      
                       <li><a href ="ProductCategoryList?categoryId=2">麻辣川菜</a></li>
                       <li><a href ="ProductCategoryList?categoryId=3">经典湘菜</a></li>
                       <li><a href ="ProductCategoryList?categoryId=4">咸香鲁菜</a></li>
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
                   	<c:forEach items="${list }" var="food">
                    <div class="productDetail">
                        <a href="Details?id=${food.id }"><img src="images/menus/${food.englishName }.jpg" /></a><br/>
                        <span>${food.chineseName }</span>
                    </div>
                    </c:forEach>
                    <div class="clear"></div>
                </div>
                <div class="pager">
                <a href="ProductList?pageIndex=${pageIndex-1 }">上一页</a>&nbsp;&nbsp;
                <a href="ProductList?pageIndex=${pageIndex+1 }">下一页</a>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <%@include file="/WEB-INF/common/footer.jsp"%>
    </div>
</body>
</html>

