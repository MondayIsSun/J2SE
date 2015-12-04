package test.decoratorP.concreteCondiment;

import test.decoratorP.Beverage;
import test.decoratorP.CondimentDecorator;

public class Mocha extends CondimentDecorator {

	Beverage beverage;

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + " + Mocha";
	}

	@Override
	public double cost() {
		// 需要额外计算Mocha调料的价格
		return .20 + beverage.cost();
	}

}
