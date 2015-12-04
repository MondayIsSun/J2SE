package designPatterns.chainOfResponsibility.imooc.cor;

import java.util.Random;

import designPatterns.chainOfResponsibility.imooc.cor.handler.PriceHandler;
import designPatterns.chainOfResponsibility.imooc.cor.handler.PriceHandlerFactory;

/*
 * 客户，请求折扣
 */
public class Customer {

	// 业务层暴露给客户的接口
	private PriceHandler priceHandler;

	public void setPriceHandler(PriceHandler priceHandler) {
		this.priceHandler = priceHandler;
	}

	public void requestDiscount(float discount) {
		// 注意客户只是关心这个折扣请求是否被处理了，而不关心这个折扣请求是由谁处理的
		priceHandler.processDiscount(discount);
	}

	public static void main(String[] args) {

		Customer customer = new Customer();

		// 理解好各个模块之间的可见度

		// 需要一个工厂函数来为handler构造他的整个责任链，这个对客户来说是透明的
		// 所以不应该由客户代码来实现
		// customer.setPriceHandler(PriceHandler.createPriceHandler());
		customer.setPriceHandler(PriceHandlerFactory.createPriceHandler());

		// customer开始申请折扣
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			System.out.println(i + ":");
			customer.requestDiscount(rand.nextFloat());
		}

	}
}
