<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
  	<form action="LoginServlet" method ="post">
  	用户名&nbsp;<input type="text"  name="userName"  value="<%=request.getParameter("userName")==null?"": request.getParameter("userName")%>" /><br/>
  	密&nbsp;码&nbsp;&nbsp;<input type="text" name="password" value="<%=request.getParameter("password")==null?"": request.getParameter("password") %>"/><br/><br/>
  	<input type="submit" value="登录"/>
  	</form>
  </body>
</html>
