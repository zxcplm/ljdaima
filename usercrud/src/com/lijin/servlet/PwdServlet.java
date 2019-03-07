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
		
		//��ֹ����
		req.setCharacterEncoding("UTF-8");
		
		// ��ȡ������Ϣ
		String actionName = req.getParameter("action");

		System.out.println("actionName-->" + actionName);
		
        if (actionName.equals("updatepwd")) {
			
			System.out.println("����������");			
			//��ȡ����
			String pwd1 = req.getParameter("newpwd1");			
			System.out.println("����������--->" + pwd1);
			
			
			
			System.out.println("ȷ��������");			
			//��ȡ����
			String pwd2 = req.getParameter("newpwd2");			
			System.out.println("ȷ��������--->" + pwd2);
			
			
			
            System.out.println("�޸�����");			
			//��ȡ����
			String stid = req.getParameter("stuid");			
			System.out.println("�޸�����--->" + stid);
			
				
            DB db = new DB();
				
			db.updatepwdById(stid,pwd2);
				
			db  =new DB();
			List<Stu> stuslist = db.queryStuAll();
				
			// ʹ��req�������ñ������ݣ��Ա���Ŀ��ҳ�����
			req.setAttribute("studatas", stuslist);
				
			req.getRequestDispatcher("stu/stu_info.jsp").forward(req, resp);
				
		
		}
	
	}

}
