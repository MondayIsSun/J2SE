package designPatterns.proxyP.imook.staticProxy;

public class Car3_PengQi_Proxy implements Moveable {

	/**
	 * 首先，Car3本身就是一个代理类
	 * 
	 * 他代理了通过构造函数注入的对象的功能
	 */

	private Moveable car = null;

	public Car3_PengQi_Proxy(Moveable car) {
		this.car = car;
	}

	@Override
	public void move() {

		System.out.println("车怎么被刮花了呀!");
		System.out.println("愤怒中...");
		System.out.println("在汽车行驶之前给汽车喷点漆吧...");
		try {
			System.out.println("汽车喷漆中...");
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("汽车喷漆结束，我们可以去兜风喽...");

		car.move();

		System.out.println("汽车行驶一天布满灰尘，我们去洗车吧...");
		try {
			System.out.println("在洗车店洗车...");
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("车洗完了...");
	}

}
