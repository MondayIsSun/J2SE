package com.generic;

import java.util.List;

public class GenericDemo {

	/**
	 * ������̣�Console��switch�����ͣ������޴�����ŵ�˼��
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		// public void write(Integer i, Integer[] ia);
		// public void write(Double d, Double[] da);
		// �ķ��Ͱ汾Ϊ
		// public <T> void write(T t, T[] ta);

		System.out.println(genericTest(9));
		System.out.println(genericTest("Generic"));
	}

	// ���ͷ���
	public static <T> T genericTest(T t) {
		System.out.println(t);
		return t;
	}

	// ʹ��ͨ���
	public void testGenericMethodDefine2(List<?> s) {

	}

	// ������
	class GenericClass<T> {

	}
}
