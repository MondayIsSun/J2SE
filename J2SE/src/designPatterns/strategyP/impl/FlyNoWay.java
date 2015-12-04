package designPatterns.strategyP.impl;

import designPatterns.strategyP.FlyingStragety;

public class FlyNoWay implements FlyingStragety {

	public void performFly() {
		System.out.println("我不会飞行！");
	}

}
