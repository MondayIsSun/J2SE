package designPatterns.factory.abstractFactory;

import designPatterns.factory.abstractFactory.factory.AbstractFactory;
import designPatterns.factory.abstractFactory.factory.DefaultFactory;
import designPatterns.factory.abstractFactory.products.Food;
import designPatterns.factory.abstractFactory.products.Vehicle;
import designPatterns.factory.abstractFactory.products.Weapon;

public class Test {
	public static void main(String[] args) {
		// DefaultFactory f = new DefaultFactory();
		AbstractFactory f = new DefaultFactory();
		Vehicle v = f.createVehicle();
		v.run();
		Weapon w = f.createWeapon();
		w.shoot();
		Food a = f.createFood();
		a.printName();
	}
}
