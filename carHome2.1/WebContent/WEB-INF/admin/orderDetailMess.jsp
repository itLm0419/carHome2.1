<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/admin_index.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.8.3.min.js">
</script>
</head>
<body>
<h2 align="center">订单详细信息</h2>
<table border="1"  class="tableDiv" style="margin: 0 auto;">
<tr height="30px" style="background: RGB(178,209,230);">
<th>商品种类</th><th>商品品牌</th><th>商品型号</th><th>商品价格</th><th>商品个数</th><th>商品总价</th></tr>
<s:iterator value="model.orderProductMesses">
<tr > 
<td>${product.kind }</td>
<td>${product.name }</td>
<td>${product.typeNum }</td>
<td>${product.price }</td>
<td>${productNum }</td>
<td>${totalPrice }</td>
</tr>
</s:iterator>
<tr><td colspan="4"></td><td>总计:</td><td>${model.totalPrice }</td></tr>
<tr><td colspan="6"><hr></td></tr>
<tr><th rowspan="2">用户信息:</th><td>用户名</td><td>真实姓名(收货人)</td><td>联系方式</td><td colspan="2">收货地址</td></tr>
<tr>
<td>${model.user.userName }</td>
<td>${model.user.name }</td>
<td>${model.user.phoneNum }</td>
<td colspan="2">${model.user.address }</td>
</tr>
</table>
<script type="text/javascript">
$(function (){
	//table隔行变色
		$("tr:even:gt(0)").css("background","RGB(232,242,254)");
	});
</script>
</body>
</html>