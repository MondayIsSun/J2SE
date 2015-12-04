package designPatterns.factory.abstractFactory.factory;

import designPatterns.factory.abstractFactory.products.Food;
import designPatterns.factory.abstractFactory.products.Vehicle;
import designPatterns.factory.abstractFactory.products.Weapon;

public abstract class AbstractFactory {

	public abstract Vehicle createVehicle();

	public abstract Weapon createWeapon();

	public abstract Food createFood();
}