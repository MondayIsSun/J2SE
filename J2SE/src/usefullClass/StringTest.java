package usefullClass;

public class StringTest {

	public static void main(String[] args) {

		// String str = null;
		// if (str == null) {
		// // NullPointerException
		// // �ڿյĶ�������û���κη�����
		// // ����ܺ����ѽ������ֵ��null�˱�ʾ������û��ָ���κζ����ˣ���������ô֪������ʲô�����أ�
		// System.out.println(str.length());
		// }

		// ע���������������ַ�ʽ���б��������
		// ���str2ȷʵָ����һ���ַ�������ֻ������ַ��������ϵ�����Ϊ�հ���
		// �����ǿ��Ե����ַ��������ϵķ�����
		// ������strû��ָ���κζ���
		String str2 = "";
		System.out.println(str2.length());

		// ���� str2.length() == 0 �� "".equals(str2) ��ʵ��һ����

		String str3 = "      ";
		System.out.println(str3.length());
		// ע��trim()���������޸�ԭ�����ַ��������Ƿ���һ���µ��ַ���
		str3 = str3.trim();
		System.out.println(str3.length());

		// String���õĺ���
		String str4 = new String("wo,��,zhong,��,��");
		char charIndex = str4.charAt(2);
		System.out.println(charIndex);

		// �Լ�Ҫ������Щ��Ԫ�����
		// return ((st > 0) || (len < value.length)) ? substring(st, len) :
		// this;

		System.out.println(str4.toString());

		String[] strArray = str4.split(",");
		System.out.println(strArray.toString());
		for (String string : strArray) {
			System.out.println(string);
		}

	}
}
