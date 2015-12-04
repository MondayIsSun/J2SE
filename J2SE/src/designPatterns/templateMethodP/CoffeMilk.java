package designPatterns.templateMethodP;

public class CoffeMilk extends RefreshBeverage {

	/*
	 * 具体子类，提供了咖啡制备的具体实现 (non-Javadoc)
	 * 
	 * @see designPatterns.templateMethodP.RefreshBeverage#brew()
	 */
	@Override
	protected void brew() {
		System.out.println("用沸水冲泡咖啡");

	}

	@Override
	protected void addCondiments() {
		System.out.println("加入糖和牛奶");
	}

	// 询问咖啡是否要加入调味料的钩子函数
	@Override
	protected boolean isCustomerWantsCondiments() {
		// 我要喝牛奶咖啡
		return true;
	}

}
