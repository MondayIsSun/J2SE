package com.shortTest;

public class Test {

	@SuppressWarnings({ "unused" })
	public static void main(String[] args) {

		short a = 1;// ���ᱨ������󣬵���ʵ�Ѿ���a�Զ�����ת��Ϊint������

		// short b = b+1;
		// ����ֱ������ԭ��b+1��ʱ��b���Զ���ת����int���ͣ�����int���͸�ֵ��short���Ϳ϶��ᱨ��

		// Ĭ����int
		short m = (short) 1;
		long md = 1L;
		long mi = 1l;

		// short c = 0;
		// c++;
		// �����Ǵ������⣺
		// Ҳ�ǻ���ֱ������ԭ��Ҳ�ǣ��ڽ���c++�������ʱ��������short���͵�c��int���͵�1���㣬c���Զ���ת����int,
		// ���int���͵�c�ֻḳֵ��short���͵�c,���Ա�Ȼ����

		// short dh;
		// dh++;
		// �������ʵ������û�г�ʼ���ı���ʱ�쳣

		/****************************************************************************/

		// int d;
		// System.out.println(d++);
		// �ᱨ����ʱ����ԭ������ĳ��������������֮ǰ��Ҫ��ʼ������ʹ������Ĭ��ֵ

		// int e;
		// e = e + 1;
		// �ᱨ����ʱ����ԭ������ĳ��������������֮ǰ��Ҫ��ʼ������ʹ������Ĭ��ֵ

		// int g;
		// System.out.println(g);
		// Ҳ����˵�����ʼ����
		// �����������ʹ��֮ǰ���븳ֵ���߳�ʼ����

		// for(int i;i<2;i++){
		//
		// }
		// Ҳ����ʾ�����ʼ���ı���ʱ����

		/****************************************************************************/

		// ++c��c++
		int h = 0;
		System.out.println(++h);// 1
		System.out.println(h++);// 1
		h = 0;
		System.out.println(h = ++h);// 1
		System.out.println(h = h++);// 1

		h = 0;

		// ����=
		while (++h < 3) {
			System.out.println("=");
		}

		h = 0;

		// ����*
		while (h++ < 3) {
			System.out.println("*");
		}

		/****************************************************************************/

		// Test_2
		// Math.round()�Ĵ�����Ǽ���0.5�Ժ�ȡ��������
		// ԭ�������ּ���0.5��������ȡ��
		// System.out.println("�ܽ᣺����С��������5�����룬����С�����С���Լ�����5����ȥ����֮����");
		// System.out.println("Ҳ����˵��С��������5ȫ���ӣ�����5�����ӣ�С��5ȫ����");
		// System.out.println(Math.round(12.5));
		// System.out.println(Math.round(12.4));
		// System.out.println(Math.round(-12.5));
		// System.out.println(Math.round(-12.9));
		//
		// System.out.println(Math.round(12.56));
		// System.out.println(Math.round(12.46));

		System.out.println(Math.random());// [0.0,1.0)

		System.out.println(Math.round(-12.5));
		System.out.println(Math.round(-12.9));

		System.out.println(Math.floor(1.4));
		System.out.println(Math.floor(-1.4));
		System.out.println(Math.ceil(-1.4));
		System.out.println(Math.ceil(1.4));

		// String����
		// String str_1 = "abc";
		// String str_2 = "abc";
		// System.out.println(str_1 == str_2);//true

		String str_1 = "a";
		String str_2 = "b";
		
		String str_5 = "ab";
		String str_3 = str_1 + str_2;//�ѣ�
		String str_4 = "a" + "b";
		
		String str_6 = new String("ab");

		System.out.println(str_3 == str_4);// false
		System.out.println(str_4 == str_5);// true
		System.out.println(str_3 == str_5);// false

		/*
		 * string ����Ĵ���: String name1="my";�Ƿ����ڴ泣������ ��ʽ1: string�����Ƿ��ڳ������е�һ���ڴ��ַ
		 * ����֮ǰ�ȼ��������Ƿ��Ѿ����иó���,�����,ֱ�ӷ��ص�ַ
		 * 
		 * ��ʽ2:String name3=new String("my"); ����Ƿ��ڶ��ڴ������,���������Ķ����ǲ���ȵ�,��Ϊ�ڴ��ַ��һ��
		 * 
		 * 
		 * String�ص�: 1�������ַ����ײ�����һ���ַ�������ʵ�ֵģ�����String�ǲ��ɱ�� 2��String
		 * ��д��Object��hashCode���� == ��ʾ�Ƚϵ��ǵ�ַ
		 * 
		 * String ���õķ���:
		 */

		// String str_1 = "abc";

	}

	/****************************************************************************/

	public void testM() {
		// int i;
		// System.out.println(i);
		// ȷʵ���ڶ���Ҫ��ʼ����
		// ��ȷ�����Ӧ���ǣ������������ʹ��֮ǰһ��Ҫ���и�ֵ��ʼ������
	}

}
