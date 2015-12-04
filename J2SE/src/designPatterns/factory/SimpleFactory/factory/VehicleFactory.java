package designPatterns.factory.SimpleFactory.factory;

import designPatterns.factory.SimpleFactory.Moveable;

public abstract class VehicleFactory {
	abstract public Moveable create();
}
