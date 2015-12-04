package designPatterns.proxyP.msb.compiler;

import java.lang.reflect.Method;

public class Test2 {

	public static void main(String[] args) {

		Method[] methods = designPatterns.proxyP.msb.dynamicProxy.Moveable.class
				.getMethods();
		for (Method m : methods) {
			System.out.println(m.getName());
		}
	}
}
