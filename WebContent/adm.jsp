<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="UTF-8">
<title>二手交易市场</title>
<link rel="stylesheet" type="text/css" href="./easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="./easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="./easyui/demo/demo.css">
	<script type="text/javascript" src="./easyui/jquery.min.js"></script>
	<script type="text/javascript" src="./easyui/jquery.easyui.min.js"></script>

<script type="text/javascript">
function logout(){
	window.location="logout.jsp";
}
	


</script>
</head>
<body>
	<%if(session.getAttribute("uname") != null){
%>

<h2>你好！管理员<%= session.getAttribute("uname")%></h2>
<div class="easyui-panel" title="管理员操作" style="width:450px">
		<div style="padding:10px 60px 20px 60px">
	    	<form id="adm" method="post" action = adm_goods>
	    	<div style="text-align:center;padding:5px">
	    	
	    	<input type="submit" value="打印待上架商品" style="border:solid;border-width:1px;background-color: lightskyblue;"/>
	    	<input type="submit"  formmethod="post" formaction="finish_goods"value="查询已出售商品" style="border:solid;border-width:1px;background-color: lightskyblue;"/>
	    	<input type="button" onclick="logout();" value="登出"" style="border:solid;border-width:1px;background-color: lightskyblue;"/>
	    </div>
	    </form>
</div>
</div>




<% 
		Integer maxg=Integer.valueOf(session.getAttribute("maxg").toString());
		String [][]goods = new String[maxg][5];
		goods = (String[][]) session.getAttribute("goods");
		String []unames = new String[maxg];
		unames = (String[]) session.getAttribute("unames");
		int flag = Integer.valueOf(session.getAttribute("flag").toString());
		
			for(int i=0;i<maxg;i++){
		if(flag == 0)	{	
%>

<div class="easyui-panel" title="待确认上架商品" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
<form id="list" method="post" action =confirm>
<table>

<tr>
	<td>商品名称:<%=goods[i][1] %></td>
</tr>
<tr>
	<td>单价:<%=goods[i][2]%></td>
</tr>
<tr>
	<td>出售者:<%=unames[i]%></td>
</tr>	
<tr>	
	<td>
	<input type=hidden name =goodsid value = <%=goods[i][0] %>>
	<input type="submit"  value="确认申请" style="border:solid;border-width:1px;background-color: lightskyblue;"/>
	</td>
</tr>	



</table>
</form>
</div>
</div>
<%
		}else if(flag == 2){
%>
<div class="easyui-panel" title="已售商品" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
<form id="finish" method="post" >
<table>

<tr>
	<td>商品名称:<%=goods[i][1] %></td>
</tr>
<tr>
	<td>单价:<%=goods[i][2]%></td>
</tr>
<tr>
	<td>出售者:<%=unames[i]%></td>
</tr>	
<tr>	
<tr>
	<td>购买者:<%=unames[i]%></td>
</tr>	




</table>
</form>
</div>
</div>
<%
		}
			
}
	}
else{
	response.setHeader("refresh","2,login.jsp");
%>
	您还未登录！！
	两秒后跳转到登录窗口！！
	<a href ="login.jsp">若没有跳转请单击这里</a>！！
<% 
}
%>
</body>
</html>