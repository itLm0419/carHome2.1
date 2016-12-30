<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>我的购物车</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  	<link rel="stylesheet" href="css/myShoppingCar.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>
  </head>
  
  <body >
		<div class="topDiv">
		  </div> 
  
  	
	<div class="myCart">
		<div class="myCartContainer">
			<div class="myCartTittle">
				<div class="cartLogo">
						<img src="images/img_cart.png">
				</div>
				<div class="step">
					<span style="color: #EFD81A;">1.我的购物车</span>
					<span>>></span>
					<span style="color:#037E3D;">2.核对并提交订单信息</span>
					<span>>></span>
					<span style="color:#037E3D;">3.成功提交订单</span>
				</div>
			</div>
			<br>
			<div class="myCartInfo">
					<table style=" color:black; background-color:#fff; text-align: center; width: 100%;" border="1" bordercolor="#DBDBDB"  cellspacing="0">
						<tr>
							<th width="10%">商品编号</th>
							<th width="50%">商品名称</th>
							<th width="10%">商品型号</th>
							<th width="10%">价格</th>
							<th width="10%">数量</th>
							<th width="10%">操作</th>
						</tr>
						<s:iterator value="goodModels" >
							<tr>
								<td>${product.id }</td>
								<td>${product.name }</td>
								<td>${product.typeNum }</td>
								<td>${product.price }</td>
								<td>
								<form action="ShoppingCarAction_updateShoppingCarByProductId" method="post">
								<input style="width: 30px;" type="text" class="productNum" name="num" value="${productNum }"/>
								<input type="hidden" name="productId" value="${product.id }" />
								<input type="submit" class="delete" value="修改"/>
								</form>
								</td>
								<td>
									<a class="delete" href="ShoppingCarAction_removeProductFromShoppingCarByProductId?productId=${product.id }">[删除]</a>
								</td>
							</tr>
						</s:iterator>
					</table>
					<div class="total">
						<span>
							商品数量总计：<s:property value="returnTotalProductsNum()"/>件,商品总金额：￥<s:property value="returnTotalProductsMoney()" />0
						</span>
					</div>
					<div class="cartButton">
						<span>
							<a  href="index.jsp">继续购物</a>
						</span>
						<span>
							<a id="clear"  href="ShoppingCarAction_clearUpCar">清空购物车</a>
						</span>
						<s:if test="goodModels!=null&&goodModels.size()!=0">
						<span style="position: relative;left: 74%;">
							<a  href="ShoppingCarAction_doBuyPruducts">确认购买</a>
							</span>
							</s:if>
							<s:else>
							<span style="position: relative;left: 74%;background:#DCDCDC;">
							<a  style="color:black;">确认购买</a>
							</span>
							</s:else>
						
					</div>
			</div>
		</div>
	</div>
	<div class="bottomDiv"></div>	
	<script type="text/javascript">
		$(".productNum").blur(function(){
			var id = $(this).next(":hidden").val();
			var num = $(this).val();
			var url = "ShoppingCarAction_updateShoppingCarByProductId?num="+num+"&productId="+id;
			window.open(url,"_self");
		});
		
	</script>
	
  </body>
</html>
