package com.generic;

import java.util.List;

public class GenericDemo {

	/**
	 * 面向过程，Console，switch，泛型，代码无错就是优的思考
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		// public void write(Integer i, Integer[] ia);
		// public void write(Double d, Double[] da);
		// 的范型版本为
		// public <T> void write(T t, T[] ta);

		System.out.println(genericTest(9));
		System.out.println(genericTest("Generic"));
	}

	// 泛型方法
	public static <T> T genericTest(T t) {
		System.out.println(t);
		return t;
	}

	// 使用通配符
	public void testGenericMethodDefine2(List<?> s) {

	}

	// 泛型类
	class GenericClass<T> {

	}
}
