package designPatterns.proxyP.imook.staticProxy;

public class Car2_Security_Proxy extends Car_Time_Proxy {

	/**
	 * ���ȣ�Car2�������һ�����������������ͨ���̳ж����ĸ����еĹ���
	 */

	@Override
	public void move() {

		// ��������
		System.out.println("���������а�ȫ�������...");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("����û�й��ϣ������ϸ���·��...");

		super.move();

		// ��ϴ����
		System.out.println("������ʻ��һ���ˣ���Ҫȥϴ����ϴϴ...");
	}

}
