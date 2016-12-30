<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.9.1.min.js">
</script>
<style type="text/css">
.table1{
	margin:0 auto;  
	width: 1047px;
	text-align: center; 
	margin-bottom: 20px;
}

.tittle{
	position:relative;
	margin:0 auto; 
	height: 50px;
	width: 1047px;
	color:#1A1A1A;
	font-size: 33px;
	margin-bottom: 30px;
	background-color: #DCDCDC;
	border-top:3px solid #1A1A1A;
}

a{
	color: #1A1A1A;
	text-decoration: none;
}

a:hover{
	text-decoration: underline;
}

.button{
	color:#FFFFFF;
	height:35px;
	width:150px;
	font-size:19px;
	font-weight:bold;
	background: #1A1A1A;
}
input{
	background:transparent;
	border:0;
}
.goBack{
	position:absolute;
	top:30px; 
	left:88%;
	font-size:15px;
	color:#1A1A1A;
	text-decoration:none;
}

.goBack:hover{
	text-decoration: underline;
}
.tittle img{
	position: absolute;
	left: 90%;
	width: 50px;
	height: 50px;
}
</style>
</head>
<body style="text-align: center;">
<div class="tittle">
	现有　车型	
	<a href="AdminCarBrandAction_listCarBrand">
		<img src="images/goBackGreen.png">
	</a>
	<a class="goBack" href="AdminCarBrandAction_listCarBrand">返回车牌一览表</a>
</div>
<table class="table1" border="1px">
			<thead>
				<tr>
					<td>name</td>
					<td>airOut</td>
					<td>carPicUrl</td>
					<td>startTime</td>
					<td>endTime</td>
					<td>brandId</td>
					<td>TypeNum</td>
					<td colspan="3">操作</td>
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
					<a href="AdminProductAction_selectKindForCar?carTypeNum=${brand.id }_${id}&carBrandId=${carBrandId}">匹配产品</a>
					<a href="AdminCarTypeAction_queryCarType?id=${id}&carBrandId=${carBrandId}">修改信息</a>
					<a href="AdminCarTypeAction_delCarType?id=${id}&carBrandId=${brand.id}">删除车型</a>
					</td>
				</tr>
			</s:iterator>
			</tbody>
		</table>
<div class="tittle">
	添加新车型
</div>
	<form action="AdminCarTypeAction_addCarTypesByBrand" method="post" style=" text-align: center;" >
		<table style="margin:0 auto;" border="1px" id="table1">
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
					<td><input type="text" name="brandId[0]" value="${carBrandId}" readonly="readonly"/></td>
					<td><input type="text" name="carTypes[0].TypeNum"/></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="7" style="text-align: center;">
						<input type="hidden" name="carBrandId" value="${carBrandId }" />
						<input class="button" type ="submit" value="提　　交"/>
						<input class="button" id="addTr" type ="button" value="新增一行"/>
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
	
	<script type="text/javascript">
		$("#addTr").click(function(){
			var i = $("#table1 tbody").children().length;
			$("#table1 tbody").append('<tr ><td><input type="text" name="carTypes['+i+'].name"/></td><td><input type="text" name="carTypes['+i+'].airOut"/></td><td><input type="text" name="carTypes['+i+'].carPicUrl"/></td><td><input type="text" name="carTypes['+i+'].startTime"/></td><td><input type="text" name="carTypes['+i+'].endTime"/></td><td><input type="text" name="brandId['+i+']" value="${carBrandId}"/></td><td><input type="text" name="carTypes['+i+'].TypeNum"/></td></tr>');			
		});
		
		$("tbody tr:odd").css("background-color","#DCDCDC");
	</script>
</body>
</html>