package designPatterns.proxyP.imook.dynamicProxy;

import designPatterns.proxyP.imook.staticProxy.Moveable;

public class Car implements Moveable {

	@Override
	public void move() {
		System.out.println("汽车行驶当中...");
	}

}
