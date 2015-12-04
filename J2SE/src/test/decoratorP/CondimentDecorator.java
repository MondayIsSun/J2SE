package test.decoratorP;


//CondimentDecorator 调料装饰类
public abstract class CondimentDecorator extends Beverage {

	// Condiment 调料

	// 注意需要重写实现这个方法为abstract
	@Override
	public abstract String getDescription();

}