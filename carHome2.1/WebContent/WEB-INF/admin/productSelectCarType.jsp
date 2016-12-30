<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<style type="text/css">
	body{
		text-align: center;
	}
	
	table{
		width: 1047px;
		margin: 0 auto;
		margin-bottom: 30px;
	}
	
	thead{
		color:#1A1A1A;
		background-color: #DCDCDC;
	}
	
	a{
		color:red;
		text-decoration: none;
	}
	
	a:hover{
		color:#037E3D;
		text-decoration: underline;
	}
	
	.tittle{
		position:relative;
		height: 50px;
		width: 1047px;
		color:#1A1A1A;
		margin:0 auto;
		margin-bottom:30px;
		text-align:center;
		font-size:30px;
		border-top:3px solid #1A1A1A;
		background-color: #DCDCDC;
	}
	
	.button{
		margin-top:7px;
		width: 150px;
		height:35px;
		color:#FFFFFF;
		font-size:15px;
		font-weight:bold;
		background-color: #1A1A1A;
	}
	
	.button:hover{
		cursor:pointer;
	}
	.goBack{
		position:absolute;
		top:30px; 
		left:83%;
		font-size:15px;
		color:#1A1A1A;
		text-decoration:none;
	}

	.goBack:hover{
		text-decoration: underline;
	}
	.tittle img{
		position: absolute;
		left: 90%;
		width: 50px;
		height: 50px;
	}
</style>
</head>
<body>
	<div class="tittle">
		${model.name }${model.typeNum }产品可应用的车型有
		<a href="AdminProductAction_listProductByKind?productKind=${productKind }&productName=${productName}">
			<img src="images/goBackGreen.png">
		</a>
		<a class="goBack" href="AdminProductAction_listProductByKind?productKind=${productKind }&productName=${productName}">返回${productKind }产品列表</a>
	</div>
	<table border="1px" style="margin-bottom: 20px;">
		<thead>
			<tr>
				<th>图标</th>
				<th>品牌</th>
				<th>系列</th>
				<th>排量</th>
				<th>截止时间</th>
				<th>移除匹配</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="appCarTypes">
				<tr>
					<td>暂无</td>
					<td>${brand.name }</td>
					<td>${name }</td>
					<td>${airOut }</td>
					<td>${carPicUrl }</td>
					<td><a
						href="AdminProductAction_removeCarTypeInProduct?removeCarType=${brand.id }_${id}&id=${model.id}">移除</a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<div class="tittle">
		给当前产品添加车型
	</div>

	<form action="AdminProductAction_productSelectCar?id=${model.id }"
		method="post">
		<table border="1px">
			<thead>
				<tr>
					<th>选定</th>
					<th>图标</th>
					<th>品牌</th>
					<th>系列</th>
					<th>排量</th>
					<th style="width:200px;">截止时间（月/年）</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="noAppCarTypes">
					<tr>
						<td><input type="checkbox" name="selectApplyCars"
							value="${brand.id }_${id}"></td>
						<td>暂无</td>
						<td>${brand.name }</td>
						<td>${name }</td>
						<td>${airOut }</td>
						<td>${carPicUrl }</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<div class="tittle">
			<input class="button" type="submit" value="提　交" />
		</div>
	</form>
	
	<script type="text/javascript">
		$("tbody>tr:odd").css("background","#FADB0E");
	</script>
</body>
</html>