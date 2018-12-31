package com.lijin.user.service.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService(targetNamespace="http://thzm.com/wsdl")
public interface IUserService {
	
	//查询角色的数据
	@WebMethod
	public String  queryRoleData();
	
	
	// 找出学生表各个职务的学生数量和职务名称
	@WebMethod
	public String  queryGroupByRoleCount();
	
	//-- **学生所学课程的数量
	@WebMethod
	public String  queryStuAndkmCount(String name);
	
	//检查登录        2018.12.24新增
	@WebMethod
	public String checkUserLogin(String  username,String  pwd);

	//数据菜单        2018.12.25新增
	@WebMethod
	public String   queryGirdMenuData();
	
	//查询每个班级的学生的数量
	public  String  queryClassToStuCount();	
	
	//学生姓氏的部分 
	public  String   queryNameCount();
	
	//学生性别
	public  String   querySexCount();
	
	//学生地址
	public  String   queryAddressCount();
	
	//学生年龄
	public  String   queryAgeCount();
	
}
