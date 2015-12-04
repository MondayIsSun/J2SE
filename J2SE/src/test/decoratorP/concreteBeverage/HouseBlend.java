package test.decoratorP.concreteBeverage;

import test.decoratorP.Beverage;

public class HouseBlend extends Beverage {

	public HouseBlend() {
		description = "HouseBlend";
	}

	@Override
	public double cost() {
		// ֱ�Ӱ�Espresso�Ļ����۸񷵻ؼ���
		return .89;
	}

}
