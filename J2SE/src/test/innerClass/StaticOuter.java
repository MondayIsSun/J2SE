package test.innerClass;

/**
 * 最后得出的结论是
 * 
 * 1、静态内部类只能访问外部类静态的东西，普通内部类可以访问外部类所有的东西
 * 
 * 2、静态内部类可以拥有自己静态的东西，普通内部类只能拥有非静态的东西
 * 
 * 作用是：如果考虑到内部类的生命周期可能会比外部类长的话应该考虑使用静态内部类或者弱引用 ---> 因为静态内部类不会持有外部类的引用
 * 
 */

public class StaticOuter {

	// 静态属性
	// 当然静态属性一般是public的啦
	private static String name;

	public int age;

	public static void printSomething() {

	}

	public void happyBird() {

	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// 静态内部类 static inner classes
	// 只能访问外部类的静态成员变量与静态方法
	public static class StaticInner {

		// 静态内部类只能访问外部类静态程序，不能访问外部类的成员属性(成员属性是对象时期才具有的东西)
		// --->
		// 这样直接导致了静态内部类不会持有外部类的引用,因为不会访问到外部类的属性，也就是说到时候不会访问外部类的某个instance的属性，所以没有必要持有外部类的引用啦
		// ---> 不会引起内存泄露

		// 当然静态内部类也是一个类，也是可以有自己这类的东西的

		// 静态内部类可以声明静态的成员变量，其他的内部类不可以
		public static boolean sex;

		// 静态内部类可以有静态的东西 ---> 静态的属性和方法
		public static void saySomthing() {

		}

		private String myName;
		public int myAge;

		public void testM() {

			// ++++++++++++++++++++++++++++++++++++++++++++++++++++++

			// 由于this本身就不是静态的东西，所以这个地方报错是很正常的
			// StaticOuter.this.name = this.myName;
			// 确实静态内部类可以访问外部类静态的东西
			name = myName;
			// 确实静态内部类没有办法访问外部类非静态的东西
			// age

			printSomething();
			// happyBird();

			// ++++++++++++++++++++++++++++++++++++++++++++++++++++++

		}
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// 成员内部类 member inner classes
	public class InnerClass {

		// 非静态内部类不可以可以声明静态的成员变量
		// public static boolean sex;

		// 同样的，普通内部类也是不能声明静态的方法的
		// public static void saySomthing() {
		// }

		// 当然普通的内部类也是可以有自己的东西的，只是这个东西不能是静态的
		private String myName;
		public int myAge;

		public void doSomething() {

			// 普通内部类可以访问外部类静态的东西 ---> 静态属性&静态方法
			StaticOuter.this.name = "";
			StaticOuter.name = "";
			StaticOuter.printSomething();

			// 普通内部类可以访问外部类非静态的东西 ---> 属性&方法
			StaticOuter.this.age = 10;
			StaticOuter.this.happyBird();

		}

	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// 外部类的一个成员方法
	public void execute() {

		final int a = 1;
		//a = 2;

		// 创建局部内部类
		// 类似于局部变量，不能定义为public，protected，private或者static类型。
		// 定义方法中，只能访问该方法中声明为final类型的变量。 ---> 内部类的闭包 ---> 原因是内部类的生命周期可能会比所在的方法长
		// ---> 所以不能访问方法当中不是final修饰的东西
		@SuppressWarnings("hiding")
		class InnerClass {
			public void execute() {
				System.out.println("LocalInner Class");
				// 局部内部类只能访问final类型的变量
				System.out.println(a);
			}
		}

		// 只能在所在方法区域创建
		new InnerClass().execute();
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	// 匿名内部类 ---> 其实和局部内部类本质是一样的 ---> 只是这个匿名内部类是没有应用指向的 ---> 从而导致了这个类对象只会被使用一次
	// ---> 没有引用指向的对象会GC掉
	// 其次就是在创建这个类对象的时候可以是接口呀等到，我们直接在里面实现了接口的内容了
	// 同样也只能访问该方法内部的final类型的变量
	
	/*
	 button.addActionListener(new ActionListener(){
		//实现接口中的方法
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("使用匿名内部类实现ActionListener接口");
		}
	 });
	 */

	public static void main(String[] args) {

		StaticOuter out = new StaticOuter();

		// 普通内部类对象的创建
		InnerClass innerClass = out.new InnerClass();

		// 静态内部类对象的创建 ---> 静态的东西的生命周期 ---> 静态的东西总是可以类名.出来的
		StaticInner staticInner = new StaticOuter.StaticInner();
	}

}
