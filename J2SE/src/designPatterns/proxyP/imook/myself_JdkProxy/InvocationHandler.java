package designPatterns.proxyP.imook.myself_JdkProxy;

import java.lang.reflect.Method;

public interface InvocationHandler {

	// ע��������������þ��ǣ�
	// ����ĳ�������ĳ��������
	// ����Ӧ���������������ģ�������������ֻ�Ǽ򵥵�ģ�⣬���ԾͲ���������
	public void invoke(Object o, Method m);

}
