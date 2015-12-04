package designPatterns.proxyP.imook.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {

	private Object target;

	public LogHandler(Object target) {
		super();
		this.target = target;
	}

	// �ر��ر�ע�⣬���Object proxy����ʵ���Ͼ��ǵ�ǰ�����Ĵ������
	// ���Բ�Ҫȥ�޸������������
	// ����ᱨ���
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		System.out.println("��ʼ��¼��־...");

		// Object obj = method.invoke(target);

		method.invoke(target);

		System.out.println("��־��¼����...");

		// System.out.println(obj.getClass().getName());

		return null;
	}

}
