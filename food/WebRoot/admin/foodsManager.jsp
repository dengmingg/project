<%@page import="com.entity.Food"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="foodService" class="com.serviceImpl.FoodServiceImpl" />
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
                <form method="post" action="../UploadServlet" enctype="multipart/form-data">
                    <table class="tbFoods" >
	                <%
						if(request.getParameter("id")!=null){
							int id = Integer.parseInt(request.getParameter("id"));
						    Food food = new Food();
						    food = foodService.getFoodById(id);
						    food.setId(id);
						    request.setAttribute("food",food);
						     
				 	%>
				 		<input type="hidden" name="foodId" value="<%=food.getId()%>"/>
                        <tr><td>美食名称:</td><td><input type="text" name ="chineseName" value="<%=food.getChineseName()%>"/><span class="tip">&nbsp;(中文名称不能为空)</span></td><td></td></tr>
                        <tr><td>英文名称:</td><td><input type="text" name ="englishName" value="<%=food.getEnglishName()%>"/><span class="tip">&nbsp;(英文名称不能为空)</span></td><td></td></tr>
                        <tr><td>美食图片:</td><td><input type="file" name ="photos"/><span></span></td><td></td></tr>
                        <tr><td>美食类别:</td><td>
                        <select name="categoryId" >
	                        <option value="1">精品粤菜</option>
	                        <option value="2">麻辣川菜</option>
	                        <option value="3">经典湘菜</option>
	                        <option value="4">咸香鲁菜</option>
                        </select></td><td></td></tr>
                        <tr><td>制作流程:</td><td class="foodsDesc"><textarea  name="description" class="ckeditor"><%=food.getDescription()%></textarea></td><td><span class="tip">*</span></td></tr>
                        <tr><td></td><td><input type="submit" value="保存"/><input type="reset" value="取消" onclick="javascript:location.href='foodsList.jsp'"/></td><td></td></tr>
                    	<%}else{%>
                    	 <tr><td>美食名称:</td><td><input type="text" name ="chineseName" value=""/><span class="tip">&nbsp;(中文名称不能为空)</span></td><td></td></tr>
                        <tr><td>英文名称:</td><td><input type="text" name ="englishName" value=""/><span class="tip">&nbsp;(英文名称不能为空)</span></td><td></td></tr>
                        <tr><td>美食图片:</td><td><input type="file" name ="photos"/><span></span></td><td></td></tr>
                        <tr><td>美食类别:</td><td>
                        <select name="categoryId">
	                        <option value="1">精品粤菜</option>
	                        <option value="2">麻辣川菜</option>
	                        <option value="3">经典湘菜</option>
	                        <option value="4">咸香鲁菜</option>
                        </select></td><td></td></tr>
                        <tr><td>制作流程:</td><td class="foodsDesc"><textarea  name="description" class="ckeditor"></textarea></td><td><span class="tip">*</span></td></tr>
                        <tr><td></td><td><input type="submit" value="保存"/><input type="reset" value="取消" onclick="javascript:location.href='foodsList.jsp'"/></td><td></td></tr>
                    	<%} %>
                    </table>
                </form>
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

