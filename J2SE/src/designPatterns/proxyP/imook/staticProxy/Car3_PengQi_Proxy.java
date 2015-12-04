package designPatterns.proxyP.imook.staticProxy;

public class Car3_PengQi_Proxy implements Moveable {

	/**
	 * ���ȣ�Car3�������һ��������
	 * 
	 * ��������ͨ�����캯��ע��Ķ���Ĺ���
	 */

	private Moveable car = null;

	public Car3_PengQi_Proxy(Moveable car) {
		this.car = car;
	}

	@Override
	public void move() {

		System.out.println("����ô���λ���ѽ!");
		System.out.println("��ŭ��...");
		System.out.println("��������ʻ֮ǰ������������...");
		try {
			System.out.println("����������...");
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("����������������ǿ���ȥ�����...");

		car.move();

		System.out.println("������ʻһ�첼���ҳ�������ȥϴ����...");
		try {
			System.out.println("��ϴ����ϴ��...");
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("��ϴ����...");
	}

}
