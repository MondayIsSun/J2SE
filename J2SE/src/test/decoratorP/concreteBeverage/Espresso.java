package test.decoratorP.concreteBeverage;

import test.decoratorP.Beverage;

public class Espresso extends Beverage {

	public Espresso() {
		description = "Espresso";
	}

	@Override
	public double cost() {
		// 不需要管调料的价钱，直接把Espresso的基本价格返回即可
		return 1.99;
	}

}
