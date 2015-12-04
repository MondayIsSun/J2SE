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
// ���Զ�����Ķ�������Ľӿڷ�����ʵ������Ĵ���