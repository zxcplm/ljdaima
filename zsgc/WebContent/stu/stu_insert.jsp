<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/stus?action=insert" method="post" name="form1" onsubmit="return check()">
用户名：<input type="text"  name="name" placeholder="请输入用户名:">
密码：<input type="text"  name="pwd" placeholder="请输入密码:">
性别：<input type="text"  name="sex" placeholder="请输入性别:">
年龄：<input type="text"  name="age" placeholder="请输入年龄:">
<input  type="submit" value="提交" >
</form>
</body>

<script type="text/javascript">

function  check()
{
	if (document.form1.name.value=="")
		{
		    alert("请输入用户名！");
		    return  false;
		}
	else if (document.form1.pwd.value=="")
		{
		    alert("请输入密码！");
		    return false;
		}
	else if (document.form1.sex.value=="")
		{
		    alert("请输入性别！");
		    return  false;
		}
	else if (document.form1.age.value=="")
		{
		    alert("请输入年龄");
		    return false;
		}
	
	else{
		return  true;
	}
}

</script>

</html>