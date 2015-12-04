package designPatterns.strategyP;

/*
 * 策略接口，实现鸭子的飞行行为
 */

/*
 * 注意在策略模式当中
 * 
 * 有了策略接口之后一般就需要在基类当中去组合它
 */

public interface FlyingStragety {

	void performFly();
}
