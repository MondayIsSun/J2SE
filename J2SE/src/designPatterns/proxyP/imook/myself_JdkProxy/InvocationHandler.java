package designPatterns.proxyP.imook.myself_JdkProxy;

import java.lang.reflect.Method;

public interface InvocationHandler {

	// 注意这个方法的作用就是：
	// 处理某个对象的某个方法的
	// 所以应该是有三个参数的，由于我们这里只是简单的模拟，所以就不传参数了
	public void invoke(Object o, Method m);

}
