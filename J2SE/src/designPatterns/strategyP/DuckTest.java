package designPatterns.strategyP;

public class DuckTest {

	// ctrl+alt+���¼�ͷ����>���Ƶ�ǰ�е���һ��

	public static void main(String[] args) {
		System.out.println("����Ѽ�ӳ���");
		System.out.println("************************");
		Duck duck = null;
		// duck = new MallardDuck();
		// duck = new RedheadDuck();
		// duck = new RubberDuck();
		// duck = new BigYellow();
		duck = new SpaceDuck();

		duck.display();// չʾѼ��
		duck.quack();// Ѽ�ӻ�����
		duck.fly();// Ѽ�ӻ����
		System.out.println("************************");
		System.out.println("�������");
	}

}
