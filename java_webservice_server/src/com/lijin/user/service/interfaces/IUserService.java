package com.lijin.user.service.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService(targetNamespace="http://thzm.com/wsdl")
public interface IUserService {
	
	//��ѯ��ɫ������
	@WebMethod
	public String  queryRoleData();
	
	
	// �ҳ�ѧ�������ְ���ѧ��������ְ������
	@WebMethod
	public String  queryGroupByRoleCount();
	
	//-- **ѧ����ѧ�γ̵�����
	@WebMethod
	public String  queryStuAndkmCount(String name);
	
	//����¼        2018.12.24����
	@WebMethod
	public String checkUserLogin(String  username,String  pwd);

	//���ݲ˵�        2018.12.25����
	@WebMethod
	public String   queryGirdMenuData();
	
	//��ѯÿ���༶��ѧ��������
	public  String  queryClassToStuCount();	
	
	//ѧ�����ϵĲ��� 
	public  String   queryNameCount();
	
}
