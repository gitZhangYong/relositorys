<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加页面</title>
</head>
<body>
	<form action="stuadd" method="post">
		姓名 ：<input type="text" name="name" ><br>	
		性别 ：<input type="radio" name="sex" value="男" checked="checked">男  &nbsp
		<input type="radio" name="sex" value="女" >女	<br>
		手机 ：<input type="text" name="phone" ><br>	
		生日 ：<input type="date" name="birthday" ><br>	
		爱好 ：<input type="checkbox" name="habby" value="唱" >唱
			 <input type="checkbox" name="habby" value="跳">跳
			 <input type="checkbox" name="habby"  value="rap">rap
			 <input type="checkbox" name="habby"  value="篮球">篮球
			 <input type="checkbox" name="habby"  value="music">music
		<br>	
		信息 ：<textarea  rows="3"  cols="20" name="info" ></textarea>
		<br>	
		<input type="submit" value="提交">
		<input type="reset" value="重置">
		
	</form>
</body>
</html>