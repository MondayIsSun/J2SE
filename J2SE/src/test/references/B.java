package test.references;

public class B {
	public void finalize() {
		System.out.println("method B.finalize at " + System.nanoTime());
	}
}
