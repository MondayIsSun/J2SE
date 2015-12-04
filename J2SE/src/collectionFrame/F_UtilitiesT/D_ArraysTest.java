package collectionFrame.F_UtilitiesT;

import java.util.Arrays;
import java.util.List;

public class D_ArraysTest {

	public static void main(String[] args) {

		String[] strArray = { "b", "a", "d", "e", "c" };

		// ʹ�ö��ַ���������
		System.out.println(Arrays.binarySearch(strArray, "e"));
		// �������������
		Arrays.sort(strArray);// ���Ҫ��������Ļ������Դ���һ���Ƚ����Ĳ���

		// ����������ӡ����
		System.out.println(strArray);

		for (String str : strArray) {
			System.out.print(str + "\t");
		}
		System.out.println();

		// �Ƚ���������ʹ��
		B_StringComparator strComparator = new B_StringComparator();
		Arrays.sort(strArray, strComparator);

		for (String str : strArray) {
			System.out.print(str + "\t");
		}
		System.out.println();

		// ������ת��ΪList
		List<String> sList = Arrays.asList(strArray);

		// sList.add("f");//�ᱨ�����ԭ�����������ķ�ʽ��õ�List���Ϲ̶���С

		System.out.println(sList + "\t" + sList.size());

	}

}
