package test.staticTest;

/**
 * 两者的区别就是:静态代码块是自动执行的; 静态方法是被调用的时候才执行的.
 * 
 * @author Administrator
 *
 */
public class StaticTest {

	// 第一次出现类名的时候做了这些事
	// 加载类的所有东西
	// 成员属性
	// 成员方法
	// 静态成员属性
	// 静态成员方法
	// 内部类
	// 父类
	// 构造函数

	public static String nationality;

	public String name;
	public int age;

	// 静态代码段
	// 确实是第一次出现类名的时候静态代码段就执行了
	// 同时可以知道静态属性比static代码段更快加载
	// 所以创建出对象是一件很迟的事儿
	static {
		nationality = "china";
		System.out.println("static{ ... }");
	}

	// 静态方法
	public static void myMethod() {
		nationality = "american";
		System.out.println("static method");
	}

}
