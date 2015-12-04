package io.mook.objectSerialize;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ObjectSeriaDemo2 {

	/**
	 * ���л��� ����͸��๹�캯���ĵ�������
	 * 
	 * @param args
	 * @throws Exception
	 */

	public static void main(String[] args) throws Exception {

		/**
		 * ע�⣺���ڼ̳е�ʱ�򣬴�����������ʱ���ݹ���ø���Ĺ��캯��!
		 * 
		 * ��ӡ�Ľ���ǣ�
		 * 
		 * foo...
		 * 
		 * foo1...
		 * 
		 * foo2...
		 * 
		 */
		// ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
		// "demo/obj1.dat"));
		// Foo2 foo2 = new Foo2();
		// oos.writeObject(foo2);
		// oos.flush();
		// oos.close();

		// ============================================================

		// �����л��Ƿ�ݹ���ø���Ĺ��캯��?
		/*
		 * ObjectInputStream ois = new ObjectInputStream( new
		 * FileInputStream("demo/obj1.dat")); Foo2 foo2 =
		 * (Foo2)ois.readObject(); System.out.println(foo2); ois.close();
		 */

		// ============================================================

		/*
		 * ObjectOutputStream oos = new ObjectOutputStream( new
		 * FileOutputStream("demo/obj1.dat")); Bar2 bar2 = new Bar2();
		 * oos.writeObject(bar2); oos.flush(); oos.close();
		 */

		// ============================================================

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				"demo/obj1.dat"));
		Bar2 bar2 = (Bar2) ois.readObject();
		System.out.println(bar2);
		ois.close();

		/**
		 * ��ӡ����ǣ�
		 * 
		 * bar
		 * 
		 * bar1...
		 * 
		 * io.mook.objectSerialize.bar2@....;
		 */

		/*
		 * ���ۣ� �����������з����л�����ʱ�� ����丸��û��ʵ�����л��ӿڣ���ô�丸��Ĺ��캯���ᱻ����
		 */
	}
}

// ============================================================

/*
 * һ����ʵ�������л��ӿڣ���ô�����඼���Խ������л�
 */
@SuppressWarnings("serial")
class Foo implements Serializable {
	public Foo() {
		System.out.println("foo...");
	}
}

@SuppressWarnings("serial")
class Foo1 extends Foo {
	public Foo1() {
		System.out.println("foo1...");
	}
}

@SuppressWarnings("serial")
class Foo2 extends Foo1 {
	public Foo2() {
		System.out.println("foo2...");
	}
}

// ============================================================

class Bar {
	public Bar() {
		System.out.println("bar");
	}
}

class Bar1 extends Bar {
	public Bar1() {
		System.out.println("bar1..");
	}
}

@SuppressWarnings("serial")
class Bar2 extends Bar1 implements Serializable {
	public Bar2() {
		System.out.println("bar2...");
	}
}