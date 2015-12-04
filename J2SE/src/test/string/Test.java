package test.string;

import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) {

		// a thread-safe
		StringBuffer sBuffer = new StringBuffer();

		// with no guarantee of synchronization ---> not a thread-safe
		StringBuilder stringBuilder = new StringBuilder();

		//
		String str = new String();
		str = "   abc,defg,hijkl,mn   ";

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++

		// valueOf函数的作用是 ---> 将某种数据类型转换成字符串
		String.valueOf("10");
		// 同样地也可以将字符串转换成某种数据类型
		// Byte.parseByte(String s);

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++

		System.out.println(str.charAt(1));
		System.out.println(str.concat("12345"));
		System.out.println(str.endsWith("ef"));
		System.out.println(str.indexOf('b'));
		System.out.println(str.indexOf("efg"));
		System.out.println(str.lastIndexOf('b'));
		System.out.println(str.lastIndexOf("abc"));

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++

		String[] strArr = str.split(",");
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++

		System.out.println("substring ---> " + str.substring(2, str.length()));

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++

		System.out.println(str.trim());

		System.out.println(str.replace(' ', ' '));
		System.out.println(str);

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++

		// StringTokenizer ---> 字符串分词器
		String s = new String("The Java platform is the ideal platform for network computing");
		StringTokenizer st = new StringTokenizer(s);
		System.out.println("Token Total: " + st.countTokens());
		while (st.hasMoreElements()) {
			System.out.println(st.nextToken());
		}

		String s1 = new String("The1=Java2=platform3=is4=the5=ideal6=platform7=for8=network9=computing10");
		StringTokenizer st1 = new StringTokenizer(s1, "=", true);
		System.out.println("Token Total: " + st1.countTokens());
		while (st1.hasMoreElements()) {
			System.out.println(st1.nextToken());
		}
	}

}
