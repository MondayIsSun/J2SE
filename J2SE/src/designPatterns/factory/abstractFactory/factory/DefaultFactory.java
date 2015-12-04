package designPatterns.factory.abstractFactory.factory;

import designPatterns.factory.abstractFactory.products.AK47;
import designPatterns.factory.abstractFactory.products.Apple;
import designPatterns.factory.abstractFactory.products.Car;
import designPatterns.factory.abstractFactory.products.Food;
import designPatterns.factory.abstractFactory.products.Vehicle;
import designPatterns.factory.abstractFactory.products.Weapon;

public class DefaultFactory extends AbstractFactory {

	@Override
	public Food createFood() {
		return new Apple();
	}

	@Override
	public Vehicle createVehicle() {
		return new Car();
	}

	@Override
	public Weapon createWeapon() {
		return new AK47();
	}

}
