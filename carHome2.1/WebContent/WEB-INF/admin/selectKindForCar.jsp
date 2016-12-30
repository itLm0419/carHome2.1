<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>
<style type="text/css">
	a{
		color: #1A1A1A;
		text-decoration: none;
	}
	
	a:hover{
		text-decoration: underline;
	}
	
	.productName{
		height:30px; 
		background-color: #DCDCDC; 
		border-top:3px solid #1A1A1A; 
		color:#1A1A1A;
		font-weight:bold; 
		font-size:20px;
		cursor:pointer;
	}
	
	.productNum{
		border-bottom: 1px dashed #DCDCDC;
	}
</style>
</head>
<body>
	<a href="AdminCarTypeAction_listCarTyeByBrand?carBrandId=${carBrandId}">返回现有车型</a>
	<br><br>
	<s:iterator value="names" var="name">
		<div class="productName">
			${name}
			<img style="width: 20px;height: 20px;" src="images/slidDown.png">
		</div>
		<div class="productNum" style="display: none;">
			<s:iterator value="kinds" var="kind">
				<a
					href="AdminProductAction_returnApplyProductsByOneCarTypeNum?carTypeNum=${carTypeNum }&productKind=${kind}&productName=${name}&carBrandId=${carBrandId}"> ${kind}</a>
				<br>
			</s:iterator>
		</div>
	</s:iterator>
	
	<script type="text/javascript">
		$(".productName").click(function(){
			$(this).next().slideToggle(function(){
				if($(this).is(':hidden')){
					$(this).prev().find("img").attr("src","images/slidDown.png");
				}else{
					$(this).prev().find("img").attr("src","images/slidUp.png");
				}
			});
			});
	</script>
</body>
</html>