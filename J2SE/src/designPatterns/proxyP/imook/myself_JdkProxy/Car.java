package designPatterns.proxyP.imook.myself_JdkProxy;

public class Car implements Moveable {

	@Override
	public void move() {

		// ʵ�ֿ���
		try {
			System.out.println("������ʻ��...");
			// Thread.sleep(new Random().nextInt(1000));
			// new Random().nextInt(10000����10���ڵ������)
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void fly() {
		System.out.println("������ʼ����...");
	}

}
