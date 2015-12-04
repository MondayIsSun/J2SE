package designPatterns.strategyP;

import designPatterns.strategyP.impl.FlyNoWay;

public class RubberDuck extends Duck {

	// 橡胶鸭

	public RubberDuck() {
		super();
		// 设置飞行策略
		// 设置飞行策略为不会飞行
		super.setFlyingStragety(new FlyNoWay());
	}

	@Override
	public void display() {
		System.out.println("我全身发黄，嘴巴很红");
	}

	// 橡胶鸭的叫声和普通鸭子的叫声不同，所以我们要复写它的quack方法
	public void quack() {
		System.out.println("嘎~嘎~嘎~");
	}

}
