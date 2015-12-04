package designPatterns.proxyP.imook.staticProxy;

public class Client {

	public static void main(String[] args) {

		// ����ͨ��������ʻ����
		Car_Time_Proxy car = new Car_Time_Proxy();
		car.move();

		System.out.println();
		System.out.println("=============================================");
		System.out.println();

		// ʹ�ü̳�ʵ�ֵĴ���
		/**
		 * ˼��ʹ�ü̳�ʵ�ֵľ�̬����Ļ���:
		 * 
		 * ���ȣ����Ҫ��ԭ�д���ǰ��Ļ������ٶ�������������ô����Ҫ�ٴ�ʹ�ü̳�
		 * 
		 * ��Σ������ͬ�Ĺ��ܵ���Ҫ����ǰ��˳���Ǹ����첻���ģ���ֻ�����¼̳���д����
		 * 
		 * ʹ�ü̳еķ�ʽʵ�ֵĴ����ڲ����й���������ϵ��ӵ�ʱ��᲻�ϵس��ּ̳�
		 * 
		 * ����ʹ�ü̳з�ʽʵ�ֵĴ�����ô�ᵼ�´������п������޵�������ȥ
		 */
		Car2_Security_Proxy car2 = new Car2_Security_Proxy();
		car2.move();

		System.out.println();
		System.out.println("=============================================");
		System.out.println();

		// ʹ�þۺ�ʵ�ֵĴ���
		/**
		 * ʹ�þۺ�ʵ�ִ���ĺô����ڱ�������Ϊ�����й���������ϵ��ӵ�ʱ����ֵĴ���������
		 * 
		 * ֻ��Ҫ���ݸ���ͬ�Ĵ������ʱ���޸�һ�´��ݵ�˳�򼴿�
		 * 
		 * ��ʹ�þۺϵķ�ʽʵ�ֵĸ��ִ���֮���ǿ���������ϵ�
		 * 
		 * ��������һ�Ҫʵ�ֶ�̹�˵Ĵ����أ�
		 * 
		 * ��ô�ۺ�Ҳ��û�а취ʵ�ֵ�
		 * 
		 * ����Ƕ�̬����Ҫ�������
		 * 
		 * ���Ҿ�̬����Ҳû�а취���ͬһ���൱���ж��������Ҫ��������
		 * 
		 */
		Car3_PengQi_Proxy car3 = new Car3_PengQi_Proxy(car);
		car3.move();

		System.out.println();
		System.out.println("=============================================");
		System.out.println();

		Car4_ChildrenPlay_Proxy car4 = new Car4_ChildrenPlay_Proxy(car3);
		car4.move();

		System.out.println();
		System.out.println("=============================================");
		System.out.println();

		// �ۺ�������Ĺ��ܵĵ���
		// ������
		// С����
		// ������ʻ
		Car3_PengQi_Proxy carJUHE = new Car3_PengQi_Proxy(
				new Car4_ChildrenPlay_Proxy(car));
		carJUHE.move();
	}

}
