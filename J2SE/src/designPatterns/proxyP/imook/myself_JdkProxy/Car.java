package designPatterns.proxyP.imook.myself_JdkProxy;

public class Car implements Moveable {

	@Override
	public void move() {

		// 实现开车
		try {
			System.out.println("汽车行驶中...");
			// Thread.sleep(new Random().nextInt(1000));
			// new Random().nextInt(10000产生10以内的随机数)
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void fly() {
		System.out.println("汽车开始飞行...");
	}

}
