<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<link rel="stylesheet" href="css/styles.css" type="text/css"></link>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="oilPorducts">
		<div class="shopCarDiv">
			<a href="ShoppingCarAction_showShoppingCar"><img id="shoppinCar" style="width: 50px;height: 50px;" src="images/shopCar.png" /></a>
		</div>
		<div class="oilsContainer">
			<div class="tittle">
					<a href="index.jsp">
						<img src="images/oilPics/goBack.png"/>
					</a>
					<span>
						<a href="index.jsp">返回首页</a>
					</span>
				<p style="font-size: 30px;font-weight: bold;margin-left: 250px;">汽车要想跑得快</p>
				<p style="font-size: 30px;font-weight: bold;margin-left: 500px;">必须有款好机油</p>
			</div>
			<div class="specificOilProducts">
				<div class="specificOilType">
					<span style="margin-left: 10px;">凯迪</span>
				</div>
				<div class="specificOilProductsInfo">
					<ul>
						<s:iterator value="oilProducts">
							<s:if test="name == '凯迪'">
											<li style="display: inline-block;">
												<p>
													<a class="oilNAME" style="color:#037E3D;font-size: 20px;" href="ShoppingCarAction_addToCar?productId=${id}&num=1">${typeNum }</a>
												</p>
												<a href="ShoppingCarAction_addToCar?productId=${id}&num=1">
													<img class="oilPIC" src="images/oilPics/oil1.jpg"/>
												</a>
												<p>价格</p>
												<p style="color:#DF0408">￥${price }</p>
											</li>
							</s:if>
						</s:iterator>
					</ul>
				</div>
				<div class="specificOilType">
					<span style="margin-left: 10px;">摩托弄啦</span>
				</div>
				<div class="specificOilProductsInfo">
					<ul>
						<s:iterator value="oilProducts">
							<s:if test="name == '摩托弄啦'">
											<li>
												<p>
													<a class="oilNAME" style="color:#037E3D;font-size: 20px;" href="ShoppingCarAction_addToCar?productId=${id}&num=1">${typeNum }</a>
												</p>
												<a href="ShoppingCarAction_addToCar?productId=${id}&num=1">
													<img class="oilPIC" src="images/oilPics/oil1.jpg"/>
												</a>
												<p>价格</p>
												<p style="color:#DF0408">￥${price }</p>
											</li>
							</s:if>
						</s:iterator>
					</ul>
				</div>
				<div class="specificOilType">
					<span style="margin-left: 10px;">喜马拉元</span>
				</div>
				<div class="specificOilProductsInfo">
					<ul>
						<s:iterator value="oilProducts">
							<s:if test="name == '喜马拉元'">
											<li>
												<p>
													<a class="oilNAME" style="color:#037E3D;font-size: 20px;" href="ShoppingCarAction_addToCar?productId=${id}&num=1">${typeNum }</a>
												</p>
												<a href="ShoppingCarAction_addToCar?productId=${id}&num=1">
													<img class="oilPIC" src="images/oilPics/oil1.jpg"/>
												</a>
												<p>价格</p>
												<p style="color:#DF0408">￥${price }</p>
											</li>
							</s:if>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
		
	
	<script type="text/javascript">
		//让机油飞~
		 $('.oilNAME').bind('click',function(){
			 	var img = $(this).parent().next().find('img');
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
		 $('.oilPIC').bind('click',function(){
			 	var img = $(this);
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
				var url = $(this).parent().attr("href");
				var args = {"time":new Date()};
				$.getJSON(url,args,function(data){
				});
				return false;
		}); 
		 
		 //鼠标移到商品上面效果
		 $(".specificOilProductsInfo>ul>li").mouseover(function(){
			 $(this).css("background","#f8f0ba");
		 });
		 $(".specificOilProductsInfo>ul>li").mouseout(function(){
			 $(this).css("background","");
		 });
		 
		 //鼠标移到商品名字上面名字变色
		 $(".oilNAME").mouseover(function(){
			 $(this).css("color","#DF0408");
		 });
		 $(".oilNAME").mouseout(function(){
			 $(this).css("color","#037E3D");
		 });
	</script>
</body>
</html>