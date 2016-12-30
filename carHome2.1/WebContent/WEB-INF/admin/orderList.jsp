<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/styles.css" rel="stylesheet" type="text/css"/>
<link href="css/admin_index.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.8.3.min.js">
</script>

<style type="text/css">
	.orders{
	height:30px;
	font-size: 18px;
	font-weight: bold;
	}
</style>
</head>
<body>
<h2>订单管理> 
<select name="orders" class="orders">
<option value="all" name="all">全部订单</option>
<option value="0" id="0" >未处理订单</option>
<option value="1" id="1">已处理订单</option>
<input type="hidden" value="${op }" />
</select>
</h2>

<table border="1" class="tableDiv">
<tr height="30px" style="background: RGB(178,209,230);"><th>订单编号</th><th>订单总价</th><th>订单状态</th><th>下单时间</th><th>详情</th></tr>
<s:iterator value="orders">
<tr>
	<td>${orderNum }</td>
	<td>${totalPrice }</td>
	<s:if test="orderStatus == '等待发货'">
	<td>${orderStatus }&nbsp;<a href="AdminOrderAction_StartProducts?id=${id }&op=${op}">发货</a></td>
	</s:if>
	<s:else>
	<td>${orderStatus }&nbsp;<a href="AdminOrderAction_CancelProducts?id=${id }&op=${op}">取消发货</a></td>
	</s:else>
	<td>${orderTime }</td>
	<td>
	<a href="javascript:void(0);" target="_blank" onclick="run(this)">>显示详情</a>
	<input type="hidden" value="${id }" />
	</td>

</tr>
</s:iterator>
</table>
<script type="text/javascript">
	$(".orders").change(function(){
		window.open("AdminOrderAction_listOrders?op="+$(this).val(),"_self");
		});
	$(function (){
		$("#"+$("input:hidden").val()).attr("selected",true);
	})
	function run(a)
	{
		 window.open('AdminOrderAction_ShowOrderMess?id='+$(a).next().val(),'newwindow','height=600,width=800,top=190,left=350,toolbar=no,menubar=no,scrollbars=no,resizable=no, location=no,status=no');    
	};
	$(function (){
		//table隔行变色
			$("tr:even:gt(0)").css("background","RGB(232,242,254)");
		});
	var toPrevPage = function (pageNow){
			if(pageNow == 1)
				{
					alert("已经是第一页！");
					return false;
				}
			return true;
		}

	var toNextPage = function (pageNow,maxPage){
			if(pageNow == maxPage)
				{
					alert("已经是最后一页！");
					return false;
				}
			return true;
		}
</script>
	<div style="margin-left:40%;">
			<a href="AdminOrderAction_listOrders?pageNow=1">首页</a>
				<a href="AdminOrderAction_listOrders?pageNow=${pageNow-1}" onclick="return toPrevPage(${pageNow})">上一页</a>
				<form style="display: inline;" action="AdminOrderAction_listOrders" method="post">
					当前页：<input type="text"  name="pageNow" style="width:30px;" value="${pageNow }"/>
				</form>
				<a href="AdminOrderAction_listOrders?pageNow=${pageNow+1}" onclick="return toNextPage(${pageNow},${maxPage })">下一页</a>
		<a href="AdminOrderAction_listOrders?pageNow=${maxPage}">尾页</a>
	</div>
</body>
</html>