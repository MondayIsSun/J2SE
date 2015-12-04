package designPatterns.proxyP.imook.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import designPatterns.proxyP.imook.staticProxy.Moveable;

public class Client {

	/**
	 * JDK��̬���������
	 */
	public static void main(String[] args) {

		Car car = new Car();
		InvocationHandler h = new TimeHandler(car);

		Class<?> cls = car.getClass();

		/**
		 * loader:�������
		 * 
		 * interfaces:ʵ�ֽӿ�
		 * 
		 * h:InvocationHandler(��������)
		 */
		Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(),
				cls.getInterfaces(), h);

		// JDK��̬����ײ��ʵ��˼·�ǣ�
		// �����ǻ�ȡ���������붯̬������ģ�����ʹ��jdk�Դ��ı�����Ҳ����ʹ��cglib
		// cls.getClassLoader()������������þ����ܹ�����ظ�֪JVMҪ��������������
		// Handler�ӿڵ��������ṩ���û������Ի�����ģ�ָ����Ҫ���Ǹ�����Ǹ���������̬������Ȼ��������Ҫ���ݲ�����
		// cls.getInterfaces()�����Ϊ�˻�ȡ����������Ľӿڣ�Ϊ���Ƕ�̬������̬���������ϴ����Է�����룬
		// Ȼ������γɵ�.class�ļ�����ʹ��cls.getClassLoader()������������load���ڴ浱�У�
		// Ȼ��ʹ�÷�����ƴ�������̬�������

		m.move();

		System.out
				.println("==============================================================");

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		// ˼��jdk��̬���ִ���ʵ�����
		// Ҫ��������JDK��̬����ĵײ�ʵ��
		// ��������̬����Ҳ��ʵ�����Լ�����Ľӿڵ���
		// ����ֻҪ�ڴ�����Ļ�����������ĳ�������OK��
		// ��������־�Ĵ���:
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
