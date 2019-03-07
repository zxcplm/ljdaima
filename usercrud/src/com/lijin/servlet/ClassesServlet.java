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
		
		//��ֹ����
		req.setCharacterEncoding("UTF-8");
		
		// ��ȡ������Ϣ
		String actionName = req.getParameter("action");

		System.out.println("actionName-->" + actionName);
				
		if (actionName.equals("queryclassToStu")) 
		{
			System.out.println("��ȡ�����༶��ѧ�γ̵�����");
					
			//��ȡ����
			String cname = req.getParameter("classstu");

			System.out.println("cname--->" + cname);
			
			DB db = new DB();
			
			List<Classstu> classstuLists = db.selectClassstuById(cname);
			
			// ʹ��req�������ñ������ݣ��Ա���Ŀ��ҳ�����
			req.setAttribute("classstudatas", classstuLists);
					
			// ��תҳ��
			req.getRequestDispatcher("stu/stu_classstu.jsp").forward(req, resp);

		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	

}
