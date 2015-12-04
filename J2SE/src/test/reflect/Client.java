package test.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Client {

	public void test() throws InstantiationException, IllegalAccessException,
			NoSuchFieldException, SecurityException, NoSuchMethodException,
			IllegalArgumentException, InvocationTargetException {

		// 1
		Class c1 = Foo.class;

		// 2
		Foo f1 = new Foo();
		Class c2 = f1.getClass();

		// 3
		Class c3 = null;
		try {
			c3 = Class.forName("com.reflect.Foo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// System.out.println(c3);
		System.out.println(c1 == c2);
		System.out.println(c2 == c3);

		// +++++++++++++++++++++++++++++++++++++++++++++

		// ������ƴ�������

		try {
			// һ������õ��������޲ι��캯���������������д�˹��캯��һ��Ҫ��һ���޲εĹ��캯��
			Foo f2 = (Foo) c1.newInstance();
			f2.setName("Marry");
			f2.setSex("Ů");
			System.out.println(f2.getName() + "  " + f2.getSex());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		// +++++++++++++++++++++++++++++++++++++++++++++

		// ������� ---> Class.forName() ---> ��̬������
		// new�Ǳ���ʱ���� ---> ��̬������

		// +++++++++++++++++++++++++++++++++++++++++++++

		// ������ƻ�ȡ�����ֶ�

		// ���ַ�ʽ��ȡ������public���ε��ֶ�
		Field[] fields = c2.getFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getName());
		}

		// ��ȡ�����е������ֶ�
		Field[] fields_1 = c2.getDeclaredFields();
		for (int i = 0; i < fields_1.length; i++) {
			System.out.println(fields_1[i].getName());
		}

		// ��ȡ�ض��������ֶ�
		try {
			Field field_1 = c2.getDeclaredField("name");
			System.out.println(field_1.getName());
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		// +++++++++++++++++++++++++++++++++++++++++++++

		// ʹ�÷�����ƴ���Java�������ķ�װ�ص�

		Foo f2 = (Foo) c2.newInstance();
		f2.setName("xiaoming");
		System.out.println("û�з������֮ǰ��name = " + f2.getName());

		// ͨ��������ֱ�Ӳ�����������
		// ���Ȼ�ȡ������������Ǹ����ԵĶ���
		Field fieldName = c2.getDeclaredField("name");
		fieldName.setAccessible(true);
		fieldName.set(f2, "�������óɹ�");
		System.out.println("�������֮���name = " + f2.getName());

		// ע�������淽�����ڵı��ʾ���Ҫȥ�������Ե�
		// ����һ�������ϵ����Բ�������Ҫ����ʵģ���������ͬ��ı��ʣ������Ƕ���

		System.out.println();

		// +++++++++++++++++++++++++++++++++++++++++++++

		// ������Ʋ�����Ա����

		// ��ȡ��public���εĳ�Ա����
		// c2.getMethods()

		// ��ȡ�����еĳ�Ա����
		Method[] methods = c2.getDeclaredMethods();
		for (Method method : methods) {

			// ��ȡ��������
			System.out.println("�������� ---> " + method.getName());

			// ��ȡ���η�
			System.out.println("�������η� ---> "
					+ Modifier.toString(method.getModifiers()));

			// ��ȡ�����ķ���ֵ����
			Class returnType = method.getReturnType();
			System.out.println("��������ֵ���� ---> " + returnType.getName());

			// ��ȡ��������ʽ����
			Class[] ParameterTypes = method.getParameterTypes();
			StringBuilder sb = new StringBuilder();
			sb.append("�β���Ϣ ---> ");
			for (Class parameter : ParameterTypes) {
				sb.append(parameter.getSimpleName());
				sb.append(" ");
			}
			System.out.println(sb.toString());

			System.out.println();

		}

		// ������ƻ�ȡ�ض��ķ�������ͨ���������ִ����

		// ��ȡ�����뷴����õķ���
		Method m = c2.getMethod("myMethod", String.class, int.class);

		// ͨ����������������
		// ��Ϊ�����϶���ĳ�Ա��������Ҫ�����������ϵ����Եģ�����ͬ������Ҫָ���������Ҫ�����ĸ�����
		System.out.println(m.invoke(c2.newInstance(), "��������", 29));

		// +++++++++++++++++++++++++++++++++++++++++++++

		// ������Ʋ������췽������ʹ�û�ȡ���Ĺ��췽����������

		// +++++++++++++++++++++++++++++++++++++++++++++

		// ������ƻ�ȡextends��implements��Ϣ

		// +++++++++++++++++++++++++++++++++++++++++++++
	}

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			InvocationTargetException {

		new Client().test();
	}

}