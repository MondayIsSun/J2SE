package com.model.dynamicProxy;

public class TestMain {

	public static void main(String[] args) {

		ProxyUtil proxyUtil = new ProxyUtil();

		TestIFC testIFC = (TestIFC) proxyUtil.createProxyObj(new TestImpl());
		
		testIFC.buyTicket(1);
	}
}
