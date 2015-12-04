package com.finally_return;

public class Test_1 {

	public static void main(String[] args) {
		System.out.print(tt());
	}

	public static int tt() {

		int b = 23;

		try {
			//1、
			System.out.println("yes");
			//2、b += 88
			return b += 88;
		} catch (Exception e) {
			System.out.println("error      :      " + e);
		} finally {
			//3、
			if (b > 25) {
				System.out.println("b>25      :      " + b);
			}
			//4、
			System.out.println("finally");
		}

		// finally后面的代码不会执行到
		System.out.println("hahahha-->" + b + 10);
		return b;
	}
}