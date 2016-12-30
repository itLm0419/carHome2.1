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
		color:#037E3D;
		background-color: #FADB0E;
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
		height: 50px;
		width: 1047px;
		color:#037E3D;
		margin:0 auto;
		margin-bottom:30px;
		text-align:center;
		font-size:30px;
		font-weight:bold;
		background-color: #FADB0E;
	}
	
	.button{
		margin-top:7px;
		width: 150px;
		height:35px;
		color:#FADB0E;
		font-size:15px;
		font-weight:bold;
		background-color: #037E3D;
	}
	
	.button:hover{
		cursor:pointer;
	}
</style>
</head>
<body>
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
						<input type ="submit" value="提　　交"/>
					</td>
				</tr>
			</tfoot>
		</table>
	</form>

</body>
</html>