package com.lijin.application.service;

import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

import com.lijin.user.service.impl.UserServiceImpl;
//使用webservice统一发布数据访问接口中间件
@SOAPBinding(style=SOAPBinding.Style.RPC)
public class UserDataService {

	public static void main(String[] args) {
		System.out.println("webservice  service  is  start...");

		Endpoint.publish("http://127.0.0.1:8060/userdataservice/user",
				new UserServiceImpl());

		System.out.println("UserDataService  服务发布成功....");

	}

}
