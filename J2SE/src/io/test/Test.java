package io.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) throws Exception {

		// javaʵ�ְ���enter������ѭ������

		InputStream i = System.in;
		InputStreamReader ir = new InputStreamReader(i);
		BufferedReader br = new BufferedReader(ir);

		System.out.print("�������ַ���");
		String result = null;

		result = br.readLine();

		while (true) {

			if ("".endsWith(result)) {
				System.out.println("��û�������κζ���������������!");
				result = br.readLine();
			} else {
				System.out.println("�������������:" + result);
				break;
			}
		}

		System.out.println("ѭ������!");

	}
}
