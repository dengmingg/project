<%@page import="com.services.FoodService"%>
<%@page import="com.entity.Food"%>
<%@include file="../common/common.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <%
    int id = Integer.parseInt(request.getParameter("id"));
    Food food = new Food();
    
    food.setId(id);
    request.setAttribute("food",food);
    String flag = "failed";
    if(foodService.delete(food)){
    	flag = "success";
    }
    response.sendRedirect("foodsList.jsp?flag="+flag);

  %>
  </body>
</html>
