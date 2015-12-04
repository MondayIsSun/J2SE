package designPatterns.proxyP.msb;

import designPatterns.proxyP.msb.dynamicProxy.InvocationHandler;
import designPatterns.proxyP.msb.dynamicProxy.Moveable;
import designPatterns.proxyP.msb.dynamicProxy.Proxy;
import designPatterns.proxyP.msb.dynamicProxy.Tank;
import designPatterns.proxyP.msb.dynamicProxy.TimeHandler;

public class Client {
	public static void main(String[] args) throws Exception {
		Tank t = new Tank();
		InvocationHandler h = new TimeHandler(t);

		Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class, h);

		m.move();
	}
}
// 可以对任意的对象、任意的接口方法，实现任意的代理