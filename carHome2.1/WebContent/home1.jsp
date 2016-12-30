<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <link href="css/admin_index.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery-1.8.3.min.js">
	</script>
<script type="text/javascript">
    $(document).ready(function () {
        $(".div2").click(function () {
            $(this).next("div").slideToggle("slow").siblings(".div3:visible").slideUp("slow");
        });
    });
</script>

    <title>后台管理</title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <%--顶部菜单信息--%>
        <div class="topbar ">
            <div class="white left" >
                <a href="admin_login.aspx" class="bt_left white">首页</a></div>
            <div class="white right">
                <asp:LinkButton ID="LBtuichu" runat="server" ForeColor="White" 
                     onclick="LBtuichu_Click" CssClass="bt_right">退出</asp:LinkButton>                 
            </div>
        </div>
       <%-- 左侧菜单--%>
        <div class="leftquyu left">
            <div class="div1">
            <div><img src="images/bbb_01.jpg"/><img src="images/bbb_02.jpg" id="2"/><img src="images/bbb_03.jpg"/><img src="images/bbb_04.jpg"/></div>
            
                <div class="div2">
                    <div class="jbsz">
                    </div>
                    常用操作</div>
                <div class="div3">
                    <ul>
                        <li><span><img style="width: 20px;height: 20px;" src="images/chilun1.jpg"/></span>
			<a style="font-size: 18px;" href="AdminCarBrandAction_listCarBrand" target="mainframe">车型管理</a></li>
                        <li><span><img style="width: 20px;height: 20px;" src="images/chilun1.jpg"/></span>
			<a style="font-size: 18px;" href="AdminProductAction_selectKindForProduct" target="mainframe">产品管理</a></li>
                        <li><span><img style="width: 20px;height: 20px;" src="images/chilun1.jpg"/></span>
			<a style="font-size: 18px;" href="AdminOrderAction_listOrders" target="mainframe">订单管理</a></li>
                    </ul>
                </div>

            <div class="div2">
                    <div class="xwzx">
                    </div>
                    特殊功能</div>
            <div class="div3">
                    <ul>                
                    <li ><a href="piliangshengchengqiantaiyonghu.aspx" target="mainframe">近3月销量统计</a></li>                    
                    <li><a href="admin_qingkongjibxinxi.aspx" target="mainframe">导出报表</a></li>             
                </ul>
            </div>

            </div>
        </div>
        <%--右侧显示区域--%>
        <div class="rightquyu right">
        <iframe class="rightframe"  name="mainframe"></iframe>
         <div class="copyright"> &copy;2016 Powered by <a href="#" target="_blank"></a>aynu</div>
        </div>

    </div>
    </form>
</body>
</html>
