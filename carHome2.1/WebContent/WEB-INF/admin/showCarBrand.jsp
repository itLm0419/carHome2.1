<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.button:hover{
		cursor:pointer;
	}
</style>
</head>
<body>
	<form style="text-align: center;" action="AdminCarBrandAction_updateCarBrand" method="post">
		<div style="width: 600px;height: 180px;margin: 0 auto;">
				<div style="width: 160px;height: 180px;margin-left: 80px;float: left;">
					<img style="height: 160px;width: 160px;" src="images/write.jpg"/>
				</div>
				<div style="text-shadow: #B4B5B5 5px 5px 5px;  font-size: 40px;width: 220px;margin-top:60px;float: left;color:#1A1A1A;">
					修改车品牌
				</div>
		</div>
		<input type="hidden" name="id" value="${model.id }"/>
		<span style="text-shadow: #B4B5B5 5px 5px 5px; font-size:25px;font-weight:bold;color:#1A1A1A">车牌名称:</span>
		<input style="border:1px solid #037E3D; height: 30px;width: 300px;" type="text" name="name" value="${model.name }"/>
		<input class="button" style="font-size:20px; height: 38px;width: 150px;background-color: #1A1A1A; color:#FFFFFF;" type="submit" value="确认修改"/>
		<a href="AdminCarBrandAction_listCarBrand">
			<input class="button" style="font-size:20px; height: 38px;width: 150px;background-color: #1A1A1A; color:#FFFFFF;" type="button" value="返回"/>
		</a>
	</form>
</body>
</html>