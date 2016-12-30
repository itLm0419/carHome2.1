<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<style type="text/css">
	body{
		text-align: center;
	}
	
	table{
		width: 1047px;
		margin: 0 auto;
		margin-bottom: 30px;
	}
	
	thead{
		color:#1A1A1A;
		background-color: #DCDCDC;
	}
	
	a{
		color:red;
		text-decoration: none;
	}
	
	a:hover{
		color:#037E3D;
		text-decoration: underline;
	}
	
	.tittle{
		position:relative;
		height: 50px;
		width: 1047px;
		color:#FFFFF;
		margin:0 auto;
		margin-bottom:30px;
		text-align:center;
		font-size:30px;
		border-top:3px solid #1A1A1A;
		background-color: #DCDCDC;	
	}
	
	.button{
		width: 150px;
		height:35px;
		color:#FFFFFF;
		font-size:15px;
		font-weight:bold;
		background-color: #1A1A1A;
	}
	
	.button:hover{
		cursor:pointer;
	}
	
	tfoot{
		color: #1A1A1A;
		background-color: #DCDCDC;
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
<body>
<div class="tittle">
	修改车型信息
	<a href="AdminCarBrandAction_listCarBrand">
		<img src="images/goBackGreen.png">
	</a>
	<a class="goBack" href="AdminCarTypeAction_listCarTyeByBrand?carBrandId=${carBrandId}">返回现有车型</a>
</div>
<form action="AdminCarTypeAction_updateCarType" method="post" style="text-align: center;" >
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
					<td><input type="text" name="name" value="${model.name }"/></td>
					<td><input type="text" name="airOut" value="${model.airOut }"/></td>
					<td><input type="text" name="carPicUrl" value="${model.carPicUrl }"/></td>
					<td><input type="text" name="startTime" value="${model.startTime }"/></td>
					<td><input type="text" name="endTime" value="${model.endTime }"/></td>
					<td><input type="text" name="carBrandId" value="${model.brand.id }"/></td>
					<td><input type="text" name="typeNum" value="${model.typeNum }"/></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>	
					<td colspan="7" style="text-align: center;">
						<input type="hidden" name="id" value="${model.id }" />
						<input class="button" type ="submit" value="提　　交"/>
					</td>
				</tr>
			</tfoot>
		</table>
	</form>

</body>
</html>