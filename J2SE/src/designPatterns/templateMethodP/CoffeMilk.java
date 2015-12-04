package designPatterns.templateMethodP;

public class CoffeMilk extends RefreshBeverage {

	/*
	 * �������࣬�ṩ�˿����Ʊ��ľ���ʵ�� (non-Javadoc)
	 * 
	 * @see designPatterns.templateMethodP.RefreshBeverage#brew()
	 */
	@Override
	protected void brew() {
		System.out.println("�÷�ˮ���ݿ���");

	}

	@Override
	protected void addCondiments() {
		System.out.println("�����Ǻ�ţ��");
	}

	// ѯ�ʿ����Ƿ�Ҫ�����ζ�ϵĹ��Ӻ���
	@Override
	protected boolean isCustomerWantsCondiments() {
		// ��Ҫ��ţ�̿���
		return true;
	}

}
