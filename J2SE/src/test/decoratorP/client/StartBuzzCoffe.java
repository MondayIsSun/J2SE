package test.decoratorP.client;

import test.decoratorP.Beverage;
import test.decoratorP.concreteBeverage.Espresso;
import test.decoratorP.concreteCondiment.Mocha;

public class StartBuzzCoffe {

	public static void main(String[] args) {

		// what Beverage do you want?

		// I want a cup of Espresso with nothing
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " $" + beverage.cost());

		// I want a cup of Espresso with Mocha
		Beverage beverage2 = new Espresso();
		beverage2 = new Mocha(beverage2);
		System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

	}

}
