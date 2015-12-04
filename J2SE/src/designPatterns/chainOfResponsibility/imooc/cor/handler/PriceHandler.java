package designPatterns.chainOfResponsibility.imooc.cor.handler;

/*
 * �۸����ˣ�������ͻ����ۿ�����
 */

/*
 * ˼��ʲôʱ���ýӿ�ʲôʱ���ó�����
 */

public abstract class PriceHandler {

	protected PriceHandler successor; // successor��̵���˼(���������еĺ��)�����о���˼������ʹ��protected��ԭ��

	protected void setSuccessor(PriceHandler successor) {
		this.successor = successor;
	}

	/*
	 * �����ۿ�����
	 */
	public abstract void processDiscount(float discount);

	//����������Ƶ������൱��ȥʵ��
	/*
	// �����������Ĺ�������
	public static PriceHandler createPriceHandler() {

		PriceHandler sales = new Sales();
		PriceHandler lead = new Lead();
		PriceHandler manager = new Manager();
		PriceHandler director = new Director();
		PriceHandler vicePresident = new VicePresident();
		PriceHandler ceo = new CEO();

		// ָ�������ֱ�Ӻ��
		sales.setSuccessor(lead);
		lead.setSuccessor(manager);
		manager.setSuccessor(director);
		director.setSuccessor(vicePresident);
		vicePresident.setSuccessor(ceo);
		ceo.setSuccessor(null);

		return sales;
	}
	*/

	/**
	 * ˼��OOP˼�룺
	 * 
	 * ������������Ƶ�����һ��ԭ����ǡ�������>��һְ��
	 * 
	 * ��˼��ž������������һ���ӿڵ�ʱ��Ӧ��ֻ��������ӿ�ҵ����صķ�����������ӿ�֮��
	 * 
	 * ��������ʹ������Ƴ���ϵͳ���ӽ�׳�������ڵ��仯����ʱ�����޴�
	 * 
	 * =========================================
	 * 
	 * ������ӿ��൱�е�processDiscount()��createPriceHandler()�����������ڹ������ǲ��ܾۺ���һ���
	 * 
	 * Ҳ����˵���ǵ��������ǲ����ϵ�һְ��ԭ���
	 * 
	 * =========================================
	 * 
	 * ���⣬��Java��������ϣ����̵�����������֪��
	 * 
	 * ��������Ա����PriceHandler������ʱ���ҹ���������ζ������뵽�����滹��һ����������
	 */

}
