<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	form{
		margin: 0 auto;
		text-align: center;
	}
	
	.login{
		width: 500px;
		height: 180px;
		margin:0 auto;
		margin-top: 300px;
		border: 1px solid red;
	}
	
	input{
		margin-top: 20px;
		width: 300px;
		height: 30px;
	}
</style>
<script type="text/javascript" src="js/jquery-1.8.3.min.js">
</script>
<script type="text/javascript">
$(function (){
	if($("input:hidden").val()=="noUser")
		{
			alert("请先登录账户!");
		}

	
})

</script>
</head>
<body>

<input type="hidden" name="message" value="${message}"/>
	<form action="UserAction_login" method="post">
		<div class="login">
			<s:fielderror fieldName="login" />
			用户名：<input type="text" name="userName"/>
			<br>
			密　码：<input type="password" name="password"/>
			<br>
			<input style="width: 150px;" type="submit" value="登录"/>
		</div>
	</form>
</body>
</html>