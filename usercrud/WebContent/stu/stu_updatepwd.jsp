<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<center>

<form action="<%=request.getContextPath() %>/pwds?action=updatepwd" method="post" name="form1">
原密码:<input  type="text"  value="<%=request.getParameter("stupwd")%>"> 
新密码:<input  type="text"  name="newpwd1" placeholder="请输入新密码:">
确认新密码:<input  type="text" name="newpwd2" placeholder="确认新密码:">
<input  type="hidden"  name="stuid" value="<%=request.getParameter("stuid")%>">
<input  type="submit" value="修改密码" onclick="return check1()">
</form>

</center>

</body>

<script type="text/javascript"> 
function check1()
{
  if (document.form1.newpwd1.value==""){
  alert("请输入用户密码");
  return false;
}
if (document.form1.newpwd2.value==""){
  alert("请输入确认密码!");
  return false;
}
if (document.form1.newpwd1.value!=document.form1.newpwd2.value){
  alert("对不起!密码不一致");
  return false;
}
  return true; 
}
</script> 

</html>