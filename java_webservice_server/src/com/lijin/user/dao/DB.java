package com.lijin.user.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lijin.model.Menu;
import com.lijin.model.Role;
import com.lijin.model.StuAndRole;

public interface DB {
	
	public List queryRoleData();

	public List queryRoleGroupCount() ;

	public String queryStuAndkmCount(String stuName) ;
	
	public int checkUserLogin(String name, String pwd) ;

	public List<Menu> queryMenuData() ;
	
	public  List  queryClassToStuCount();
	
	public List queryNameCount() ;

}
