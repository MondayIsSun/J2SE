package designPatterns.chainOfResponsibility.imooc.cor.handler;

/*
 * 销售人员，可以批准5%以内的折扣
 */

public class Sales extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if (discount <= 0.05) {
			System.out.format("%s批准了折扣:%.2f%n", this.getClass().getName(),
					discount);
		} else {
			// 否则该角色无权批准客户请求的折扣，将客户的折扣请求向上处理
			successor.processDiscount(discount);
		}

	}

}
