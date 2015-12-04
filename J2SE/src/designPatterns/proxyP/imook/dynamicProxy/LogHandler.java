package designPatterns.proxyP.imook.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {

	private Object target;

	public LogHandler(Object target) {
		super();
		this.target = target;
	}

	// 特别特别注意，这个Object proxy参数实际上就是当前产生的代理对象
	// 所以不要去修改这个参数名字
	// 否则会报错的
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		System.out.println("开始记录日志...");

		// Object obj = method.invoke(target);

		method.invoke(target);

		System.out.println("日志记录结束...");

		// System.out.println(obj.getClass().getName());

		return null;
	}

}
