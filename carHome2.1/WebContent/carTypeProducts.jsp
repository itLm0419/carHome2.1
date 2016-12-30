<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
	<link href="css/productTable.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
</head>
<body>
	<%@ include file="top.jsp" %>
	<div class="shopCarDiv">
		<a href="ShoppingCarAction_showShoppingCar" ><img id="shoppinCar" style="width: 50px;height: 50px;" src="images/shopCar.png" /></a>
	</div>
	<h1><font>${carBrandName }${carTypeName }</font>车型配件一览表</h1>
	<table border="1px" width="1100px" style="margin: 0 auto;">
		<tr><th>图标</th><th>型号</th><th>排量</th><th>时间截止(月/年)</th><th width="200px">空气滤清器</th><th width="200px">机油滤清器</th><th width="200px">燃油滤清器</th><th width="200px">空调滤清器</th></tr>
		<s:iterator value="carTypeProductModels">
		<tr class="dataTr"><td><img src="" /></td><td>${car.name}</td><td>${car.airOut }</td><td>${car.carPicUrl }</td>
		<td style="background: #f7f8b6">
			<s:iterator value="carApplyProducts">
				<s:if test="kind == '空气滤清器'">
					<div class="productKindDiv">
					<div>
					<a class="${id }" href="ProductAction_returnProductInfoById?id=${id }">${typeNum }</a>
					</div>
					<span>库存</span>:${store }
						<s:if test="store > 0">
					<a class="btn-buy" id="${id }" href="ShoppingCarAction_addToCar?productId=${id}&num=1" id="${id }">
							<img src="images/addToCartNormal.png" width="35px" alt="加入购物车"/></a>
						</s:if>
						<s:elseif test="store == 0">
					<a  id="${id }">
							<img src="images/addToCart.png" width="35px" alt="加入购物车"/></a>
						</s:elseif>
					</div>
					<br>
				</s:if>
			</s:iterator>
		</td>

		<td >
			<s:iterator value="carApplyProducts">
				<s:if test="kind == '机油滤清器'">
					<div class="productKindDiv">
					<div>
					<a class="${id }" href="ProductAction_returnProductInfoById?id=${id }">${typeNum }</a>
					</div>
					<span>库存:${store }</span>
						<s:if test="store > 0">
					<a class="btn-buy" id="${id }" href="ShoppingCarAction_addToCar?productId=${id}&num=1" id="${id }">
							<img src="images/addToCartNormal.png" width="35px" alt="加入购物车"/></a>
						</s:if>
						<s:elseif test="store == 0">
									<a  id="${id }">
							<img src="images/addToCart.png" width="35px" alt="加入购物车"/></a>
						</s:elseif>
					
					</div>
					<br>
				</s:if>
			</s:iterator>
		</td>
		<td style="background: #f7f8b6">
			<s:iterator value="carApplyProducts">
				<s:if test="kind == '燃油滤清器'">
									<div class="productKindDiv">
					<div>
					<a class="${id }" href="ProductAction_returnProductInfoById?id=${id }">${typeNum }</a>
					</div>
					<span>库存</span>:${store }
										<s:if test="store > 0">
					<a class="btn-buy" id="${id }" href="ShoppingCarAction_addToCar?productId=${id}&num=1" id="${id }">
							<img src="images/addToCartNormal.png" width="35px" alt="加入购物车"/></a>
						</s:if>
						<s:elseif test="store == 0">
					<a  id="${id }">
							<img src="images/addToCart.png" width="35px" alt="加入购物车"/></a>
						</s:elseif>
					</div>
					<br>
				</s:if>
			</s:iterator>
		</td>

		<td>
			<s:iterator value="carApplyProducts">
				<s:if test="kind == '空调滤清器'">
					<div class="productKindDiv">
					<div>
					<a class="${id }" href="ProductAction_returnProductInfoById?id=${id }">${typeNum }</a>
					</div>
					<span>库存</span>:${store }
													<s:if test="store > 0">
					<a class="btn-buy" id="${id }" href="ShoppingCarAction_addToCar?productId=${id}&num=1" id="${id }">
							<img src="images/addToCartNormal.png" width="35px" alt="加入购物车"/></a>
						</s:if>
						<s:elseif test="store == 0">
					<a  id="${id }">
							<img src="images/addToCart.png" width="35px" alt="加入购物车"/></a>
						</s:elseif>
					</div>
					<br>
				</s:if>
			</s:iterator>
		</td>
		</tr>
		</s:iterator>
	</table>
