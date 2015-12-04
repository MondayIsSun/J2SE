package test.generic;

public class Client_Test {

	abstract class Father<T> {
		T name;

		public abstract void test(T data);
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// wrong
	// ֻҪ�漰���̳�extends����� ---> ���ʶ���������������㸸�������Ҫ��Ļ����Ͻ�����չ���̳еı����Ǽ̳и�������ж�����ȫ�̼̳�
	// ����û�����㸸�������
	// class child<T1> extends Father<T> {
	//
	// @Override
	// public void test(T data) {
	// }
	//
	// }

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++

	class Child<T> extends Father<String> {

		@Override
		public void test(String data) {
		}

	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++

	class Child_1<T> extends Father<T> {

		T sex;

		@Override
		public void test(T data) {
			System.out.println(data);
		}

	}

	class Child_2<T1, T> extends Father<T> {

		T1 sex;

		@Override
		public void test(T data) {
		}

		public void c_test(T1 data) {
		}

	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// ������ַ��Ͳ���
	// ��Ϊ����ʾ˵���Ҹ������Ҫ�������� ---> ��ôԭ�и��෺�ͻᱻ���� ---> ʹ��Object����
	class Chile_3<T> extends Father {

		@Override
		public void test(Object data) {
		}

	}

	// ������ͬʱ��������
	// ��Ϊ�������������Լ�Ҫ���Ͳ����ˣ������൱�ڸ����û�з����� ---> ֻ��ԭ�����൱��ʹ�÷��Ͷ���Ķ��������������Object
	// �������ʱ����Ҳ����ѡ��Ҫ����
	class Chile_4 extends Father {

		@Override
		public void test(Object data) {

		}
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++

	abstract class Father_1<T, T1> {

		public abstract void m1(T t);

		public abstract void m2(T1 t);

		public abstract void m3(T1 t1, T t);

	}

	class Child_5<T1, T, T3> extends Father_1<T, T1> {

		@Override
		public void m1(T t) {

		}

		@Override
		public void m2(T1 t) {

		}

		@Override
		public void m3(T1 t1, T t) {

		}
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++

	public void testGeneric() {
		Child_1<String> c1 = new Child_1<String>();
		Child_2<Integer, String> c2 = new Child_2<Integer, String>();
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// Main
	public static void main(String[] args) {

		// ��̬�������ܵ��ö�̬������
		// �������
		// Child_1<String> c1 = new Child_1<String>() ;

	}

}
