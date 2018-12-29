package com.lijin.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lijin.file.FilePropertiesUtils;
import com.lijin.model.Data;
import com.lijin.model.Menu;
import com.lijin.model.Role;
import com.lijin.model.StuAndRole;

public class DBMysql   implements  DB {

	static String  urlimg="";
	
	
	static
	{
		urlimg=FilePropertiesUtils.getImageUtilPath();
	}
	private Connection conn;

	public DBMysql() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/db_nkj", "root", "123456");

			System.out.println("mysql���ݿ����ӳɹ�"+conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List queryRoleData() {
		String sql = "SELECT  *  FROM   t_role";

		List<Role> lists = new ArrayList<Role>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Role role = new Role();
				role.setRid(rs.getInt(1));
				role.setRname(rs.getString(2));

				lists.add(role);
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

	public List queryRoleGroupCount() {
		String sql = "SELECT  rname,COUNT(sjob)    FROM  t_stus  RIGHT  JOIN  t_role ON sjob=rid  GROUP BY  rname";

		List<StuAndRole> lists = new ArrayList<StuAndRole>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				StuAndRole crole = new StuAndRole();
				crole.setRname(rs.getString(1));
				crole.setRcount(rs.getInt(2));

				lists.add(crole);
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

	public String queryStuAndkmCount(String stuName) {
		String sql = "SELECT COUNT(kid),sname  FROM (SELECT   * FROM  t_stus  WHERE  sname=?) tmp INNER  JOIN  "
				+ " t_score  ON tmp.sid=t_score.sid  GROUP  BY sname";

		String data = "";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stuName);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				data = rs.getInt(1) + "," + rs.getString(2);
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

		return data;
	}

	public int checkUserLogin(String name, String pwd) {
		String sql = "SELECT  COUNT(*) FROM  t_stus  WHERE sname=? AND  spwd=?";

		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				return rs.getInt(1);
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
		return 0;

	}

	public List<Menu> queryMenuData() {
		String sql = "SELECT  * FROM  t_menu";

		List<Menu> listMenu = new ArrayList<Menu>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Menu menu = new Menu();
				menu.setTid(rs.getInt(1));
				menu.setTname(rs.getString(2));
				menu.setTurl(rs.getString(4));
				menu.setImgpath(urlimg+rs.getString(6));
				listMenu.add(menu);
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
		
		return  listMenu;

	}

	@Override
	public List queryClassToStuCount() {
		
		// TODO Auto-generated method stub
		
		System.out.println("DBMysql  is   queryClassToStuCount");
		String sql = "SELECT  cname,COUNT(sname)   FROM  t_classes  c INNER  JOIN t_stus s " +
				"ON c.cid= s.scid  GROUP  BY  cname ";

		List<Data> listData = new ArrayList<Data>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Data data = new Data();
				data.setName(rs.getString(1));
				data.setCount(rs.getInt(2));
		
				listData.add(data);
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
		
		return  listData;
	}

	@Override
	public List queryNameCount() {
		// TODO Auto-generated method stub
		System.out.println("DBMysql  is   queryNameCount");
		
		String sql="SELECT  FORMAT(COUNT(*)/(SELECT  COUNT(*) FROM t_stus),1), SUBSTR(sname,1,1) FROM  t_stus  GROUP  BY  SUBSTR(sname,1,1)";
		
		List<Data> listData = new ArrayList<Data>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Data data = new Data();
				data.setCount(rs.getDouble(1));
				data.setName(rs.getString(2));
			
		
				listData.add(data);
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
		
		return  listData;
	
	}

}

