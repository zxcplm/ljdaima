<%@ page language="java" contentType="text/html; charset=UTF-8"
  import="java.util.List,com.lijin.model.Stu"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String  cpath=request.getContextPath();
out.println("cpath-->"+cpath);
%>
<center>
<video  id="videoone"  ></video>
<table  border="1">
<tr>
<th>学生编号</th>
<th>学生姓名</th>
<th>学生密码</th>
<th>学生性别</th>
<th>学生状态</th>
<th>手机号码</th>
<th>学生qq号</th>
<th>学生职务</th>
<th>学生班级</th>
<th>学生头像</th>
<th>学生视频</th>
<th>操作</th>
</tr>
<%
List<Stu>   stuLists=(List<Stu> )request.getAttribute("studatas");

for(Stu s :stuLists)
{
%>

<tr>
<td><%=s.getSid() %></td>
<td><%=s.getSname() %></td>
<td><%=s.getSpwd() %></td>
<td><%=s.getSsex() %></td>
<td><%=s.getState() %></td>
<td><%=s.getSphone() %></td>
<td><%=s.getSqq() %></td>
<td><%=s.getSjob() %></td>
<td><a href="classes?action=queryclassToStu&classstu=<%=s.getScname()%>"><%=s.getScname()%></a></td>
<td><img src="<%=cpath+s.getStuimg()%>"></img></td>
<td>
<%
   if("".equals(s.getStudesc())||null==s.getStudesc())
   {
%>	 
<button  onclick="play('<%=cpath%>/video/a3.mp3')"><%=s.getSname() %>默认音频 </button>
<% 
   }else{
%>
<button  onclick="play('<%=cpath+s.getStudesc() %>')"><%=s.getSname() %>视频
</button>
<%} %>

</td>
<td>
<a href="stus?action=deleteStu&stuid=<%=s.getSid()%>">删除</a>|<a href="<%=cpath%>/stu/stu_updatepwd.jsp?stupwd=<%=s.getSpwd()%>&stuid=<%=s.getSid()%>">更新<%=s.getSname() %>密码</a>
</td>
</tr>

<%} %>
</table>
</center>


</body>


<script type="text/javascript">
function  play(path)
{
   alert(path);	
   
   if(path!="")
   {
	   alert("进来");
	 var  videoObj=  document.getElementById("videoone");
	 videoObj.controls="controls";
	 videoObj.width=500;
	 videoObj.height=500;
	 videoObj.src=path;
	 videoObj.play();
   }
   
   
}


</script>

</html>