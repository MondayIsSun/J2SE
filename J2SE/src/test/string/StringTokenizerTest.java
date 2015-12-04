package test.string;

import java.util.Random;
import java.util.StringTokenizer;

public class StringTokenizerTest {

	// StringTokenizer ---> ����˼�壺�ַ����ִ���

	/**
	 * ����Ŀ���ַ���
	 * 
	 * eg��10.123.12.154.154
	 * 
	 * @param len
	 *            Ŀ���ַ�������(ÿ����3����������)
	 * @return
	 */
	public static String getOriginStr(int len) {
		StringBuffer sb = new StringBuffer();
		StringBuffer result = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < len; i++) {
			sb.append(random.nextInt(9)).append(random.nextInt(9)).append(random.nextInt(9));
			result.append(sb.toString());
			sb.delete(0, sb.length());
			if (i != len - 1)
				result.append(".");
		}

		return result.toString();
	}

	public static void main(String args[]) {

		String orginStr = getOriginStr(10);

		// ////////////String.splic()����//////////////////////////////////////////////
		System.out.println("ʹ��String.splic()���з��ַ���");
		long st1 = System.nanoTime();
		String[] result = orginStr.split("\\.");
		System.out.println("String.splic()��ȡ�ַ�����ʱ��" + (System.nanoTime() - st1));
		System.out.println("String.splic()��ȡ�ַ������������" + result.length);
		System.out.println();

		// ////////////StringTokenizer����//////////////////////////////////////////////
		System.out.println("ʹ��StringTokenizer���з��ַ���");
		long st3 = System.nanoTime();
		StringTokenizer token = new StringTokenizer(orginStr, ".");
		System.out.println("StringTokenizer��ȡ�ַ�����ʱ:" + (System.nanoTime() - st3));
		System.out.println("StringTokenizer��ȡ�ַ������������" + token.countTokens());
		System.out.println();

		// //////////////////String.substring()����//////////////////////////////////////////

		long st5 = System.nanoTime();
		int len = orginStr.lastIndexOf(".");
		System.out.println("ʹ��String.substring()�з��ַ���");
		int k = 0, count = 0;

		for (int i = 0; i <= len; i++) {
			if (orginStr.substring(i, i + 1).equals(".")) {
				if (count == 0) {
					orginStr.substring(0, i);
				} else {
					orginStr.substring(k + 1, i);
					if (i == len) {
						orginStr.substring(len + 1, orginStr.length());
					}
				}
				k = i;
				count++;
			}
		}
		System.out.println("String.substring()��ȡ�ַ�����ʱ" + (System.nanoTime() - st5));
		System.out.println("String.substring()��ȡ�ַ������������" + (count + 1));
	}
}
