<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.List,com.lijin.model.Stu"  pageEncoding="UTF-8"%>
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
</tr>

<%
List<Stu> slists=(List<Stu>)request.getAttribute("sdatas");

for(Stu s : slists)

{

%>

<tr>
<td><%=s.getOid() %></td>
<td><%=s.getOname() %></td>
<td><%=s.getOpwd() %></td>
<td><%=s.getOsex() %></td>
<td><%=s.getOage() %></td>
</tr>

<%} %>
</table>

</center>
</body>
</html>