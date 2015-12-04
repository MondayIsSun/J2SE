package test.references;

public class Client {

	public static void main(String[] args) {
		A a = new A();
		a.b = new B();
		a = null;
		System.gc();
	}

}
