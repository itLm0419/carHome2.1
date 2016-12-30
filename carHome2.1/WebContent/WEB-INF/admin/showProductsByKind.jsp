<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<style type="text/css">
	body{
		text-align: center;
	}

	table{
		margin: 0 auto;
		width: 1047px;
	}
	
	input{
		width: 196px;
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
	
	thead{
		color:#1A1A1A;
		background-color: #DCDCDC;
	}
	
	a{
		color:#1A1A1A;
		text-decoration: none;
	}
	
	a:hover{
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
	
	.button{
		background-color: #1A1A1A;
		color:#FFFFFF;
		cursor: pointer;
		height: 30px;'
	}
</style>
</head>
<body>
	
	<div class="tittle">
		<s:property value="kindProducts[0].kind"/>
		<a href="AdminProductAction_selectKindForProduct">
			<img src="images/goBackGreen.png">
		</a>
		<a class="goBack" href="AdminProductAction_selectKindForProduct">返回商品品牌列表</a>
	</div>
	<table border="1px" style="border: 1px;">
		<thead>
			<tr>
				<th>种类</th>
				<th>品牌</th>
				<th>型号</th>
				<th>价格</th>
				<th>库存</th>
				<th>配置可用车型</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="kindProducts">
				<tr>
					<td>${kind}</td>
					<td>${name}
					<td align="left" width="300px"><span style="margin-left:100px;">${typeNum}</span></td>
					<td>${price}</td>
					<td>${store}</td>
					<td><a
						href="AdminProductAction_queryAppCarTypeByProductId?id=${id }&productKind=${productKind}&productName=${productName}">
							点击配置 </a>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<div style="margin-bottom: 30px;">
			<a href="AdminProductAction_listProductByKind?productKind=${productKind}&productName=${productName}&pageNow=1">${kind}首页</a>
				<a href="AdminProductAction_listProductByKind?productKind=${productKind}&productName=${productName}&pageNow=${pageNow-1}">上一页</a>
				<form style="display: inline;" action="AdminProductAction_listProductByKind?productKind=${productKind}&productName=${productName}" method="post">
					当前页：<input type="text"  name="pageNow" value="${pageNow }"/>
				</form>
				<a href="AdminProductAction_listProductByKind?productKind=${productKind}&productName=${productName}&pageNow=${pageNow+1}">下一页</a>
		<a href="AdminProductAction_listProductByKind?productKind=${productKind}&productName=${productName}&pageNow=${maxPage}">尾页</a>
	</div>
	<div class="tittle">添加新商品</div>
	<form action="AdminProductAction_addProduct?productKind=${productKind }&productName=${productName}" method="post">
		<table id="table1" border="1px">
			<thead>
				<tr>
					<td>种类</td>
					<td>品牌</td>
					<td>型号</td>
					<td>价格</td>
					<td>库存</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" name="products[0].kind"/></td>
					<td><input type="text" name="products[0].name"/></td>
					<td><input type="text" name="products[0].typeNum"/></td>
					<td><input type="text" name="products[0].price"/></td>
					<td><input type="text" name="products[0].store"/></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5">
						<input class="button" type="submit" value="添　　加"/>
						<input id="addTr" class="button" type="button" value="新增一行"/>
					</td>
				</tr>
			</tfoot>
		</table>
	</form>	
	<script type="text/javascript">
		$("#addTr").click(function(){
			var i = $("#table1 tbody").children().length;
			$("#table1 tbody").append('<tr ><td><input type="text" name="products['+i+'].kind"/></td><td><input type="text" name="products['+i+'].kind"/></td><td><input type="text" name="products['+i+'].typeNum"/></td><td><input type="text" name="products['+i+'].price"/></td><td><input type="text" name="products['+i+'].store"/></td></tr>');			
		});
	</script>
</body>
</html>