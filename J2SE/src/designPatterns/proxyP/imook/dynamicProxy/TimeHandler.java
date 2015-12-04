package designPatterns.proxyP.imook.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

	// ��ʹ�þۺϵķ�ʽʵ�ֵ�
	private Object target = null;

	public TimeHandler(Object target) {
		super();
		this.target = target;
	}

	/**
	 * ������
	 * 
	 * proxy��������Ķ���
	 * 
	 * method��������ķ���
	 * 
	 * args�������Ĳ���
	 * 
	 * ����ֵ��
	 * 
	 * Object�������Ķ�̬�������
	 */

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		long startTime = System.currentTimeMillis();
		System.out.println("������ʼ��ʻ...");

		// ������ƣ�
		method.invoke(target);

		long endTime = System.currentTimeMillis();

		System.out.println("����������ʻ...��ʻʱ�䣺" + (endTime - startTime) + "����");

		// System.out.println(proxy.getClass().getInterfaces());
		Class<?>[] clsArray = proxy.getClass().getInterfaces();
		for (Class<?> class1 : clsArray) {
			System.out.println(class1);
			// interface designPatterns.proxyP.imook.staticProxy.Moveable
			// ������֤����ȷʵ����Ƕ�̬�����Ĵ�����
		}

		return null;
	}

}
