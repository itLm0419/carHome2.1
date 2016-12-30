<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script type="text/javascript"
	src="jQuery-Autocomplete-master/scripts/demo.js">
	
</script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js">
	
</script>
<script type="text/javascript" src="js/jquery.autocomplete.js">
	
</script>
<script type="text/javascript"
	src="jQuery-Autocomplete-master/scripts/jquery.mockjax.js">
	
</script>
</head>

<body>
	<input type="text" name="country" id="autocomplete" />
	<script type="text/javascript">

		$('#autocomplete').autocomplete(
				{
					serviceUrl : 'AdminProductAction_test',
					transformResult : function(response) {
						//解析服务器传过来的json字符串
						var obj = $.parseJSON(response);
						alert(obj);
						return {
							suggestions : $.map(obj.list, function(dataItem) {
								return {
									value : dataItem.right,
									data : dataItem.left
								};
							})
						};
					},
					onSelect : function(suggestion) {
						alert('You selected: ' + suggestion.value + ', '
								+ suggestion.data);
					}
				});
	</script>
</body>
</html>
