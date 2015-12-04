package io.IOTrain;

import java.io.*;

public class Screen_Keyboard_IO_Operation {

	public static void main(String[] args) {

		// 键盘输入 和 屏幕输出（典型的单例模式）

		/*
		 * 屏幕键盘都是是串行设备，即排队一个一个输出 所以没必要存在多根管，只需要一根管---这就是设计模式中的单例模式 这是典型的单例模式
		 * 而且这根管别人已经造好了，没必要自己再去创造 而且这根管你一用就有，用完也不用关 这根管是系统提供的，存在于系统类中
		 * 可以用System去点出来说明它是静态的东西，代码第一次用到System就存在了，程序结束才关掉
		 * System.out返回PrintStream的就是链接显示器的输出流
		 */

		/*
		 * 
		 * PrintStream writeScreen = System.out; writeScreen.print("ddddd");
		 * 
		 * 等价于：
		 * 
		 * System.out.print("sssss");
		 */

		//
		// InputStream readKeyboard = System.in;
		// int c;
		// try {
		// System.out.print("请输入一个字符：");
		// c = readKeyboard.read();
		// /* 一般语言的键盘输入默认你敲回车就算输入结束，但是不会读到回车
		// * 但是这个流System.in.read()有问题：遇到输入是中文的情况会出问题
		// * 理由很简单不解释
		// */
		// System.out.println("你输入的字符是："+(char)c);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		// 输入字符串，并反序输出
		InputStream i = System.in;
		InputStreamReader ir = new InputStreamReader(i);
		BufferedReader br = new BufferedReader(ir);

		System.out.print("请输入字符：");
		String result = null;
		try {
			result = br.readLine();
			System.out.print("你输入的字符是：" + result);
			// 但java处理中文确实会存在问题
		} catch (IOException e) {
			e.printStackTrace();
		}

		// String的常用方法
		// String result = null;
		// result = "My name is Lmd";
		// System.out.println(result);
		// result = result.trim();// 去掉开头和结尾的空格
		// System.out.println(result);
		// String[] strArr = result.split(" ");
		//
		// String temp = "";
		//
		// for (int i = strArr.length - 1; i >= 0; i--) {
		// String str = strArr[i].trim();
		// System.out.println(strArr[i]);
		// temp = temp + str + " ";
		// }
		// System.out.println(temp);
		//
		// System.out.println(result.charAt(0));

	}

}
