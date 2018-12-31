package com.lijin.user.service.impl;

import java.util.List;

import javax.jws.WebService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lijin.model.Data;
import com.lijin.model.Menu;
import com.lijin.model.Role;
import com.lijin.model.StuAndRole;
import com.lijin.user.dao.DB;
import com.lijin.user.dao.DBMysql;
import com.lijin.user.service.interfaces.IUserService;

@WebService(portName="userservice",serviceName="UserServiceImpl",targetNamespace="http://thzm.com/wsdl",
		endpointInterface="com.lijin.user.service.interfaces.IUserService")
public class UserServiceImpl   implements IUserService{

	//private DB db = null;

	/**static Map<String, Object> maps = new HashMap<String, Object>();

	static {

		try {

			SAXReader saxReader = new SAXReader();

			Document doc = saxReader.read("./dbs.xml");

			List<Element> lists = doc.selectNodes("/beans/bean");

			for (Element cElement : lists) {
				String id = cElement.attributeValue("id");
				String cpath = cElement.attributeValue("class");
				System.out.println(id + "--->" + cpath);
				try {
					// com.lixin.user.dao.DBMysql
					Class c = Class.forName(cpath);

					try {
						// 反射创建这个类的对象
						Object obj = c.newInstance();
						maps.put(id, obj);

					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}**/

	@Override
	public String queryRoleData() {
		// TODO Auto-generated method stub
		System.out.println("UserServiceImpl  is queryRoleData  start...  ");

		// 面向对象，绑定死了
		 DBMysql db = new DBMysql();
		// 面向对象的动态绑定，这种绑定是基于代码的绑定，不够灵活。
		// db = new DBMysql();

		// 面向反射的绑定，这种绑定是基于xml配置文件的绑定，灵活。
		// 给予db绑定什么数据库，是由用户决定的（根据配置文件）。
		//db = (DB) maps.get("db");

		List<Role> lists = db.queryRoleData();

		System.out.println("--->" + lists.size());

		// webservice发布的数据应该是各个平台和语言统一能够解析的数据格式:
		// json [{},{},{}]

		JSONArray array = new JSONArray();
		for (Role role : lists) {

			JSONObject obj = new JSONObject();
			obj.put("id", role.getRid());
			obj.put("rname", role.getRname());
			array.add(obj);
		}
		System.out.println("JSON-->" + array.toString());

		return array.toString();
	}

	@Override
	public String queryGroupByRoleCount() {
		// TODO Auto-generated method stub
		System.out.println("UserServiceImpl  is queryGroupByRoleCount  start...  ");

		DBMysql db = new DBMysql();
		//db = (DB) maps.get("db");

		List<StuAndRole> lists = db.queryRoleGroupCount();

		System.out.println("--->" + lists.size());
		JSONArray array = new JSONArray();
		for (StuAndRole crole : lists) {

			JSONObject obj = new JSONObject();
			obj.put("rname", crole.getRname());
			obj.put("rcount", crole.getRcount());
			array.add(obj);
		}
		System.out.println("JSON-->" + array.toString());

		return array.toString();
	}

	@Override
	public String queryStuAndkmCount(String name) {
		// TODO Auto-generated method stub
		System.out.println("UserServiceImpl  is queryGroupByRoleCount  start...  ");

		 DBMysql db = new DBMysql();
	    //db = (DB) maps.get("db");
		String data = db.queryStuAndkmCount(name);

		System.out.println("data-->" + data);
		return data;
	}

	@Override
	public String checkUserLogin(String username, String pwd) {
		// TODO Auto-generated method stub
		DBMysql db = new DBMysql();
		
		
		//db = (DB) maps.get("db");
		System.out.println("UserServiceImpl  is checkUserLogin  start...  ");

		int count = db.checkUserLogin(username, pwd);
		if (count > 0) {
			return "登录成功";
		}
		return "登录失败";
	}

	@Override
	public String queryGirdMenuData() {
		// TODO Auto-generated method stub
		System.out.println("UserServiceImpl  is queryGirdMenuData  start...  ");

		 DBMysql db = new DBMysql();
		//db = (DB) maps.get("db");

		List<Menu> lists = db.queryMenuData();

		// alibaba的json
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);

		System.out.println("strJson-->" + strJson);

		return strJson;
	}

	@Override
	public String queryClassToStuCount() {
		// TODO Auto-generated method stub
		System.out.println("UserServiceImpl  is queryClassToStuCount  start...  ");
		
		DBMysql db = new DBMysql();
		 		 
		//db = (DB) maps.get("db");

		List<Data> lists = db.queryClassToStuCount();
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);

		System.out.println("List<Data>-->strJson-->" + strJson);
		return strJson;
	}

	@Override
	public String queryNameCount() {
		// TODO Auto-generated method stub
		System.out.println("UserServiceImpl  is queryNameCount  start...  ");

        DBMysql db = new DBMysql();
 
		List<Data> lists = db.queryNameCount();
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);

		System.out.println("List<Data>Name-->strJson-->" + strJson);
		return strJson;
	}
	
	//学生性别
	@Override
	public String querySexCount() {
		// TODO Auto-generated method stub
		System.out.println("UserServiceImpl  is querySexCount  start...  ");

        DBMysql db = new DBMysql();
 
		List<Data> lists = db.querySexCount();
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);

		System.out.println("List<Data>Sex-->strJson-->" + strJson);
		return strJson;
	}
	
	//学生地址
	@Override
	public String queryAddressCount() {
		// TODO Auto-generated method stub
		System.out.println("UserServiceImpl  is queryAddressCount  start...  ");

        DBMysql db = new DBMysql();
 
		List<Data> lists = db.queryAddressCount();
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);

		System.out.println("List<Data>Address-->strJson-->" + strJson);
		return strJson;
	}
	
	//学生年龄
	@Override
	public String queryAgeCount() {
		// TODO Auto-generated method stub
		System.out.println("UserServiceImpl  is queryAgeCount  start...  ");

        DBMysql db = new DBMysql();
 
		List<Data> lists = db.queryAgeCount();
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);

		System.out.println("List<Data>Age-->strJson-->" + strJson);
		return strJson;
	}


}