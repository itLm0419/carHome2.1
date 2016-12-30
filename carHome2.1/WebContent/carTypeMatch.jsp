<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.min.js">
</script>
<script type="text/javascript" src="js/search.js">
</script>
<script type="text/javascript">
function submitForm1(){
	$('select > option').attr('selected','selected');
	return true ;
}
</script>
<style type="text/css">
.keyword {
	width: 180px;
}
</style>
</head>
<body>
<s:debug></s:debug>
	<h1>车型产品匹配</h1>
	<form action="MatchAction_submitMatching" method="post">
		<s:iterator value="matchModels" status="st">
		<input type="hidden" name="matchModels[<s:property value="#st.index"/>].carType.id" value="${carType.id}"/>
			<h2>${carType.name }</h2>
			<div id="searchDiv<s:property value="#st.index+1"/>">
				<input id="content<s:property value="#st.index+1"/>" type="text" />
				<div id="suggest<s:property value="#st.index+1"/>"></div>
				<select style="width: 150px" multiple="multiple"
					name="matchModels[<s:property value="#st.index"/>].firstApplyProductsTypeNums"
					id="select<s:property value="#st.index+1"/>1">
					<s:iterator value="applyProducts">
						<s:if test="name == '曼牌'">
							<option value="${typeNum }" >曼牌${typeNum}</option>
						</s:if>
					</s:iterator>
				</select> <select style="width: 150px" multiple="multiple"
					name="matchModels[<s:property value="#st.index"/>].secondApplyProductsTypeNums"
					id="select<s:property value="#st.index+1"/>2">
					<s:iterator value="applyProducts">
						<s:if test="name == '马勒'">
							<option value="${typeNum }" >马勒${typeNum}</option>
						</s:if>
					</s:iterator>
				</select> 
				<select style="width: 150px" multiple="multiple"
					name="matchModels[<s:property value="#st.index"/>].thirdApplyProductsTypeNums"
					id="select<s:property value="#st.index+1"/>3">
					<s:iterator value="applyProducts">
						<s:if test="name == '科德宝'">
							<option value="${typeNum }">科德宝${typeNum}</option>
						</s:if>
					</s:iterator>
				</select>
			</div>
		</s:iterator>
		<input type="submit" value="提交更改" onclick="return submitForm1()"/>
	</form>
</body>
</html>