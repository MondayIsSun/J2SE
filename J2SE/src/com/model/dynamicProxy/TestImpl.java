package com.model.dynamicProxy;

public class TestImpl implements TestIFC {

	/**
	 * ѧϰһ������:
	 * 
	 * function invocation ���� ��������
	 */

	/**
	 * ��������ṩ������̬������ľ�̬����
	 * 
	 * �������:
	 * 
	 * Proxy���ṩ������̬������ľ�̬����������������Щ�������������ж�̬������ĳ���
	 */

	@Override
	public String buyTicket(int arg_1) {
		System.out.println("��Ʊ");

		return "����Ʊ";
	}

}
