package com.takeNotice;

public class SwitchOP {

	/**
	 * ������̣�Console��switch�����ͣ������޴�����ŵ�˼��
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		/*
		 * java.io.Console ֻ�����ڱ�׼���롢�����δ���ض����ԭʼ����̨��ʹ�ã��� Eclipse �������� IDE
		 * �Ŀ���̨���ò��˵ġ�
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

		String strOperator = "����";
		// Cannot switch on a value of type T. Only convertible int values,
		// strings or enum variables are permitted
		// switch�����ֻ������ֵ���͵ı���---> ��Ӧ���Ǻ���֮ǰ��JDK�汾��
		// 1.7�Ժ��JDK�Ѿ�֧���������ַ��������
		switch (strOperator) {
		case "haha":
			System.out.println('a');
			break;
		case "����":
			System.out.println("����");
			break;
		default:
			System.out.println("default");
			break;
		}

	}
}
