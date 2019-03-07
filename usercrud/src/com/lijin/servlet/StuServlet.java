package com.lijin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lijin.db.DB;
import com.lijin.model.Stu;

public class StuServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("StuServlet  is  doGet  start... ");
		
		// 获取参数信息
		String actionName = req.getParameter("action");

		System.out.println("actionName-->" + actionName);
		
		if (actionName.equals("queryallstu")) 
		{
			System.out.println("查询学生的所有信息");

			DB db = new DB();
			List<Stu> stuslist = db.queryStuAll();
 
			
			// 使用req对象设置保存数据，以便在目标页面遍历
			req.setAttribute("studatas", stuslist);
			
			// 跳转页面
			req.getRequestDispatcher("stu/stu_info.jsp").forward(req, resp);

		} else if (actionName.equals("queryallkm")) {
			
			System.out.println("查询学生的所学课程信息");
			
			DB db = new DB();
			List<Stu> classlist = db.queryStuAll();
			
			// 使用req对象设置保存数据，以便在目标页面遍历
			req.setAttribute("classdatas", classlist);
			
			// 跳转页面
			req.getRequestDispatcher("stu/stu_class.jsp").forward(req, resp);
			
		} else if (actionName.equals("deleteStu")) {
			System.out.println("删除学生");
			String id = req.getParameter("stuid");

			System.out.println("id--->" + id);		
			
			DB db = new DB();
			System.out.println("before-------db的内存地址为:"+db);
			db.deleteStuById(id);
			//System.out.println("after************db的内存地址为:"+db);
			//List<Stu> stuslist = db.queryStuAll();
			db  =new DB();
			List<Stu> stuslist = db.queryStuAll();
			System.out.println("after********db的内存地址为:"+db);
			
			// 使用req对象设置保存数据，以便在目标页面遍历
			req.setAttribute("studatas", stuslist);
			
			req.getRequestDispatcher("stu/stu_info.jsp").forward(req, resp);
			
			
		} 

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	

}
