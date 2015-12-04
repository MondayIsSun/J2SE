package com.model.dynamicProxy;

public class TestImpl implements TestIFC {

	/**
	 * 学习一个术语:
	 * 
	 * function invocation —— 函数调用
	 */

	/**
	 * 反射机制提供产生动态代理类的静态方法
	 * 
	 * 具体的是:
	 * 
	 * Proxy类提供产生动态代理类的静态方法，他还是由这些方法创建的所有动态代理类的超类
	 */

	@Override
	public String buyTicket(int arg_1) {
		System.out.println("买票");

		return "给我票";
	}

}
