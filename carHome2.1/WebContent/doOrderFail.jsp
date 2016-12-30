<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/myShoppingCar.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
	a{
		color:#C9AB33;
		text-decoration: none;
	}
	a:hover{
		text-decoration: underline;
	}
</style>
</head>
<body>
	<div class="topDiv"></div>
	<div class="myCart">
		<div class="myCartContainer">	
			<div class="myCartTittle">
				<div class="cartLogo">
					<img src="images/img_cart.png">
				</div>
				<div class="step">
					<span style="color: #037E3D;">1.我的购物车</span> <span>>></span> <span
						style="color: #037E3D;">2.核对并提交订单信息</span> <span>>></span> <span
						style="color: #EFD81A;">3.成功提交订单</span>
				</div>
				<img src="images/order/orderFailed.png">
						<div style="font-size: 30px;font-weight:bold; color: #037E3D;">
							<%
								String message = (String)request.getAttribute("message");
								message = new String(message.getBytes("iso-8859-1"),"utf-8");
								out.print(message);
							%>
							请<a href="ShoppingCarAction_showShoppingCar">修改数量</a>
						</div>
			</div>
		</div>
	</div>
</body>
</html>