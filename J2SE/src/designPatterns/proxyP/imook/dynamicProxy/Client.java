package designPatterns.proxyP.imook.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import designPatterns.proxyP.imook.staticProxy.Moveable;

public class Client {

	/**
	 * JDK动态代理测试类
	 */
	public static void main(String[] args) {

		Car car = new Car();
		InvocationHandler h = new TimeHandler(car);

		Class<?> cls = car.getClass();

		/**
		 * loader:类加载器
		 * 
		 * interfaces:实现接口
		 * 
		 * h:InvocationHandler(事务处理器)
		 */
		Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(),
				cls.getInterfaces(), h);

		// JDK动态代理底层的实现思路是：
		// 首先是获取编译器编译动态代理类的，可以使用jdk自带的编译器也可以使用cglib
		// cls.getClassLoader()类加载器的作用就是能够方便地告知JVM要从哪里加载这个类
		// Handler接口的作用是提供给用户做个性化处理的，指定你要对那个类的那个方法做动态代理，当然方法还需要传递参数的
		// cls.getInterfaces()这个是为了获取到被代理类的接口，为的是动态产生动态代理类的组合代码以方便编译，
		// 然后编译形成的.class文件就是使用cls.getClassLoader()这个类加载器来load到内存当中，
		// 然后使用反射机制创建出动态代理类的

		m.move();

		System.out
				.println("==============================================================");

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		// 思考jdk动态各种代理实现组合
		// 要点是理解好JDK动态代理的底层实现
		// 理解这个动态代理也是实现了自己定义的接口的了
		// 所以只要在代理类的基础上再套上某个代理就OK了
		// 首先是日志的代理:
		Car car1 = new Car();
		Class<?> cls1 = car1.getClass();
		InvocationHandler h1 = new LogHandler(car1);

		Moveable m1 = (Moveable) Proxy.newProxyInstance(cls1.getClassLoader(),
				cls1.getInterfaces(), h1);

		m1.move();

		System.out
				.println("==============================================================");

		InvocationHandler h2 = new TimeHandler(m1);

		Moveable m2 = (Moveable) Proxy.newProxyInstance(m1.getClass()
				.getClassLoader(), m1.getClass().getInterfaces(), h2);

		m2.move();
	}
}
