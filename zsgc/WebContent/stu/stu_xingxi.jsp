<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.List,com.lijin.model.Stu"   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<center>

<table border="1">

<tr>
<th>学生编号</th>
<th>学生姓名</th>
<th>学生密码</th>
<th>学生性别</th>
<th>学生年龄</th>
<th>操作</th>
</tr>

<%
List<Stu> stulists=(List<Stu>)request.getAttribute("studatas");

for(Stu s : stulists)

{

%>

<tr>
<td><%=s.getOid() %></td>
<td><%=s.getOname() %></td>
<td><%=s.getOpwd() %></td>
<td><%=s.getOsex() %></td>
<td><a href="stus?action=select&age=<%=s.getOage() %>"><%=s.getOage() %></a></td>
<td>
<a href="<%=request.getContextPath() %>/stu/stu_updatepwd.jsp?stuname=<%=s.getOname()%>&stupwd=<%=s.getOpwd()%>&stuid=<%=s.getOid()%>">更新</a>|<a href="stus?action=queryone&id=<%=s.getOid()%>" name="delete" onclick="return check()">删除</a>
</td>
</tr>

<%} %>
</table>

<input type="button" value="添加用户" onclick="window.location.href='<%=request.getContextPath() %>/stu/stu_insert.jsp';"/>
</center>

</body>

<script type="text/javascript">

function check()
{
  alert("确定删除吗？")
}

</script>

</html>