<script type="text/javascript">
	


	 //商品飞入购物车效果
	 $('.btn-buy').bind('click',function(){
		 	var img = $(this).prev().prev();
			var flyElm = img.clone().css('opacity', 0.75);
			$('body').append(flyElm);
			flyElm.css({
				'z-index': 9000,
				'display': 'block',
				'position': 'absolute',
				'top': img.offset().top +'px',
				'left': img.offset().left +'px',
				'width': img.width() +'px',
				'height': img.height() +'px'
			});
			flyElm.animate({
				top: $('#shoppinCar').offset().top,
				left: $('#shoppinCar').offset().left,
				width: 20,
				height: 32
			}, 'slow', function() {
				flyElm.remove();
			});
			var url = this.href;
			var args = {"time":new Date()};
			$.getJSON(url,args,function(data){
			});
			return false;
	}); 
	 
	 $(function (){
		 $("table tr:odd").css("background","#ccecdc");
	 });
</script>

<div class="oil">
		<div class="oilProductsContainer">
			<div class="oilProductsTop">
				<span style="margin-top: 10px;">为您的爱车选购一款机油吧！</span>
				<span style="margin-top: 10px; margin-left:750px;">
					<a style="color:#037E3D;" href="ProductAction_reurnAllOilProducts" target="_blank">更多>></a>
				</span>
			</div>
			<div class="oilProductContent">
				<ul>
				<s:iterator value="oilProducts" status="st">
				<s:if test="store>0">
				<li>
						<div class="oilType">
							<p>
							<a class="OILNAME" href="ShoppingCarAction_addToCar?productId=${id}&num=1">${name }</a>
							<a class="OILNAME" href="ShoppingCarAction_addToCar?productId=${id}&num=1">${typeNum }</a>
							</p>
							<a class="OILNAME" href="ShoppingCarAction_addToCar?productId=${id}&num=1">
								<img class="OILPIC" src="images/oilPic/oil<s:property value="#st.index+1" />.jpg"/>
							</a>
							<p style="color:#037E3D;"> 库存:${store }</p>
							<p style="font-size: 20px;text-align:center;color:#037E3D;">价格:￥${price }</p>
						</div>
					</li>
				</s:if>
				<s:else>
				<li>
						<div class="oilType">
							<p>
							<a class="OILNAMENoStore" >${name }</a>
							<a class="OILNAMENoStore" >${typeNum }</a>
							</p>
							<a class="OILNAMENoStore" >
								<img class="OILPIC" src="images/oilPic/oil<s:property value="#st.index+1" />.jpg"/>
							</a>
							<p >库存:${store }</p>
							<p >价格 :￥${price }</p>
						</div>
					</li>
				</s:else>
						
				</s:iterator>
				</ul>
			</div>
		</div>
	</div>
<script type="text/javascript">
	 //商品飞入购物车效果
	 $('.btn-buy').bind('click',function(){
		 	var img = $(this).prev().prev();
			var flyElm = img.clone().css('opacity', 0.75);
			$('body').append(flyElm);
			flyElm.css({
				'z-index': 9000,
				'display': 'block',
				'position': 'absolute',
				'top': img.offset().top +'px',
				'left': img.offset().left +'px',
				'width': img.width() +'px',
				'height': img.height() +'px'
			});
			flyElm.animate({
				top: $('#shoppinCar').offset().top,
				left: $('#shoppinCar').offset().left,
				width: 20,
				height: 32
			}, 'slow', function() {
				flyElm.remove();
			});
			var url = this.href;
			var args = {"time":new Date()};
			$.getJSON(url,args,function(data){
			});
			return false;
	}); 
	 //让机油飞
	 $('.OILNAME').bind('click',function(){
		 	var img = $(this).parent().parent();
			var flyElm = img.clone().css('opacity', 0.75);
			$('body').append(flyElm);
			flyElm.css({
				'z-index': 9000,
				'display': 'block',
				'position': 'absolute',
				'top': img.offset().top +'px',
				'left': img.offset().left +'px',
				'width': img.width() +'px',
				'height': img.height() +'px'
			});
			flyElm.animate({
				top: $('#shoppinCar').offset().top,
				left: $('#shoppinCar').offset().left,
				width: 20,
				height: 32
			}, 'slow', function() {
				flyElm.remove();
			});
			var url = this.href;
			var args = {"time":new Date()};
			$.getJSON(url,args,function(data){
			});
			return false;
	}); 
	
	 
	 $(function (){
		 $("table tr:odd").css("background","#ccecdc");
	 });
	 
	 $(".oilProductContent>ul>li").mouseover(function(){
		$(this).css("background","#F7F8B6");		 
	 });
	 $(".oilProductContent>ul>li").mouseout(function(){
		$(this).css("background","");		 
	 });
</script>
</body>
</html>