package usefullClass;

public class StringTest {

	public static void main(String[] args) {

		// String str = null;
		// if (str == null) {
		// // NullPointerException
		// // 在空的对象上是没有任何方法的
		// // 这个很好理解呀，被赋值成null了表示这个句柄没有指向任何对象了，所以它怎么知道调用什么方法呢？
		// System.out.println(str.length());
		// }

		// 注意这个与上面的那种方式是有本质区别的
		// 这个str2确实指向了一个字符串对象，只是这个字符串对象上的内容为空罢了
		// 所以是可以调用字符串对象上的方法的
		// 而上面str没有指向任何对象
		String str2 = "";
		System.out.println(str2.length());

		// 所以 str2.length() == 0 与 "".equals(str2) 其实是一回事

		String str3 = "      ";
		System.out.println(str3.length());
		// 注意trim()函数不会修改原来的字符串，而是返回一个新的字符串
		str3 = str3.trim();
		System.out.println(str3.length());

		// String常用的函数
		String str4 = new String("wo,是,zhong,国,人");
		char charIndex = str4.charAt(2);
		System.out.println(charIndex);

		// 自己要常用这些三元运算符
		// return ((st > 0) || (len < value.length)) ? substring(st, len) :
		// this;

		System.out.println(str4.toString());

		String[] strArray = str4.split(",");
		System.out.println(strArray.toString());
		for (String string : strArray) {
			System.out.println(string);
		}

	}
}
