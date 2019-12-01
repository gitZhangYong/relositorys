<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新页面</title>
</head>
<body>
	<form action="stuupdate" method="post">
			<input type="hidden" name="id"  value=${stu.id}>
		姓名 ：<input type="text" name="name" value=${stu.name}><br>	
		性别 ：<input type="radio" name="sex" value="男" <c:if test="${stu.sex=='男'}">checked</c:if>	>男
			<input type="radio" name="sex" value="女" <c:if test="${stu.sex=='女'}">checked</c:if>>女	<br>
		手机 ：<input type="text" name="phone" value=${stu.phone}><br>	
		生日 ：<input type="date" name="birthday"  value=${stu.birthday}><br>	
		爱好 ：<input type="checkbox" name="habby" value="唱" 	<c:if test="${fn:contains({stu.habby},'唱') }">checked</c:if>	>唱
			 <input type="checkbox" name="habby" value="跳"  <c:if test="${fn:contains({stu.habby},'跳') }">checked</c:if>>跳
			 <input type="checkbox" name="habby"  value="rap" <c:if test="${fn:contains({stu.habby},'rap') }">checked</c:if>>rap
			 <input type="checkbox" name="habby"  value="篮球" <c:if test="${fn:contains({stu.habby},'篮球') }">checked</c:if>>篮球
			 <input type="checkbox" name="habby"  value="music"<c:if test="${fn:contains({stu.habby},'music') }">checked</c:if>>music
		<br>	
		信息 ：<textarea  rows="3"  cols="20" name="info" >${stu.info}</textarea>
		<br>	
		<input type="submit" value="提交">
		<input type="reset" value="重置">
		
	</form>
</body>
</html>