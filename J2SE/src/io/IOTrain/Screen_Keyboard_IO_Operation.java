package io.IOTrain;

import java.io.*;

public class Screen_Keyboard_IO_Operation {

	public static void main(String[] args) {

		// �������� �� ��Ļ��������͵ĵ���ģʽ��

		/*
		 * ��Ļ���̶����Ǵ����豸�����Ŷ�һ��һ����� ����û��Ҫ���ڶ���ܣ�ֻ��Ҫһ����---��������ģʽ�еĵ���ģʽ ���ǵ��͵ĵ���ģʽ
		 * ��������ܱ����Ѿ�����ˣ�û��Ҫ�Լ���ȥ���� �����������һ�þ��У�����Ҳ���ù� �������ϵͳ�ṩ�ģ�������ϵͳ����
		 * ������Systemȥ�����˵�����Ǿ�̬�Ķ����������һ���õ�System�ʹ����ˣ���������Źص�
		 * System.out����PrintStream�ľ���������ʾ���������
		 */

		/*
		 * 
		 * PrintStream writeScreen = System.out; writeScreen.print("ddddd");
		 * 
		 * �ȼ��ڣ�
		 * 
		 * System.out.print("sssss");
		 */

		//
		// InputStream readKeyboard = System.in;
		// int c;
		// try {
		// System.out.print("������һ���ַ���");
		// c = readKeyboard.read();
		// /* һ�����Եļ�������Ĭ�����ûس�����������������ǲ�������س�
		// * ���������System.in.read()�����⣺�������������ĵ�����������
		// * ���ɺܼ򵥲�����
		// */
		// System.out.println("��������ַ��ǣ�"+(char)c);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		// �����ַ��������������
		InputStream i = System.in;
		InputStreamReader ir = new InputStreamReader(i);
		BufferedReader br = new BufferedReader(ir);

		System.out.print("�������ַ���");
		String result = null;
		try {
			result = br.readLine();
			System.out.print("��������ַ��ǣ�" + result);
			// ��java��������ȷʵ���������
		} catch (IOException e) {
			e.printStackTrace();
		}

		// String�ĳ��÷���
		// String result = null;
		// result = "My name is Lmd";
		// System.out.println(result);
		// result = result.trim();// ȥ����ͷ�ͽ�β�Ŀո�
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
