package com.lijin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lijin.db.DB;
import com.lijin.model.Stu;

public class StuServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("StuServlet is doGet start...");
		
		//防止乱码
		req.setCharacterEncoding("UTF-8");
		
		//获取参数信息
		String actionName=req.getParameter("action");
		
		System.out.println("actionName----->"+actionName);
		
		if(actionName.equals("queryall"))
		{
			System.out.println("用户登录");
			
			DB  db=new DB();
			
			List<Stu> stuslist=db.querystuall();		
			
			// 使用req对象设置保存数据，以便在目标页面遍历
			req.setAttribute("studatas", stuslist);
			
			// 跳转页面
			req.getRequestDispatcher("stu/stu_xingxi.jsp").forward(req, resp);
		}
		else if(actionName.equals("queryone"))
		{
			System.out.println("删除学生");
			String  i=req.getParameter("id");
			
			System.out.println("id是-->"+i);
			
			DB  db=new DB();
			
			db.deletestu(i);
			
			db  =new DB();
			List<Stu> stuslist = db.querystuall();
			
			// 使用req对象设置保存数据，以便在目标页面遍历
			req.setAttribute("studatas", stuslist);
			
			req.getRequestDispatcher("stu/stu_xingxi.jsp").forward(req, resp);
			
		}
		else if(actionName.equals("querypwd"))
		{
			System.out.println("更新密码");
			
			// 获取参数
			String pwd1=req.getParameter("newpwd1");
			String pwd=req.getParameter("newpwd2");
			String id=req.getParameter("id");
			
			System.out.println("id--->"+id);
			System.out.println("newpwd2--->"+pwd);
			System.out.println("newpwd1--->"+pwd1);
			
			DB db=new DB();
			
			db.updatestu(id, pwd);
			
			db = new DB();
			
            List<Stu> stuslist = db.querystuall();
			
			// 使用req对象设置保存数据，以便在目标页面遍历
			req.setAttribute("studatas", stuslist);
			
			//页面跳转
			req.getRequestDispatcher("stu/stu_xingxi.jsp").forward(req, resp);
		}
		else if(actionName.equals("insert"))
		{
			System.out.println("添加用户");	
			
			String  name=req.getParameter("name");
			String  pwd=req.getParameter("pwd");
			String  sex=req.getParameter("sex");
			String  age=req.getParameter("age");
			
			System.out.println("姓名---->"+name);
			System.out.println("密码---->"+pwd);
			System.out.println("性别---->"+sex);
			System.out.println("年龄---->"+age);
			
			DB db=new DB();
			db.insertstu(name, pwd, sex, age);
			
			db=new DB();
			
		    List<Stu> stuslist = db.querystuall();
				
			// 使用req对象设置保存数据，以便在目标页面遍历
			req.setAttribute("studatas", stuslist);
				
			//页面跳转
			req.getRequestDispatcher("stu/stu_xingxi.jsp").forward(req, resp);
			
		}
		else if(actionName.equals("select"))
		{
			System.out.println("查询用户");
			
			String age=req.getParameter("age");
			System.out.println("年龄---->"+age);
			
			DB db =new DB();		
			
		    List slist=db.selectstu(age);
			
			req.setAttribute("sdatas", slist);
			
			req.getRequestDispatcher("stu/stu_select.jsp").forward(req, resp);
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	

}
