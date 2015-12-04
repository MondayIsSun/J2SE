package designPatterns.chainOfResponsibility.imooc.cor.handler;

/*
 * ������Ա��������׼5%���ڵ��ۿ�
 */

public class Sales extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if (discount <= 0.05) {
			System.out.format("%s��׼���ۿ�:%.2f%n", this.getClass().getName(),
					discount);
		} else {
			// ����ý�ɫ��Ȩ��׼�ͻ�������ۿۣ����ͻ����ۿ��������ϴ���
			successor.processDiscount(discount);
		}

	}

}
