package designPatterns.proxyP.imook.staticProxy;

public class Car2_Security_Proxy extends Car_Time_Proxy {

	/**
	 * 首先，Car2本身就是一个代理对象，他代理了通过继承而来的父类中的功能
	 */

	@Override
	public void move() {

		// 汽车安检
		System.out.println("对汽车进行安全隐患检查...");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("汽车没有故障，可以上高速路了...");

		super.move();

		// 清洗汽车
		System.out.println("汽车行驶了一天了，需要去洗车场洗洗...");
	}

}
