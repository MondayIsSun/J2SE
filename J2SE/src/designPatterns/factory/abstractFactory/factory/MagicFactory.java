package designPatterns.factory.abstractFactory.factory;

import designPatterns.factory.abstractFactory.products.Broom;
import designPatterns.factory.abstractFactory.products.Food;
import designPatterns.factory.abstractFactory.products.MagicStick;
import designPatterns.factory.abstractFactory.products.MushRoom;
import designPatterns.factory.abstractFactory.products.Vehicle;
import designPatterns.factory.abstractFactory.products.Weapon;

public class MagicFactory extends AbstractFactory {

	@Override
	public Food createFood() {
		return new MushRoom();
	}

	@Override
	public Vehicle createVehicle() {
		return new Broom();
	}

	@Override
	public Weapon createWeapon() {
		return new MagicStick();
	}

}
