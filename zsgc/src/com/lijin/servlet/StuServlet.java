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
		
		//��ֹ����
		req.setCharacterEncoding("UTF-8");
		
		//��ȡ������Ϣ
		String actionName=req.getParameter("action");
		
		System.out.println("actionName----->"+actionName);
		
		if(actionName.equals("queryall"))
		{
			System.out.println("�û���¼");
			
			DB  db=new DB();
			
			List<Stu> stuslist=db.querystuall();		
			
			// ʹ��req�������ñ������ݣ��Ա���Ŀ��ҳ�����
			req.setAttribute("studatas", stuslist);
			
			// ��תҳ��
			req.getRequestDispatcher("stu/stu_xingxi.jsp").forward(req, resp);
		}
		else if(actionName.equals("queryone"))
		{
			System.out.println("ɾ��ѧ��");
			String  i=req.getParameter("id");
			
			System.out.println("id��-->"+i);
			
			DB  db=new DB();
			
			db.deletestu(i);
			
			db  =new DB();
			List<Stu> stuslist = db.querystuall();
			
			// ʹ��req�������ñ������ݣ��Ա���Ŀ��ҳ�����
			req.setAttribute("studatas", stuslist);
			
			req.getRequestDispatcher("stu/stu_xingxi.jsp").forward(req, resp);
			
		}
		else if(actionName.equals("querypwd"))
		{
			System.out.println("��������");
			
			// ��ȡ����
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
			
			// ʹ��req�������ñ������ݣ��Ա���Ŀ��ҳ�����
			req.setAttribute("studatas", stuslist);
			
			//ҳ����ת
			req.getRequestDispatcher("stu/stu_xingxi.jsp").forward(req, resp);
		}
		else if(actionName.equals("insert"))
		{
			System.out.println("����û�");	
			
			String  name=req.getParameter("name");
			String  pwd=req.getParameter("pwd");
			String  sex=req.getParameter("sex");
			String  age=req.getParameter("age");
			
			System.out.println("����---->"+name);
			System.out.println("����---->"+pwd);
			System.out.println("�Ա�---->"+sex);
			System.out.println("����---->"+age);
			
			DB db=new DB();
			db.insertstu(name, pwd, sex, age);
			
			db=new DB();
			
		    List<Stu> stuslist = db.querystuall();
				
			// ʹ��req�������ñ������ݣ��Ա���Ŀ��ҳ�����
			req.setAttribute("studatas", stuslist);
				
			//ҳ����ת
			req.getRequestDispatcher("stu/stu_xingxi.jsp").forward(req, resp);
			
		}
		else if(actionName.equals("select"))
		{
			System.out.println("��ѯ�û�");
			
			String age=req.getParameter("age");
			System.out.println("����---->"+age);
			
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
