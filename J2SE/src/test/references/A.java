package test.references;

public class A {
	B b;

	public void finalize() {
		System.out.println("method A.finalize at " + System.nanoTime());
	}
	
	
}