package test.generic;

public class Client_Test {

	abstract class Father<T> {
		T name;

		public abstract void test(T data);
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// wrong
	// 只要涉及到继承extends的情况 ---> 本质都是子类必须在满足父类的所有要求的基础上进行拓展，继承的本质是继承父类的所有东西，全盘继承
	// 子类没有满足父类的需求
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

	// 下面出现泛型擦除
	// 因为我显示说明我父类就是要砍掉泛型 ---> 那么原有父类泛型会被擦除 ---> 使用Object代替
	class Chile_3<T> extends Father {

		@Override
		public void test(Object data) {
		}

	}

	// 父子类同时擦除泛型
	// 因为父类明显声明自己要泛型擦除了，所以相当于父类就没有泛型了 ---> 只是原来父类当中使用泛型定义的东西都被替代成了Object
	// 所以这个时候类也可以选择不要泛型
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

		// 静态方法不能调用动态的内容
		// 错误代码
		// Child_1<String> c1 = new Child_1<String>() ;

	}

}
