<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出售商品</title>
	<link rel="stylesheet" type="text/css" href="./easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="./easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="./easyui/demo/demo.css">
	<script type="text/javascript" src="./easyui/jquery.min.js"></script>
	<script type="text/javascript" src="./easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" >
	    	function onClickCheck(){
	 	
			if(setup.gname.value=="" || setup.gname.value==null){
				window.alert("商品名不能为空"); 
		        return false; 
			}
			if(setup.gprise.value=="" || setup.gprise.value==null){
				window.alert("售价不能为空"); 
		        return false; 
			}
			if(setup.gnum.value=="" || setup.num.value==null){
				window.alert("可出售数量不能为空"); 
		        return false; 
			}
			
			
	}
	function back(){
		window.location="n_user.jsp";
	}
	</script>
</head>
<body>
<h2>你好！<%= session.getAttribute("uname")%>同学</h2>
<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="商品出售" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
	    	<form id="setup" method="post" action = goods_add >
	    	<table id="商品出售" >
        
	    		<tr>
	    			<td>商品名称:</td>
	    			<td><input class="easyui-textbox" type="text" name="gname" data-options="required:true" "></input></td>
	    		</tr>
	    		<tr>
	    			<td>单价:</td>
	    			<td><input class="easyui-textbox" type="text" name="gprise" data-options="required:true"></input></td>
	    		</tr>
	    		
	    		
	    	</table>
	    	<div style="text-align:center;padding:5px">
	    	
	    	<input type="submit" onclick="return onClickCheck();"value="提交商品信息" style="border:solid;border-width:1px;background-color: lightskyblue;"/>
	    	<input type="reset" onclick="" value="清除"" style="border:solid;border-width:1px;background-color: lightskyblue;"/>
	    	<input type="button" onclick="back();"value="返回主页"" style="border:solid;border-width:1px;background-color: lightskyblue;"/>
	    </div>
	    </form>
	    
	    
	    </div>
	</div>
</body>
</html>