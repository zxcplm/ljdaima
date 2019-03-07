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
		
		// ��ȡ������Ϣ
		String actionName = req.getParameter("action");

		System.out.println("actionName-->" + actionName);
		
		if (actionName.equals("queryallstu")) 
		{
			System.out.println("��ѯѧ����������Ϣ");

			DB db = new DB();
			List<Stu> stuslist = db.queryStuAll();
 
			
			// ʹ��req�������ñ������ݣ��Ա���Ŀ��ҳ�����
			req.setAttribute("studatas", stuslist);
			
			// ��תҳ��
			req.getRequestDispatcher("stu/stu_info.jsp").forward(req, resp);

		} else if (actionName.equals("queryallkm")) {
			
			System.out.println("��ѯѧ������ѧ�γ���Ϣ");
			
			DB db = new DB();
			List<Stu> classlist = db.queryStuAll();
			
			// ʹ��req�������ñ������ݣ��Ա���Ŀ��ҳ�����
			req.setAttribute("classdatas", classlist);
			
			// ��תҳ��
			req.getRequestDispatcher("stu/stu_class.jsp").forward(req, resp);
			
		} else if (actionName.equals("deleteStu")) {
			System.out.println("ɾ��ѧ��");
			String id = req.getParameter("stuid");

			System.out.println("id--->" + id);		
			
			DB db = new DB();
			System.out.println("before-------db���ڴ��ַΪ:"+db);
			db.deleteStuById(id);
			//System.out.println("after************db���ڴ��ַΪ:"+db);
			//List<Stu> stuslist = db.queryStuAll();
			db  =new DB();
			List<Stu> stuslist = db.queryStuAll();
			System.out.println("after********db���ڴ��ַΪ:"+db);
			
			// ʹ��req�������ñ������ݣ��Ա���Ŀ��ҳ�����
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
