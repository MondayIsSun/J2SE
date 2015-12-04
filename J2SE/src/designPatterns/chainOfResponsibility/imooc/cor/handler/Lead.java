package designPatterns.chainOfResponsibility.imooc.cor.handler;

/*
 * 看看这个模式是如何应付变化的
 */

public class Lead extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if (discount <= 0.15) {
			System.out.format("%s批准了折扣:%.2f%n", this.getClass().getName(),
					discount);
		} else {
			successor.processDiscount(discount);
		}

	}

}
