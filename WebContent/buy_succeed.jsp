<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购买成功</title>
</head>
<body>
<% 
	response.setHeader("refresh","2,login.jsp");
%>
您已成功购买一件商品！！两秒后跳转到主页面！！
	<a href ="print_goods">若没有跳转请单击这里</a>！！
</body>
</html>