<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.min.js">
</script>
<style type="text/css">
body {
	text-align: center;
}

table {
	margin: 0 auto;
	width: 1047px;
	margin-bottom: 30px;
}

.tittle {
	position:relative;
	height: 50px;
	width: 1047px;
	color: #1A1A1A;
	margin: 0 auto;
	margin-bottom: 30px;
	text-align: center;
	font-size: 30px;
	border-top:3px solid #1A1A1A;
	background-color: #DCDCDC;
}

thead {
	color: #1A1A1A;
	background-color: #DCDCDC;
}

.button{
	color:#FFFFFF;
	height:35px;
	width:150px;
	font-size:19px;
	font-weight:bold;
	margin-top:7px;
	background: #1A1A1A;
}

.button:hover{
	cursor:pointer;
}

a{
		color:red;
		text-decoration: none;
	}
	
a:hover{
	color:#037E3D;
	text-decoration: underline;
}
.goBack{
	position:absolute;
	top:30px; 
	left:88%;
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
		当前选定车型可匹配产品
		<a href="AdminCarBrandAction_listCarBrand">
		<img src="images/goBackGreen.png">
	</a>
	<a class="goBack" href="AdminProductAction_selectKindForCar?carTypeNum=${carTypeNum }&carBrandId=${carBrandId}">返回商品品牌列表</a>
	</div>
	<table border="1px" style="border: 1px;">
		<thead>
			<tr>
				<th>种类</th>
				<th>品牌</th>
				<th>型号</th>
				<th>价格</th>
				<th>库存</th>
				<th>移除匹配</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="appProducts">
				<tr>
					<td>${kind}</td>
					<td>${name}
					<td>${typeNum}</td>
					<td>${price}</td>
					<td>${store}</td>
					<td><a
						href="AdminProductAction_removeProductInCarType?id=${id }&removeCarType=${carTypeNum}&productKind=${productKind }&productName=${productName}">
							移除 </a>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<div class="tittle">
		当前选定车型未匹配产品
	</div>
	<form action="AdminProductAction_carSelectProduct" method="get">
		<table border="1px" style="border: 1px;">
			<thead>
				<tr>
					<th>种类</th>
					<th>品牌</th>
					<th>型号</th>
					<th>价格</th>
					<th>库存</th>
					<th>添加匹配</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="noAppProducts">
					<tr>
						<td>${kind}</td>
						<td>${name}
						<td>${typeNum}</td>
						<td>${price}</td>
						<td>${store}</td>
						<td>勾选添加<input type="checkbox"
							name="carAppProductIds" value="${id}" />
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<div class="tittle">
		<input type="hidden" name="carTypeNum" value="${carTypeNum }" />
		<input type="hidden" name="productKind" value="${productKind }" />
		<input type="hidden" name="productName" value="${productName }" />
			<input class="button" type="submit" value="提　交" />
		</div>
	</form>
	
	<script type="text/javascript">
		$("tbody>tr:even").css("background-color","#DCDCDC");
	</script>
</body>
</html>