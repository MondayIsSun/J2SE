package generic;

import java.util.ArrayList;
import java.util.List;

public class GenericClassTest<T> {

	// 泛型不能使用在静态属性上
	// private static T javaScore;

	// 泛型不能使用在静态方法上
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

	// 泛型使用的时候不能用基本类型来传递泛型参数

	// 注意在接口当中声明的变量默认是public static final的
	// 所以泛型接口当中的变量是不能使用泛型来定义的
	// 注意在接口当中声明的方法默认是public abstract的

	// 要区别：泛型类，泛型接口，泛型方法
	public <P> void getApple(T... a) {
		P t;
		System.out.println(a);
	}
}
