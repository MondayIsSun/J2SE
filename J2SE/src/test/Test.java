package test;

public class Test {

	public static void main(String[] args) {

		// ���Դ�������Ĵ�����ʾ
		// ��Ҫ��֪ʶ����ʵ��ʹ�����try...catch ����ȷ��׽����쳣����������һ����Χ��������쳣����

		int[] intArray = { 0, 0, 0, 0, 0, 0, 1 };
		int result = -1;

		int i = 0;
		for (i = 0; i < intArray.length; i++) {
			try {
				result = 2 / intArray[i];
				// beak���������ǵ�һ�δ����ɹ��Ϳ��Բ���ѭ��������
				break;
			} catch (Exception e) {
				// �������쳣
			}
		}
		System.out.println(result != -1 ? "�����ɹ���" : "����ʧ�ܣ�");
	}
}
