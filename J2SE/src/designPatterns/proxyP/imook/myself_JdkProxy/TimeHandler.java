package designPatterns.proxyP.imook.myself_JdkProxy;

import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

	/**
	 * ������Ҫ���׵������InvocationHandler�����Ѿ���װ����Ҫ���Ǵ���Ĵ��������
	 */

	Object target = null;

	public TimeHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public void invoke(Object o, Method m) {

		// �ڷ���ǰ����Լ���ҵ���߼�
		long starttime = System.currentTimeMillis();
		System.out.println("������ʼ��ʻ....");

		// ������Ķ���ķ���
		try {
			m.invoke(target);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// �ڷ���������Լ���ҵ���߼�
		long endtime = System.currentTimeMillis();
		System.out.println("����������ʻ....  ������ʻʱ�䣺" + (endtime - starttime)
				+ "���룡");
	}
}
