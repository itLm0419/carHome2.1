<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<link rel="stylesheet" href="css/styles.css" type="text/css"></link>
</head>

<body>
	<script type="text/javascript" src="js/jquery-1.9.1.min.js">
		
	</script>
	<style type="text/css">
.introduceDiv {
	font-family: "华文行楷";
	font-size: 150px;
	color: RGB(250, 219, 14);
	position: absolute;
	top: 38%;
	z-index: 999;
	text-align: center;
	width: 100%;
	display: none;
}
</style>
	<script type="text/javascript" src="js/jquery-ui.js">
		
	</script>
	<link href="js/jquery-ui.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
		$(function() {
			$(".topDiv").css("height", window.screen.height * 0.5);
			$(".logoDiv").css("background", "RGB(250,219,14)");
			$(".logoDiv").css("height", window.screen.height * 0.5);

			$(".introduceDiv").fadeIn(2000, function() {
				$(".topDiv").slideUp(1000);
				$(".logoDiv").animate({
					height : '50px'
				}, 1000, function() {
					$(".logoDiv").animate({
						backgroundColor : "RGB(3,126,61)"
					}, 1000);
					$(".introduceDiv").fadeOut(2000);
				});
			});
		});
	</script>
</head>

<body>
	<div class="introduceDiv">欢迎访问</div>
	<div class="topDiv"></div>
	<div class="logoDiv"></div>
</body>
<jsp:include page="middle.jsp"></jsp:include>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>
