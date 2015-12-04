package test.decoratorP.concreteBeverage;

import test.decoratorP.Beverage;

public class Espresso extends Beverage {

	public Espresso() {
		description = "Espresso";
	}

	@Override
	public double cost() {
		// ����Ҫ�ܵ��ϵļ�Ǯ��ֱ�Ӱ�Espresso�Ļ����۸񷵻ؼ���
		return 1.99;
	}

}
