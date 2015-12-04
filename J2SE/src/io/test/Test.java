package io.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) throws Exception {

		// java实现按下enter键结束循环控制

		InputStream i = System.in;
		InputStreamReader ir = new InputStreamReader(i);
		BufferedReader br = new BufferedReader(ir);

		System.out.print("请输入字符：");
		String result = null;

		result = br.readLine();

		while (true) {

			if ("".endsWith(result)) {
				System.out.println("你没有输入任何东西，请重新输入!");
				result = br.readLine();
			} else {
				System.out.println("你输入的内容是:" + result);
				break;
			}
		}

		System.out.println("循环结束!");

	}
}
