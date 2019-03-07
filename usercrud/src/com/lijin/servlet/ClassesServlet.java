package com.lijin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lijin.db.DB;
import com.lijin.model.Classstu;


public class ClassesServlet extends  HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ClassesServlet  is  doGet  start... ");
		
		//防止乱码
		req.setCharacterEncoding("UTF-8");
		
		// 获取参数信息
		String actionName = req.getParameter("action");

		System.out.println("actionName-->" + actionName);
				
		if (actionName.equals("queryclassToStu")) 
		{
			System.out.println("获取各个班级所学课程的名称");
					
			//获取参数
			String cname = req.getParameter("classstu");

			System.out.println("cname--->" + cname);
			
			DB db = new DB();
			
			List<Classstu> classstuLists = db.selectClassstuById(cname);
			
			// 使用req对象设置保存数据，以便在目标页面遍历
			req.setAttribute("classstudatas", classstuLists);
					
			// 跳转页面
			req.getRequestDispatcher("stu/stu_classstu.jsp").forward(req, resp);

		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	

}
