<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
	<link rel="stylesheet" type="text/css" href="./easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="./easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="./easyui/demo/demo.css">
	<script type="text/javascript" src="./easyui/jquery.min.js"></script>
	<script type="text/javascript" src="./easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" >
	    	function onClickCheck(){
	 	
			if(setup.ID.value=="" || setup.ID.value==null){
				window.alert("用户名不能为空"); 
		        return false; 
			}
			if(setup.pwd1.value=="" || setup.pwd1.value==null){
				window.alert("密码不能为空"); 
		        return false; 
			}
			if(setup.pwd2.value=="" || setup.pwd2.value==null){
				window.alert("请确认密码"); 
		        return false; 
			}
			if(setup.name.value=="" || setup.name.value==null){
				window.alert("姓名不能为空"); 
		        return false; 
			}
			if(setup.pwd1.value!=setup.pwd2.value){
				window.alert("两次密码输入不一致"); 
		        return false; 
			}
			
	}
	function back(){
		window.location="login.jsp";
	}
	</script>
</head>
<body>
<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="setup" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
	    	<form id="setup" method="get" action = register >
	    	<table id="用户注册" >
        
	    		<tr>
	    			<td>用户名:</td>
	    			<td><input class="easyui-textbox" type="text" name="ID" data-options="required:true" onclick="calculater()"></input></td>
	    		</tr>
	    		<tr>
	    			<td>密码:</td>
	    			<td><input class="easyui-textbox" type="password" name="pwd1" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>再次输入密码：</td>
	    			<td><input class="easyui-textbox" type="password" name="pwd2" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>姓名：</td>
	    			<td><input class="easyui-textbox" type="text" name="name" data-options="required:true"></input></td>
	    		</tr>
	    	</table>
	    	<div style="text-align:center;padding:5px">
	    	
	    	<input type="submit" onclick="return onClickCheck();"value="注册"" style="border:solid;border-width:1px;background-color: lightskyblue;"/>
	    	<input type="reset" onclick="" value="清除"" style="border:solid;border-width:1px;background-color: lightskyblue;"/>
	    	<input type="button" onclick="back();"value="返回登录界面"" style="border:solid;border-width:1px;background-color: lightskyblue;"/>
	    </div>
	    </form>
	    <%
	    	if(session.getAttribute("repeated") =="1"){
	    		out.print("已存在该用户");
	    		}
	    %>
	    
	    </div>
	</div>
</body>
</html>