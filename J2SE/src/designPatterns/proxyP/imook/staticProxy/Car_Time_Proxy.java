package designPatterns.proxyP.imook.staticProxy;

public class Car_Time_Proxy implements Moveable {

	@Override
	public void move() {

		/**
		 * ����ʹ������ͨ�ķ�ʽʵ�ֵļ�¼������ʻʱ�������
		 */

		/**
		 * ��������д�Ĵ���̫��ά�����������
		 * 
		 * �����Ժ���Ҫ��¼�Ĳ�����������̹����ʻ��ʱ��
		 * 
		 * ������Ҫ��������ʻ��֮ǰ��һЩ�����İ�ȫ���ȵ�һЩ����
		 */

		/**
		 * ʹ�ü̳еķ�ʽ
		 * 
		 * ʹ�þۺϵķ�ʽ
		 * 
		 */

		long starttime = System.currentTimeMillis();

		System.out.println("������ʼ��ʻ...");

		// ʵ�ֿ���
		try {
			System.out.println("������ʻ��...");
			// Thread.sleep(new Random().nextInt(1000));
			// new Random().nextInt(10000����10���ڵ������)
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long endtime = System.currentTimeMillis();

		System.out.println("����������ʻ...");
		System.out.println("������ʻʱ��:" + (endtime - starttime) + "����!");
	}

}
