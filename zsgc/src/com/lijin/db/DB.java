package com.lijin.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.lijin.model.Stu;

public class DB {
	
	private  Connection  conn;
	
	public DB()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lianxi","root","123456");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  List  querystuall()
	{
		String sql="SELECT  oid,oname,opwd,osex,oage  FROM  t_one";
		
		List<Stu> lists=new ArrayList<Stu>();
		
		try {
			
			PreparedStatement  pstmt=conn.prepareStatement(sql);
			
			ResultSet rs =pstmt.executeQuery();
			
			while(rs.next())
			{
				Stu s = new Stu();
				s.setOid(rs.getInt(1));
				s.setOname(rs.getString(2));
				s.setOpwd(rs.getString(3));
				s.setOsex(rs.getString(4));
				s.setOage(rs.getString(5));
				
				lists.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return  lists;
	}
	
	public  int  deletestu(String id)
	{
		String sql="DELETE FROM t_one WHERE oid=?";
		
		int count=0;
		
		try {
			PreparedStatement  pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
			System.out.println("删除成功---->"+id);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
		
	}
	
	public  int  updatestu(String id,String pwd)
	{
		String sql="UPDATE  t_one  SET opwd=? WHERE oid=?";
		
		int count=0;
		
		try {
			PreparedStatement  pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, pwd);
			pstmt.setString(2, id);
			
			pstmt.executeUpdate();
			
			System.out.println("更新成功----->"+pwd);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return  count;
	}
	
	public  String  insertstu(String name,String pwd,String sex,String age)
	{
		String sql=" INSERT INTO  t_one(oname,opwd,osex,oage) VALUES (?,?,?,?)";	
		
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			pstmt.setString(3, sex);
			pstmt.setString(4, age);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sql;	
		
	}
	
	public List selectstu(String age)
	{
		String sql="SELECT oid,oname,opwd,osex,oage FROM t_one WHERE oage=?";
		
		List<Stu> lists=new ArrayList<Stu>();
		
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, age);
			
            ResultSet  rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				Stu s = new Stu();
				s.setOid(rs.getInt(1));
				s.setOname(rs.getString(2));
				s.setOpwd(rs.getString(3));
				s.setOsex(rs.getString(4));
				s.setOage(rs.getString(5));
				
				lists.add(s);
				
			}
			
			System.out.println("查询成功-->"+age);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
			
	}

}
