package test.decoratorP.concreteBeverage;

import test.decoratorP.Beverage;

public class HouseBlend extends Beverage {

	public HouseBlend() {
		description = "HouseBlend";
	}

	@Override
	public double cost() {
		// 直接把Espresso的基本价格返回即可
		return .89;
	}

}
