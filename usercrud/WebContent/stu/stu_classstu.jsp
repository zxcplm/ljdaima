<%@ page language="java" contentType="text/html; charset=UTF-8"
   import="java.util.List,com.lijin.model.Classstu"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<center>

<table  border="1">
<tr>
<th>学生编号</th>
<th>学生姓名</th>
<th>学生班级</th>
</tr>
<%
List<Classstu>   classstuLists=(List<Classstu> )request.getAttribute("classstudatas");

for(Classstu c :classstuLists)
{
%>

<tr>
<td><%=c.getSid() %></td>
<td><%=c.getSname() %></td>
<td><%=c.getCname()%></a></td>
</tr>

<%} %>
</table>
</center>

</body>
</html>