package effectiveJava;

import java.util.ArrayList;
import java.util.List;

public class EffecttiveJava {

	public static void main(String[] args) {

		/**
		 * �ڶ��󴴽��׶Σ�ϵͳҪͨ������Ĳ��裬��ɶ���Ĵ�������
		 * 
		 * ��1��Ϊ�������洢�ռ䡣
		 * 
		 * ��2����ʼ�������
		 * 
		 * ��3���ݹ�����䳬��Ĺ��췽����
		 * 
		 * ��4�����ж���ʵ����ʼ���������ʼ����
		 * 
		 * ��5��ִ�й��췽���塣
		 */

		// ������ѭ�����д������󣬼�ʹ�ö���ռ���ڴ�ռ䲻��
		List<Object> strL = new ArrayList<Object>();
		Object obj = null;
		for (int i = 0; i < 10; i++) {
			obj = new String("str_" + i);
			strL.add(obj);
		}

		System.out.println(strL.size());

		System.out.println(strL);

		// �����ַ����������ʱӦ��
		// StringBuffer(�̰߳�ȫ)����
		// StringBuilder(���̰߳�ȫ)����
		StringBuilder strBuilder = null;

		// ����ʹ����ϣ�Ӧ�ֶ��ó�null

		// lazy loading
		// int i = 0;
		// String str = "aaa";
		// if (i == 1) {
		// strL.add(str);
		// }

		int i = 0;
		if (i == 1) {
			String str = "aaa";
			strL.add(str);
		}

		// �쳣ֻ�����ڴ�������Ӧ���������Ƴ�������
		// ����ע�ⲻҪ��ѭ����ʹ�ã�try...catch...

	}
}
