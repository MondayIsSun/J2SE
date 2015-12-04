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

		// 反射机制创建对象

		try {
			// 一定会调用到这个类的无参构造函数。所以如果你重写了构造函数一定要给一个无参的构造函数
			Foo f2 = (Foo) c1.newInstance();
			f2.setName("Marry");
			f2.setSex("女");
			System.out.println(f2.getName() + "  " + f2.getSex());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		// +++++++++++++++++++++++++++++++++++++++++++++

		// 反射机制 ---> Class.forName() ---> 动态加载类
		// new是编译时加载 ---> 静态加载类

		// +++++++++++++++++++++++++++++++++++++++++++++

		// 反射机制获取属性字段

		// 这种方式获取到的是public修饰的字段
		Field[] fields = c2.getFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getName());
		}

		// 获取到所有的属性字段
		Field[] fields_1 = c2.getDeclaredFields();
		for (int i = 0; i < fields_1.length; i++) {
			System.out.println(fields_1[i].getName());
		}

		// 获取特定的属性字段
		try {
			Field field_1 = c2.getDeclaredField("name");
			System.out.println(field_1.getName());
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		// +++++++++++++++++++++++++++++++++++++++++++++

		// 使用反射机制打破Java面向对象的封装特点

		Foo f2 = (Foo) c2.newInstance();
		f2.setName("xiaoming");
		System.out.println("没有反射操作之前的name = " + f2.getName());

		// 通过反射来直接操作对象属性
		// 首先获取到你想操作的那个属性的对象
		Field fieldName = c2.getDeclaredField("name");
		fieldName.setAccessible(true);
		fieldName.set(f2, "反射设置成功");
		System.out.println("反射操作之后的name = " + f2.getName());

		// 注意类上面方法存在的本质就是要去操作属性的
		// 所以一个类身上的属性才是最重要的最本质的，才是区别不同类的本质，而不是对象

		System.out.println();

		// +++++++++++++++++++++++++++++++++++++++++++++

		// 反射机制操作成员方法

		// 获取到public修饰的成员方法
		// c2.getMethods()

		// 获取到所有的成员方法
		Method[] methods = c2.getDeclaredMethods();
		for (Method method : methods) {

			// 获取到方法名
			System.out.println("方法名字 ---> " + method.getName());

			// 获取修饰符
			System.out.println("方法修饰符 ---> "
					+ Modifier.toString(method.getModifiers()));

			// 获取方法的返回值类型
			Class returnType = method.getReturnType();
			System.out.println("方法返回值类型 ---> " + returnType.getName());

			// 获取方法的形式参数
			Class[] ParameterTypes = method.getParameterTypes();
			StringBuilder sb = new StringBuilder();
			sb.append("形参信息 ---> ");
			for (Class parameter : ParameterTypes) {
				sb.append(parameter.getSimpleName());
				sb.append(" ");
			}
			System.out.println(sb.toString());

			System.out.println();

		}

		// 反射机制获取特定的方法，并通过反射机制执行它

		// 获取到你想反射调用的方法
		Method m = c2.getMethod("myMethod", String.class, int.class);

		// 通过反射调用这个方法
		// 因为类身上定义的成员方法都是要操作对象身上的属性的，所以同样地需要指定这个方法要操作哪个对象
		System.out.println(m.invoke(c2.newInstance(), "不告诉你", 29));

		// +++++++++++++++++++++++++++++++++++++++++++++

		// 反射机制操作构造方法，并使用获取到的构造方法创建对象

		// +++++++++++++++++++++++++++++++++++++++++++++

		// 反射机制获取extends和implements信息

		// +++++++++++++++++++++++++++++++++++++++++++++
	}

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			InvocationTargetException {

		new Client().test();
	}

}