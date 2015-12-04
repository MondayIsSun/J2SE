package com.model.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil implements InvocationHandler {

	private Object proxyObj;

	private Object senObj;

	public Object createProxyObj(Object sendObj) {

		this.senObj = sendObj;

		proxyObj = Proxy.newProxyInstance(sendObj.getClass().getClassLoader(),
				sendObj.getClass().getInterfaces(), this);

		return proxyObj;
	}

	/**
	 * Object invoke£º
	 * 
	 * Method method£º
	 * 
	 * Object[] args£º
	 */

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		System.out.println("Method:" + method);

		System.out.println("Args:" + args.length);

		return method.invoke(this.senObj, args);
	}

}
