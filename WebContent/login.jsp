<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
	<link rel="stylesheet" type="text/css" href="./easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="./easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="./easyui/demo/demo.css">
	<script type="text/javascript" src="./easyui/jquery.min.js"></script>
	<script type="text/javascript" src="./easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
function onClickCheck(){
 	
	if(login.ID.value=="" || login.ID.value==null){
		window.alert("用户名不能为空"); 
    
	}
	if(login.pwd.value=="" || login.pwd.value==null){
		window.alert("密码不能为空"); 

	}
}
function setup(){
	window.location="register.jsp";
	
}
</script>
</head>
<body>
<h1>用户登录</h1>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="用户登录" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
	    	<form id="login" method="post" action = login>
	    	<table id="用户登录" >
        
	    		<tr>
	    			<td>用户名:</td>
	    			<td><input class="easyui-textbox" type="text" name="ID" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>密码:</td>
	    			<td><input class="easyui-textbox" type="password" name="pwd" data-options="required:true"></input></td>
	    		</tr>
	    		
	    	</table>
	    	<div style="text-align:center;padding:5px">
	    	
	    	<input type="submit" onclick="return onClickCheck()"value="登录" style="border:solid;border-width:1px;background-color: lightskyblue;"/>
	    	<input type="reset" onclick="" value="清除"" style="border:solid;border-width:1px;background-color: lightskyblue;"/>
	    	<input type="button" onclick="setup();" value="注册"" style="border:solid;border-width:1px;background-color: lightskyblue;"/>
	    </div>
	    </form>
	    <%
	    	if(session.getAttribute("err") != null){
	    %>
	    	<h2><%out.print(session.getAttribute("err")); %></h2>
	    <%
	    } 
	    %>
	    </div>
	</div>
	

   
</body>
</html>