package generic;

import java.util.ArrayList;
import java.util.List;

public class GenericClassTest<T> {

	// ���Ͳ���ʹ���ھ�̬������
	// private static T javaScore;

	// ���Ͳ���ʹ���ھ�̬������
	// cannot
	// public static T getName() {
	//
	// }

	// cannot
	// public static void getName(T t) {
	//
	// }

	// cannot
	// public static void getName() {
	// T t;
	// }

	// ����ʹ�õ�ʱ�����û������������ݷ��Ͳ���

	// ע���ڽӿڵ��������ı���Ĭ����public static final��
	// ���Է��ͽӿڵ��еı����ǲ���ʹ�÷����������
	// ע���ڽӿڵ��������ķ���Ĭ����public abstract��

	// Ҫ���𣺷����࣬���ͽӿڣ����ͷ���
	public <P> void getApple(T... a) {
		P t;
		System.out.println(a);
	}
}
