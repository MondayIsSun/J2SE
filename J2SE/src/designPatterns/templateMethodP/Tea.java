package designPatterns.templateMethodP;

public class Tea extends RefreshBeverage {

	/*
	 * 具体子类，提供了制备茶的具体子类
	 * 
	 * (non-Javadoc)
	 * 
	 * @see designPatterns.templateMethodP.RefreshBeverage#brew()
	 */
	@Override
	protected void brew() {
		System.out.println("用80度的热水浸泡茶叶5分钟");

	}

	@Override
	protected void addCondiments() {
		System.out.println("加入柠檬");
	}

	// 询问茶要加入调味料的钩子函数
	@Override
	protected boolean isCustomerWantsCondiments() {
		// 我要喝柠檬茶
		return true;
	}

}
