package designPatterns.proxyP.imook.myself_JdkProxy;

import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

	/**
	 * 首先需要明白的是这个InvocationHandler当中已经分装了需要我们代理的代理对象了
	 */

	Object target = null;

	public TimeHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public void invoke(Object o, Method m) {

		// 在方法前添加自己的业务逻辑
		long starttime = System.currentTimeMillis();
		System.out.println("汽车开始行驶....");

		// 被代理的对象的方法
		try {
			m.invoke(target);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 在方法后添加自己的业务逻辑
		long endtime = System.currentTimeMillis();
		System.out.println("汽车结束行驶....  汽车行驶时间：" + (endtime - starttime)
				+ "毫秒！");
	}
}
