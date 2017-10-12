<%@page import="com.entity.Food"%>
<%@page import="com.services.FoodService"%>
<%@page import="com.serviceImpl.FoodServiceImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="../common/common.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link href="../css/admin.css" rel="stylesheet" />
    <script src="../script/jquery-1.10.2.js"></script>
    <script src="../ckeditor/ckeditor.js"></script>
    <script>
    
    </script>
</head>
<body>
	<%
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String chineseName = request.getParameter("chineseName");
		Food food1 = foodService.getFoodByChineseName(chineseName);
		request.setAttribute("food1", food1);
	 %>
    <div id="page">
        <div id="header">
            <div id="corpTitle">美食前线后台</div>
            <div id="rightTitle">美食管理</div>
        </div>
        <div id="main">              
            <div id="nav">
                <div class="menu">
                    <ul>
                        <li>类别管理</li>
                        <li>美食管理</li>
                        <li>新闻管理</li>
                        <li>留言管理</li>
                        <li>用户管理</li>
                    </ul>
                </div>
            </div>
            <div id="container">
                <form method="get" action="foodsCategoryList.jsp">
                	美食分类：
                    <select name="categoryId">
                        <option value="1">精品粤菜</option>
                        <option value="2">麻辣川菜</option>
                        <option value="3">经典湘菜</option>
                        <option value="4">咸香鲁菜</option>
                    </select>
                                                  美食名称：
                    <input type="text" name="chineseName" value=""/>
                    <button type="submit">查询</button>
                    <a href="foodsManager.jsp">添加新美食</a>
                </form>
                <hr/>
                <table class="data-list">
                    <tr>
                        <th>美食名称</th>
                        <th>英文名称</th>
                        <th>美食类别</th>
                        <th>操作</th>
                    </tr>
                    <%
                 		List<Food> list = foodService.getFoodByCategoryId(categoryId);
                 		if(chineseName==null || chineseName=="" ){
                    		for(Food food: list){
                         		int i = 0;
                    %>
                    <tr>
                        <td><%=food.getChineseName()%></td>
                        <td><%=food.getEnglishName()%></td>
                        <td><%=foodService.getFoodCategoryById(categoryId)%></td>
                        <td>
                            <a href="foodsManager.jsp?id=<%=food.getId()%>">编辑</a>
                            <a href="foodDel.jsp?id=<%=food.getId()%>">删除</a>
                        </td>
                    </tr>
                    <%
                    			i++;
                    		}	
                    	}else{
                     %>
                     <tr>
                        <td><%=food1.getChineseName()%></td>
                        <td><%=food1.getEnglishName()%></td>
                        <td><%=foodService.getFoodCategoryById(categoryId)%></td>
                        <td>
                            <a href="foodsManager.jsp?id=<%=food1.getId()%>">编辑</a>
                            <a href="foodDel.jsp?id=<%=food1.getId()%>">删除</a>
                        </td>
                    </tr>
                    <%
                    	}
                     %>
                </table>
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
