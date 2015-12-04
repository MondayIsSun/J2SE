package designPatterns.factory.SimpleFactory.factory;

import designPatterns.factory.SimpleFactory.Moveable;
import designPatterns.factory.SimpleFactory.Plane;

public class PlaneFactory extends VehicleFactory {
	public Moveable create() {
		return new Plane();
	}
}
