package com.lijin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lijin.db.DB;
import com.lijin.model.Stu;

public class PwdServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
        System.out.println("PwdServlet  is  doPost  start... ");
		
		//防止乱码
		req.setCharacterEncoding("UTF-8");
		
		// 获取参数信息
		String actionName = req.getParameter("action");

		System.out.println("actionName-->" + actionName);
		
        if (actionName.equals("updatepwd")) {
			
			System.out.println("输入新密码");			
			//获取参数
			String pwd1 = req.getParameter("newpwd1");			
			System.out.println("输入新密码--->" + pwd1);
			
			
			
			System.out.println("确认新密码");			
			//获取参数
			String pwd2 = req.getParameter("newpwd2");			
			System.out.println("确认新密码--->" + pwd2);
			
			
			
            System.out.println("修改密码");			
			//获取参数
			String stid = req.getParameter("stuid");			
			System.out.println("修改密码--->" + stid);
			
				
            DB db = new DB();
				
			db.updatepwdById(stid,pwd2);
				
			db  =new DB();
			List<Stu> stuslist = db.queryStuAll();
				
			// 使用req对象设置保存数据，以便在目标页面遍历
			req.setAttribute("studatas", stuslist);
				
			req.getRequestDispatcher("stu/stu_info.jsp").forward(req, resp);
				
		
		}
	
	}

}
