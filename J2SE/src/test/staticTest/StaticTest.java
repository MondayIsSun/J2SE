package test.staticTest;

/**
 * ���ߵ��������:��̬��������Զ�ִ�е�; ��̬�����Ǳ����õ�ʱ���ִ�е�.
 * 
 * @author Administrator
 *
 */
public class StaticTest {

	// ��һ�γ���������ʱ��������Щ��
	// ����������ж���
	// ��Ա����
	// ��Ա����
	// ��̬��Ա����
	// ��̬��Ա����
	// �ڲ���
	// ����
	// ���캯��

	public static String nationality;

	public String name;
	public int age;

	// ��̬�����
	// ȷʵ�ǵ�һ�γ���������ʱ��̬����ξ�ִ����
	// ͬʱ����֪����̬���Ա�static����θ������
	// ���Դ�����������һ���ܳٵ��¶�
	static {
		nationality = "china";
		System.out.println("static{ ... }");
	}

	// ��̬����
	public static void myMethod() {
		nationality = "american";
		System.out.println("static method");
	}

}
