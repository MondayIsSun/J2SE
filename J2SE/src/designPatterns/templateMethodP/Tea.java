package designPatterns.templateMethodP;

public class Tea extends RefreshBeverage {

	/*
	 * �������࣬�ṩ���Ʊ���ľ�������
	 * 
	 * (non-Javadoc)
	 * 
	 * @see designPatterns.templateMethodP.RefreshBeverage#brew()
	 */
	@Override
	protected void brew() {
		System.out.println("��80�ȵ���ˮ���ݲ�Ҷ5����");

	}

	@Override
	protected void addCondiments() {
		System.out.println("��������");
	}

	// ѯ�ʲ�Ҫ�����ζ�ϵĹ��Ӻ���
	@Override
	protected boolean isCustomerWantsCondiments() {
		// ��Ҫ�����ʲ�
		return true;
	}

}
