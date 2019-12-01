<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生查询页面</title>
</head>
<body >
    <table border="1" width="700">
   		<tr align=><td colspan="8"> 
   		<form action="select" method="post">
   		按姓名查询 :<input type="text" name="name" size=20> 
   		按性别查询 ：<select name="sex">
   					<option value="">--请选择---</option>
   					<option value="男">男</option>
   					<option value="女">女</option>
   				</select>
   				<input type="submit" value="查询" >
   				<a href="stuadd.jsp">添加</a>
   		</form>
   		</td></tr>
   		
    	<tr align="center">
    		<td width="10%">编号</td>
    		<td width="10%">姓名</td>
    		<td width="10%">性别</td>
    		<td width="10%">电话</td>
    		<td width="20%">生日</td>
    		<td width="10%">爱好</td>
    		<td width="10%">信息</td>
    		<td width="20%">操作</td>
    	</tr>
    	<c:forEach items="${stu}" var="stu">
		
			<c:if test=""></c:if>
			<tr align="center">
				<td>${stu.id}</td>
				<td>${stu.name}</td>
				<td>${stu.sex}</td>
				<td>${stu.phone}</td>
				<td>${stu.birthday}</td>
				<td>${stu.habby}</td>
				<td>${stu.info }</td>
				<td><a href="stuupdate?id=${stu.id}">更新</a>   <a href="studel?id=${stu.id}">删除</a></td>
			</tr>
		</c:forEach>
    </table>
</body>
</html>