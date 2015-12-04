package designPatterns.chainOfResponsibility.imooc.cor;

import java.util.Random;

import designPatterns.chainOfResponsibility.imooc.cor.handler.PriceHandler;
import designPatterns.chainOfResponsibility.imooc.cor.handler.PriceHandlerFactory;

/*
 * �ͻ��������ۿ�
 */
public class Customer {

	// ҵ��㱩¶���ͻ��Ľӿ�
	private PriceHandler priceHandler;

	public void setPriceHandler(PriceHandler priceHandler) {
		this.priceHandler = priceHandler;
	}

	public void requestDiscount(float discount) {
		// ע��ͻ�ֻ�ǹ�������ۿ������Ƿ񱻴����ˣ�������������ۿ���������˭�����
		priceHandler.processDiscount(discount);
	}

	public static void main(String[] args) {

		Customer customer = new Customer();

		// ���ø���ģ��֮��Ŀɼ���

		// ��Ҫһ������������Ϊhandler������������������������Կͻ���˵��͸����
		// ���Բ�Ӧ���ɿͻ�������ʵ��
		// customer.setPriceHandler(PriceHandler.createPriceHandler());
		customer.setPriceHandler(PriceHandlerFactory.createPriceHandler());

		// customer��ʼ�����ۿ�
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			System.out.println(i + ":");
			customer.requestDiscount(rand.nextFloat());
		}

	}
}
