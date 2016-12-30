<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
tr{
	height: 30px;
}
.tittle{
	position:relative;
	margin:0 auto; 
	height: 50px;
	width: 1047px;
	color:#000000;
	font-size: 33px;
	margin-bottom: 30px;
	border-top:3px solid #1A1A1A;
	background-color: #DCDCDC;
}

.tittle img{
	position: absolute;
	left: 90%;
	width: 50px;
	height: 50px;
}

.table1{
	margin:0 auto;  
	width: 1047px;
	text-align: center; 
	margin-bottom: 20px;
}

.table1 tr th{
	background-color: #1A1A1A;
	color:#FFFFFF;
}

.tfooter{
	background-color: #1A1A1A;
	color:#FFFFFF;
}

.tfooter a{
	color:#FFFFFF;
	font-size: 20px;
	font-weight: bold;
	text-decoration: none;
}
.tfooter a:hover{
	text-decoration: underline;
}

.goBack{
	position:absolute;
	top:30px; 
	left:93%;
	font-size:15px;
	color:#037E3D;
	text-decoration:none;
}

.goBack:hover{
	text-decoration: underline;
}

a{
	color:#1A1A1A;
	text-decoration: none;
}

a:hover{
	text-decoration: underline;
}
</style>
</head>
<body style="text-align: center;">
	<div class="tittle">
		车品牌一览表
	</div>
	<table class="table1" align="center" width="980px;" title="车品牌一览表" border="1px" style="border:1px;">
		<tr><th>图标</th><th>名称</th><th>操作</th><th>查看车系型号</th></tr>
		<s:iterator value="carBrands">
		<tr>
			<td><img src="../../images/img_cart.png"></td>
			<td>${name }</td>
			<td>
			<a href="AdminCarBrandAction_queryCarBrand?id=${id }">修改</a>
			<a href="AdminCarBrandAction_delCarBrand?id=${id }">删除</a>
			</td>
			<td>
			<a href="AdminCarTypeAction_listCarTyeByBrand?carBrandId=${id }">
			查看该品牌车系型号
			</a>
			</td>
		</tr>
		</s:iterator>
		<tr>
			<td class="tfooter" colspan="4">
				<a href="AdminCarBrandAction_addCarBrand">添加品牌</a>
			    <a href="#">添加品牌</a>	
			</td>	
		</tr>
	</table>
</body>
</html>