<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  </head>
  <body>
  		<div class="middleDiv" style="text-align: center;">
			<div id="news" class="news">
				<div class="newsContainer">
					<div id="newsTop" class="newsTop">
							<span>请选择您的车系</span>
					</div>
						<ul>
						<%
						for(int i =0 ; i<35; i++)
						{
							
							if(i>0&&i%7==0)
							{
								%>
								<BR/>
								<%
							}
							%>
							<li><a href="carTypeAction_selectBrand?carBrandId=<%=i+1%>"><img src="images/signs/<%=i %>.gif"></a></li>
							<%	
						}	
							
						%>
						</ul>
					</div>
			</div>
		</div>
		
  	  	<script type="text/javascript">
	  	  	$(function(){
		  		var imgWid = 0 ;
		  		var imgHei = 0 ; //变量初始化
		  		var big = 2.0;//放大倍数
		  		$(".newsContainer ul li").hover(
			  		function(){
				  		$(this).find("img").stop(true,true);
				  		var imgWid2 = 0;var imgHei2 = 0;//局部变量
				  		imgWid = $(this).find("img").width();
				  		imgHei = $(this).find("img").height();
				  		imgWid2 = imgWid * big;
				  		imgHei2 = imgHei * big;
				  		$(this).find("img").css({"z-index":2});
				  		$(this).find("img").animate({"width":imgWid2,"height":imgHei2,"margin-left":-imgWid2/20,"margin-top":-imgHei2/20});
				  	},
	  				function(){
		  				$(this).find("img").stop().animate({
		  					"width":imgWid,"height":imgHei,"margin-left":imgWid/20,"margin-top":imgHei/20,"z-index":1
			  			});
		  			}
		  		);
	  		});
  	  	</script>
  </body>
</html>
