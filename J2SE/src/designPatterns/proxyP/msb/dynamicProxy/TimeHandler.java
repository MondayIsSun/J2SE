package designPatterns.proxyP.msb.dynamicProxy;

import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

	private Object target;

	public TimeHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public void invoke(Object o, Method m) {
		
		// 用户的个性化操作
		long start = System.currentTimeMillis();
		System.out.println("starttime:" + start);
		System.out.println(o.getClass().getName());
		
		// 执行被代理的方法
		try {
			m.invoke(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 用户的个性化操作
		long end = System.currentTimeMillis();
		System.out.println("time:" + (end - start));
	}

}
