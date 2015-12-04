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
		
		// �û��ĸ��Ի�����
		long start = System.currentTimeMillis();
		System.out.println("starttime:" + start);
		System.out.println(o.getClass().getName());
		
		// ִ�б�����ķ���
		try {
			m.invoke(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// �û��ĸ��Ի�����
		long end = System.currentTimeMillis();
		System.out.println("time:" + (end - start));
	}

}
