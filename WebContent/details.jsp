<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品详情</title>
<link rel="stylesheet" type="text/css" href="./easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="./easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="./easyui/demo/demo.css">
	<script type="text/javascript" src="./easyui/jquery.min.js"></script>
	<script type="text/javascript" src="./easyui/jquery.easyui.min.js"></script>

<script type="text/javascript">
function main(){
	window.location="n_user.jsp";
	


	
}

</script>
</head>
<body>
<% 
	String gid = (String)session.getAttribute("gid");
	int gprise = (Integer)session.getAttribute("gprise");
	String uid = (String)session.getAttribute("uid");
	String gname = (String)session.getAttribute("gname");
	String gowner = (String)session.getAttribute("gowner");		
%>
<div class="easyui-panel" title="待售商品" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
<form id="buy" method="post" action =buy_servlet>
<table>
<tr>
	<td>浏览商品</td>
</tr>
<tr>
	<td>商品名称:<%=gname %></td>
</tr>
<tr>
	<td>单价:<%=gprise%></td>
</tr>
<tr>
	<td>出售者:<%=gowner%></td>
</tr>	

</table>
<div style="text-align:center;padding:5px">
<input type=hidden name =goodsid value = <%=gid %>>
<input type=hidden name =userid value = <%=uid %>>
<input type="button" onclick="main();" value="返回主页" style="border:solid;border-width:1px;background-color: lightskyblue;"/>
<input type="submit"  value="购买" style="border:solid;border-width:1px;background-color: lightskyblue;"/>
</div>
</form>
</div>
</div>
<div class="easyui-panel" title="商品评论" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
<form id="detail" method="post" action =add_comment>
<table>

<%
	int maxc=Integer.valueOf(session.getAttribute("maxc").toString());
	String [][]comment = new String[maxc][2];
	comment = (String[][]) session.getAttribute("comments");
	String []owners = new String[maxc];
	owners = (String[]) session.getAttribute("owners");

	for(int i=0;i<maxc;i++){
%>
<tr>
	<p><%=owners[i]%>的评论:<%=comment[i][0]%></p>
</tr>
<%
	}
%>
<tr>
		<td>添加评论</td>
		<td><input class="easyui-textbox" type="text" name="comment" data-options="required:true" ></input></td>
		<td><input type="submit"value="评论" style="border:solid;border-width:1px;background-color: lightskyblue;"/></td>
</tr>
</table>
		<input type=hidden name =goodsid value = <%=gid %>>
		<input type=hidden name =userid value = <%=uid %>>
</form>
</div>
</div>

</body>
</html>