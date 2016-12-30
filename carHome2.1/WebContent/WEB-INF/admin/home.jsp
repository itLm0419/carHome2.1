<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script src="SpryTabbedPanels.js" type="text/javascript"></script>
<link href="SpryTabbedPanels.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div class="adminBgDiv">
	<img src="adminBg.jpg" width="100%" />
</div>
<div class="spryTitle">
		<img src="png-0170.png" width="50px"></img>
		<span>功能菜单</span>
	</div>
	
		<div id="TabbedPanels1" class="TabbedPanels">
		  <ul class="TabbedPanelsTabGroup">
		  <div class="spryTab">
		    <li class="TabbedPanelsTab" tabindex="0">
		    <img src="png-0010.png" />学生管理</li>
		    </div>
		    <div class="spryTab">
		    <li class="TabbedPanelsTab" tabindex="0">
		    <img src="png-0025.png" />成绩管理</li>
		    </div>
		    <div class="spryTab">
		    <li class="TabbedPanelsTab" tabindex="0">
		    <img src="png-0268.png" />班级管理</li>
		    </div>
		    <div class="spryTab">
		    <li class="TabbedPanelsTab" tabindex="0">
		    <img src="png-0023.png" />帮助中心</li>
		   </div>
		   
		      <div class="spryTab" >
		      <a href="home.aspx">
		    <li class="TabbedPanelsTab" tabindex="0">
		    <img src="png-0013.png" />安全退出
		    </li>
		    </a>
		   </div>
		  </ul>
		  <div class="TabbedPanelsContentGroup">
		    <div class="TabbedPanelsContent">
		    <div class="operateImg">
		   	 <img src="png-0010.png" />
		    </div>
		    <div class="operatMenu">
			    <div class="operaterDiv">
			    	<span><a href="Students.aspx">查询学生</a></span>
			    </div>
			    <div class="operaterDiv">
			    	<span><a href="StuIn.aspx">增加学生</a></span>
			    </div>
			    <div class="operaterDiv">
			    	<span><a href="StuDe.aspx">删除学生</a></span>
			    </div>
			    <div class="operaterDiv">
			    	<span><a href="StuUp.aspx">修改学生</a></span>
			    </div>
		    </div>
		    </div>
		    	<div class="TabbedPanelsContent">
		    <div class="operateImg">
		   	 <img src="png-0025.png" />
		    </div>
		    <div class="operatMenu">
			    <div class="operaterDiv">
			    	<span><a href="score.aspx">查询成绩</a></span>
			    </div>
			    <div class="operaterDiv">
			    	<span>添加成绩(暂未实现)</span>
			    </div>
			    <div class="operaterDiv">
			    	<span>修改成绩(暂未实现)</span>
			    </div>
			    <div class="operaterDiv">
			    	<span>删除成绩(暂未实现)</span>
			    </div>
		    </div>
		    </div>
		    		    <div class="TabbedPanelsContent">
		    <div class="operateImg">
		   	 <img src="png-0268.png" />
		    </div>
		    <div class="operatMenu">
			    <div class="operaterDiv">
			    	<span><a href="class.aspx">查询班级</a></span>
			    </div>
			    <div class="operaterDiv">
			    	<span><a href="classIn.aspx">增加班级</a></span>
			    </div>
			    <div class="operaterDiv">
			    	<span><a href="classDe.aspx">删除班级</a></span>
			    </div>
			    <div class="operaterDiv">
			    	<span><a href="classUp.aspx">修改班级</a></span>
			    </div>
		    </div>
		    </div>
		    	<div class="TabbedPanelsContent">
		    <div class="operateImg">
		   	 <img src="png-0023.png" />
		    </div>
		    <div class="operatMenu">
			    <div class="operaterDiv">
			    	<span>使用说明</span>
			    </div>
			    <div class="operaterDiv">
			    	<span>隐私声明</span>
			    </div>
			    <div class="operaterDiv">
			    	<span>免责声明</span>
			    </div>
			    <div class="operaterDiv">
			    	<span>关于我们</span>
			    </div>
		    </div>
		    </div>
		  </div>
		</div>
<script type="text/javascript">
<!--
    var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
//-->
</script>
</body>
</html>
