package designPatterns.factory.SimpleFactory.factory;

import designPatterns.factory.SimpleFactory.Broom;
import designPatterns.factory.SimpleFactory.Moveable;

public class BroomFactory extends VehicleFactory{
	public Moveable create() {
		return new Broom();
	}
}
