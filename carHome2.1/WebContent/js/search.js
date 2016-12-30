$(function() {
	for (var i = 1; i <= 9; i++) {
		ajax(i);
	}
})
String.prototype.startWith=function(s){
  if(s==null||s==""||this.length==0||s.length>this.length)
   return false;
  if(this.substr(0,s.length)==s)
     return true;
  else
     return false;
  return true;
 }
function ajax(i) {
	var oldContent = "";// 文本变化前的内容，使用它和新内容对比，发生了变化才发送ajax请求
	{
		$("#content" + i).keyup(
				function() {
					var content = $.trim($("#content" + i).val());
					if (content == "" || content == oldContent) {

						return;// 没有输入内容或者文本内容没有发生变化时就返回

					}
					oldContent = content;

					var params = {
						"input" : $.trim($("#content" + i).val())
					};
					$.ajax({
						url : "MatchAction_ajaxGetProduct",
						type : "post",
						data : params,
						dataType : "json",
						success : function(data) {
							if (data.keywords.length == 0) {
								// 没有关键字就隐藏提示框，并返回
								$("#suggest" + i).hide();
								return;
							}
							$("#suggest" + i).show().html("");// 显示提示框并清空提示框
							// 添加关键字列表
							for (var j = 0; j < data.keywords.length; j++) {
								$("#suggest" + i).append(
										"<div class='keyword" + i + "'>"
												+ data.keywords[j] + "</div>");
							}
							// 为新添加的关键字列表添加事件
							$(".keyword" + i).live(
									"mousemove",
									function(event) {
										// 鼠标移入背景变成灰色
										$(event.target).css("background-color",
												"silver");
									});
							$(".keyword" + i).live(
									"mouseout",
									function(event) {
										// 鼠标移出背景变成白色
										$(event.target).css("background-color",
												"white");
									});
							$(".keyword" + i).dblclick(function(event) {
								// 双击时把内容加入到select框
								var val = $(event.target).html();
								if(val.startWith("曼牌"))
									{
									alert(val.substr(2,val.length-2));
									$("#select" + i+"1").append("<option value='"+val.substr(2,val.length-2)+"'>"+val+"</option>");
									}
								else if(val.startWith("马勒"))
								{
									$("#select" + i+"2").append("<option value='"+val.substr(2,val.length-2)+"'>"+val+"</option>");
								}
								else if(val.startWith("科德宝"))
								{
									$("#select" + i+"3").append("<option value='"+val.substr(3,val.length-3)+"'>"+val+"</option>");
								}
								$("#suggest" + i).hide();
								oldContent = "";
							});
						},
						error : function() {
							// alert("Ajax请求出错");
						}
					});
				});
	}
}
