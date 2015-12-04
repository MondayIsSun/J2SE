package designPatterns.proxyP.imook.staticProxy;

public class Car4_ChildrenPlay_Proxy implements Moveable {

	private Moveable car = null;

	public Car4_ChildrenPlay_Proxy(Moveable car) {
		this.car = car;
	}

	@Override
	public void move() {

		System.out.println("过年了，一群小朋友们在一辆豪华轿车旁边放鞭炮...");
		try {
			System.out.println("小朋友们玩得可开心了...");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("小朋友回家吃饭了...");

		car.move();

		System.out.println("付钱给洗车店的老板...");
	}

}
