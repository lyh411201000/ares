<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'adminlogin.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@include file="../../comm/comm.jsp" %>
  </head>
  
  <body>
  ${error }
   <form action="${basePath }/framework/user/login.do">
   Username: <input type="text" name="username"/> <br/>
   Password: <input type="password" name="password"/>
   <input type="checkbox" name="rememberMe" value="true"/>Remember Me?
   <input type="submit" value="submit">
</form>
  </body>
</html>
