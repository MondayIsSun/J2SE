package designPatterns.factory.SimpleFactory.factory;

import designPatterns.factory.SimpleFactory.Car;
import designPatterns.factory.SimpleFactory.Moveable;

public class CarFactory extends VehicleFactory{
	public Moveable create() {
		return new Car();
	}
}
