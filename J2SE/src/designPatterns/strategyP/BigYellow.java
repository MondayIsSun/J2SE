package designPatterns.strategyP;

import designPatterns.strategyP.impl.FlyNoWay;

public class BigYellow extends Duck {

	// 大黄鸭

	public BigYellow() {
		super();
		super.setFlyingStragety(new FlyNoWay());
	}

	@Override
	public void display() {
		System.out.println("我身体很大，全身黄黄");
	}

	// 注意这里的大黄鸭是不会叫的，但是由于继承的关系大黄鸭就是会叫，所以比较笨的方法就是你还得去复写它的quack方法实现为不会叫
	// 但是学习完使用策略模式来改造我们的鸭子以后你就应该懂得使用策略模式来改造鸭子的鸣叫能力了

}
