package com.lijin.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lijin.model.Stu;
import com.lijin.model.Classstu;

public class DB {
	
	private Connection conn;

	public DB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_nkj", "root", "123456");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List queryStuAll() {
		String sql = "SELECT  tmp.sid,tmp.sname, tmp.spwd,tmp.ssex,tmp.state, "
				+ "tmp.sphone,tmp.sqq,tmp.rname,c.cname,tmp.stuimg,tmp.studesc "
				+ "  FROM (SELECT   s.sid,s.sname, s.spwd,s.ssex,s.state, s.sphone,s.sqq,r.rname,s.scid,s.stuimg,s.studesc FROM   t_stus  s   INNER  JOIN  t_role  r ON s.sjob=r.rid)  tmp INNER    JOIN   t_classes  c ON "
				+ "tmp.scid=c.cid";

		List<Stu> lists = new ArrayList<Stu>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Stu s = new Stu();
				s.setSid(rs.getInt(1));
				s.setSname(rs.getString(2));
				s.setSpwd(rs.getString(3));
				s.setSsex(rs.getString(4));
				s.setState(rs.getInt(5));
				s.setSphone(rs.getString(6));
				s.setSqq(rs.getString(7));
				s.setSjob(rs.getString(8));
				s.setScname(rs.getString(9));
				s.setStuimg(rs.getString(10));
				
				s.setStudesc(rs.getString(11));
				lists.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return lists;
	}
	
	public  int deleteStuById(String id)
	{
		String sql="DELETE  FROM   t_stus  WHERE sid=?  ";
		  
		int  count=0;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			pstmt.executeUpdate(); 
			 
			System.out.println("删除成功。。。。。。。。。"+id);
			
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
		
		return  count;
		
	}
	
	public List selectClassstuById(String cname)
	{
		String sql="SELECT  s.sid,s.sname,c.cname  FROM   t_stus  s INNER   JOIN  t_classes   c  ON  s.scid=c.cid WHERE c.cname=? ";
		
		List<Classstu> lists = new ArrayList<Classstu>();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cname);
			
			ResultSet  rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				Classstu s = new Classstu();
				s.setSid(rs.getInt(1));
				s.setSname(rs.getString(2));
				s.setCname(rs.getString(3));
				
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
		
	 return lists;
		
	}
	
	public  int updatepwdById(String id,String pwd)
	{
		String sql="UPDATE  t_stus  SET  spwd=? WHERE sid=?  ";
		  
		int  count=0;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pwd);
			
            pstmt.setString(2, id);
			
			pstmt.executeUpdate(); 
			 
			System.out.println("更改成功。。。。。。。。。"+pwd);
			
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
		
		return  count;
		
	}


}
