package designPatterns.adapterP;

public class GBTwoPlug {

	/**
	 * 特别注意不要被代码的固定模式所迷惑
	 * 
	 * 适配器他是一种编程思想，没有特定的代码模式
	 * 
	 * 一般来说，只要是把不兼容的，不匹配的通过某种机制的转化使得他兼容、匹配，这种转化机制就是适配器
	 */

	// 使用二相电流供电
	public void powerWithTwo() {
		System.out.println("使用二相电流供电");
	}
}
