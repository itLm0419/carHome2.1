<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		var imgWid = 0;
		var imgHei = 0; //变量初始化
		var big = 1.2;//放大倍数
		$(".middleDiv ul li").hover(function() {
			$(this).find("div").stop(true, true);
			var imgWid2 = 0;
			var imgHei2 = 0;//局部变量
			imgWid = $(this).find("div").width();
			imgHei = $(this).find("div").height();
			imgWid2 = imgWid * big;
			imgHei2 = imgHei * big;
			$(this).find("div").css({
				"z-index" : 2
			});
			$(this).find("div").animate({
				"width" : imgWid2,
				"height" : imgHei2,
				"margin-left" : -imgWid2 / 20,
				"margin-top" : -imgHei2 / 20
			});
		}, function() {
			$(this).find("div").stop().animate({
				"width" : imgWid,
				"height" : imgHei,
				"margin-left" : imgWid / 20,
				"margin-top" : imgHei / 20,
				"z-index" : 1
			});
		});
	});
	$(function(){
		function sA(s,t){
		s.fadeIn(t,function(){
		if(s.next().length){
		sA(s.next(),t);
		}
		});
		}

		var test = $(".box").eq(0);
		sA(test,testA,1000);
	});
</script>
</head>
<body>
	<div class="topDiv"></div>
	<div class="logoDiv" style="height: 70px;">
		<img src="images/signs/0.gif" class="title" /> <span>${carBrand.name }</span>
	</div>
	<div class="middleDiv" style="text-align: center;">
		<div id="news" class="news">
			<div class="newsContainer">
				<div id="newsTop" class="newsTop">
					<span>请选择您的车型</span>
				</div>
				<div class="carTypes">
					<s:iterator value="cars" var="car" status="s">
						<div class="box">
							<a
								href="ProductAction_returnApplyProductsByCarConfig?carBrandId=${car.brand.id }&carTypeName=${car.name}&carBrandName=${carBrand.name}">
								<div class="imgDiv">
									<span
										style="font-family: '微软雅黑'; font-size: 20px; color: RGB(21, 137, 197);">${car.name }</span>
								</div>
							</a>
						</div>
					</s:iterator>
				</div>
			</div>
		</div>
	</div>
</body>
</html>