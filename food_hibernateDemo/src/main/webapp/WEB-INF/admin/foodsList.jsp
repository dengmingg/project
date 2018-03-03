<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link href="css/admin.css" rel="stylesheet" />
    <script src="script/jquery-1.10.2.js"></script>
    <script src="ckeditor/ckeditor.js"></script>
    <script>
	var flag = '${param.flag}';
	if(flag!=null && flag!=''&& undefined!=flag){
		if(flag=='success'){
			alert('删除成功！');
		}else{
			alert('删除失败');
		}
	}
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
                <form method="get" action="FoodsCategoryList">
                    美食分类：
                    <select name="categoryId">
                        <option value="1">精品粤菜</option>
                        <option value="2">麻辣川菜</option>
                        <option value="3">经典湘菜</option>
                        <option value="4">咸香鲁菜</option>
                    </select>
                    美食名称：
                    <input type="text" name="chineseName" value="" />
                    <button type="submit">查询</button>
                    <a href="FoodsManager">添加新美食</a>
                </form>
                <hr/>
                <table class="data-list">
                    <tr>
                        <th>美食名称</th>
                        <th>英文名称</th>
                        <th>美食类别</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${list }" var="food">
                     
                    <tr>
                        <td>${food.chineseName }</td>
                        <td>${food.englishName }</td>
                        <td>${food.category.name}</td>
                        <td>
                            <a href="FoodsManager?id=${food.id }">编辑</a>
                            <a href="FoodDel?id=${food.id }">删除</a>
                        </td>
                    </tr>
                     
                    </c:forEach>
                </table>
            </div>
            <div class="clear"></div>
        </div>
            <%@include file="/WEB-INF/common/footer.jsp"%>
    </div>

</body>
</html>
