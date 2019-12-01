<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>分页显示</title>
</head>
<body>
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
    	<c:forEach items="${pageBean.list}" var="stu">
		
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
		<tr>
			<td colspan="8">
				第${pageBean.currentPage}/${pageBean.totalPage}页
				每页显示${pageBean.pageSize}条
				总记录 ${pageBean.totalSize}条
				<c:if test="${pageBean.currentPage!=1}"><a href="studiv?currentPage=1">首页</a> <a href="studiv?currentPage=${pageBean.currentPage-1}">上一页</a> &nbsp;</c:if>	
				<c:if test="${pageBean.currentPage==1}">
						1
						<a href="studiv?currentPage=2">2</a>
						<a href="studiv?currentPage=3">3</a>
				</c:if>
				<c:if test="${pageBean.currentPage>1&&pageBean.currentPage<pageBean.totalPage}">
				<c:forEach begin="${pageBean.currentPage-1}" end="${pageBean.currentPage+1}" var="page">
					<c:if test="${pageBean.currentPage==page}">
						${page}
					</c:if>
					<c:if test="${pageBean.currentPage!=page}">
						<a href="studiv?currentPage=${page}">${page}</a>
					</c:if>
					
				</c:forEach>
				</c:if>
				<c:if test="${pageBean.currentPage==pageBean.totalPage}">
						<a href="studiv?currentPage=${pageBean.totalPage-2}">${pageBean.totalPage-2}</a>
						<a href="studiv?currentPage=${pageBean.totalPage-1}">${pageBean.totalPage-1}</a>
						${pageBean.totalPage}
				</c:if>
				<c:if test="${pageBean.currentPage!=pageBean.totalPage}"><a href="studiv?currentPage=${pageBean.currentPage+1}">下一页</a>&nbsp;<a href="studiv?currentPage=${pageBean.totalPage}">尾页</a></c:if>
			</td>
		</tr>
		
    </table>
</body>
</html>