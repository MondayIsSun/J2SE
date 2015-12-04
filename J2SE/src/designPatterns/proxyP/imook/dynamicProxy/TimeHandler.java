package designPatterns.proxyP.imook.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

	// 是使用聚合的方式实现的
	private Object target = null;

	public TimeHandler(Object target) {
		super();
		this.target = target;
	}

	/**
	 * 参数：
	 * 
	 * proxy：被代理的对象
	 * 
	 * method：被代理的方法
	 * 
	 * args：方法的参数
	 * 
	 * 返回值：
	 * 
	 * Object：产生的动态代理对象
	 */

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		long startTime = System.currentTimeMillis();
		System.out.println("汽车开始行驶...");

		// 反射机制：
		method.invoke(target);

		long endTime = System.currentTimeMillis();

		System.out.println("汽车结束行驶...行驶时间：" + (endTime - startTime) + "毫秒");

		// System.out.println(proxy.getClass().getInterfaces());
		Class<?>[] clsArray = proxy.getClass().getInterfaces();
		for (Class<?> class1 : clsArray) {
			System.out.println(class1);
			// interface designPatterns.proxyP.imook.staticProxy.Moveable
			// 这样就证明了确实这个是动态产生的代理类
		}

		return null;
	}

}
