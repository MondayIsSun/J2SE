package designPatterns.proxyP.imook.staticProxy;

public class Car4_ChildrenPlay_Proxy implements Moveable {

	private Moveable car = null;

	public Car4_ChildrenPlay_Proxy(Moveable car) {
		this.car = car;
	}

	@Override
	public void move() {

		System.out.println("�����ˣ�һȺС��������һ�������γ��Ա߷ű���...");
		try {
			System.out.println("С��������ÿɿ�����...");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("С���ѻؼҳԷ���...");

		car.move();

		System.out.println("��Ǯ��ϴ������ϰ�...");
	}

}
