<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
</head>
<body>
<s:debug></s:debug>
<table border="1px">
			<thead>
				<tr>
					<td>name</td>
					<td>airOut</td>
					<td>carPicUrl</td>
					<td>startTime</td>
					<td>endTime</td>
					<td>brandId</td>
					<td>TypeNum</td>
					<td colspan="2">操作</td>
				</tr>
			</thead>
			<tbody>
			<s:iterator value="carTypes">
				<tr>
					<td>${name }</td>
					<td>${airOut }</td>
					<td>${carPicUrl }</td>
					<td>${startTime }</td>
					<td>${endTime }</td>
					<td>${brand.id }</td>
					<td>${typeNum }</td>
					<td>
					<a href="AdminCarTypeAction_queryCarType?id=${id}">修改</a>
					<a href="AdminCarTypeAction_delCarType?id=${id}&carBrandId=${brand.id}">删除</a>
					</td>
				</tr>
			</s:iterator>
			</tbody>
		</table>

	<form action="AdminCarTypeAction_addCarTypesByBrand" method="post" style="text-align: center;" >
		<table border="1px" id="table1">
			<thead>
				<tr>
					<td>name</td>
					<td>airOut</td>
					<td>carPicUrl</td>
					<td>startTime</td>
					<td>endTime</td>
					<td>brandId</td>
					<td>TypeNum</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" name="carTypes[0].name"/></td>
					<td><input type="text" name="carTypes[0].airOut"/></td>
					<td><input type="text" name="carTypes[0].carPicUrl"/></td>
					<td><input type="text" name="carTypes[0].startTime"/></td>
					<td><input type="text" name="carTypes[0].endTime"/></td>
					<td><input type="text" name="brandId[0]"/></td>
					<td><input type="text" name="carTypes[0].TypeNum"/></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="7" style="text-align: center;">
						<input type="hidden" name="carBrandId" value="${carBrandId }" />
						<input type ="submit" value="提　　交"/>
						<input id="addTr" type ="button" value="新增一行"/>
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
	
	<script type="text/javascript">
		$("#addTr").click(function(){
			var i = $("#table1 tbody").children().length;
			$("#table1 tbody").append('<tr><td><input type="text" name="carTypes['+i+'].name"/></td><td><input type="text" name="carTypes['+i+'].airOut"/></td><td><input type="text" name="carTypes['+i+'].carPicUrl"/></td><td><input type="text" name="carTypes['+i+'].startTime"/></td><td><input type="text" name="carTypes['+i+'].endTime"/></td><td><input type="text" name="brandId['+i+']"/></td><td><input type="text" name="carTypes['+i+'].TypeNum"/></td></tr>');			
		});
	</script>
</body>
</html>