package generic;

public interface GenericInterface<T> {

	// �ӿڵ��еĳ�Ա����Ĭ����public static final��
	// T name = "admin";
	String name = "admin";

	// Cannot make a static reference to the non-static type T
	// Java�������ѷ������Ϊ��non-static type T(���Ǿ�̬����)

	// ����Ϊʲô��������staticì�ܵ�
	// �ڶ����е�static��ָ���õ���˼
	// ���ڹ��õĳ�Ա���Ի��߷��������ʹ���˷�����ô���Լ�������
	// �������Щ���õĶ����кܶ���֣���ô����ô���ǹ��õ��أ�
	// ������Ϊ�˴��밲ȫ���ΪĿ�ĵ�

	// �����Ǳ���ʱ�Ķ���

}
