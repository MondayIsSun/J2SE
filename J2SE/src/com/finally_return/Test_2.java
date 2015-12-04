package com.finally_return;

public class Test_2 {

	public static void main(String[] args) {
		System.out.print(tt());
	}

	@SuppressWarnings("finally")
	public static int tt() {

		int b = 23;

		try {
			System.out.println("yes");
			return b += 88;
		} catch (Exception e) {
			System.out.println("error      :      " + e);
		} finally {
			if (b > 25) {
				System.out.println("b>25      :      " + b);
			}
			System.out.println("finally");
			return 100;
		}

	}

}
