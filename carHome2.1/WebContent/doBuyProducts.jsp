<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/styles.css" rel="stylesheet" type="text/css"/>
<link href="css/myShoppingCar.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
.userMessageDiv,.productMessageDiv{
	padding-left:10px;
	padding-top:10px;
	padding-bottom:10px;
	padding-right:10px;
	margin-top:30px;
	font-weight: bold;
	background: RGB(232,242,254);
}
.userMessageDiv span{
	margin-top:30px;
	color:RGB(3,126,61);
	display: block;
}
.userMessageDiv a{
	text-decoration: none;
	font-weight: normal;
	color:RGB(195,71,32);
}
.userMessageDiv a:hover{
	font-weight: bold;
	color:red;
}
.productMessageDiv table{
	margin:0 auto;
	width:80%;
	margin-top: 30px;
}
.productMessageDiv table td{
	font-weight: 100;
}
.totalDiv{
	margin-top:50px;
	font-weight: normal;
	font-size: 18px;
	text-align: right;
}
.totalDiv span{
	margin-left: 30px;
	color:red;
}

</style>
</head>
<body>
<div class="topDiv">
		  </div> 
<div class="myCart">
		<div class="myCartContainer">
			<div class="myCartTittle">
				<div class="cartLogo">
						<img src="images/img_cart.png">
				</div>
				<div class="step">
					<span style="color: #037E3D;">1.我的购物车</span>
					<span>>></span>
					<span style="color:#EFD81A;">2.核对并提交订单信息</span>
					<span>>></span>
					<span style="color:#037E3D;">3.成功提交订单</span>
			<div class="userMessageDiv">
			确认收货地址:
			<br/>
			<span>寄送至：</span>
			${sessionScope.user.address } <font style="color:red;">${sessionScope.user.name }</font>（${sessionScope.user.phoneNum }）收 &nbsp;<a href="#">修改收货地址</a>
			
			</div>	
			<div class="productMessageDiv">
			确认商品信息:
			<table border="1px" align="center" style="border: 1px;text-align: center;" cellpadding="1">
			<tr><th>商品品牌</th><th>商品类型</th><th>商品品牌</th><th>商品型号</th><th>商品数量</th><th>商品价格</th><th>小计</th></tr>
			<s:iterator value="#session.goodModels">
			<tr><td>${product.name }</td><td>${product.kind }</td><td>${product.kind }</td><td>${product.typeNum }</td><td>${productNum }</td><td>${product.price }</td><td>${totalPrice }</td></tr>
			</s:iterator>
			</table>
			<div class="totalDiv">
			商品总数量:<span><s:property value="returnTotalProductsNum()"/></span>件(个)
			商品总价格:<span><s:property value="returnTotalProductsMoney()"/></span>元</div>
			</div>
			</div>
			<div class="cartButton">
						<span>
							<a  href="index.jsp">选购机油</a>
						</span>
							<span style="position: relative;left: 80%;">
							<a  href="OrderAction_doSubmitOrder">提交订单</a>
					</span>
					</div>
		
			
			</div>
			<br>
			</div>
			</div>
			


</body>
</html>