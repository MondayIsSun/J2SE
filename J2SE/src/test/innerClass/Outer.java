package test.innerClass;

//体会 this 和 super 的本质
// ++a 是返回加之后的结果，确实a是自增1了，只是这个操作符是怎么返回的而已，这是两码事
//理解final,static

public class Outer {

	private int size = 0;

	public class Inner {

		private int size = 3;

		public void doStuff(int size) {
			System.out.println(++size);
			System.out.println(++this.size);
			System.out.println(++Outer.this.size);
		}
	}

	public static void main(String[] args) {

		Outer out = new Outer();
		Outer.Inner inner = out.new Inner();
		inner.doStuff(-1);

	}

}