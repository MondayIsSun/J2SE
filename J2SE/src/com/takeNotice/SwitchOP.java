package com.takeNotice;

public class SwitchOP {

	/**
	 * 面向过程，Console，switch，泛型，代码无错就是优的思考
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		/*
		 * java.io.Console 只能用在标准输入、输出流未被重定向的原始控制台中使用，在 Eclipse 或者其他 IDE
		 * 的控制台是用不了的。
		 */

		// Console cons = System.console();
		// if (cons != null) {
		// // -------------------------
		// PrintWriter printWriter = cons.writer();
		// printWriter.write("input:");
		// cons.flush();
		// // -------------------------
		// String str1 = cons.readLine();
		// // -------------------------
		// cons.format("%s", str1);
		//
		// System.out.println(str1);
		// }

		String strOperator = "妹子";
		// Cannot switch on a value of type T. Only convertible int values,
		// strings or enum variables are permitted
		// switch里面的只能是数值类型的变量---> 这应该是很早之前的JDK版本了
		// 1.7以后的JDK已经支持里面是字符串类的了
		switch (strOperator) {
		case "haha":
			System.out.println('a');
			break;
		case "妹子":
			System.out.println("妹子");
			break;
		default:
			System.out.println("default");
			break;
		}

	}
}
