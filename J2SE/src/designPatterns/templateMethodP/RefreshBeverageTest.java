package designPatterns.templateMethodP;

public class RefreshBeverageTest {

	public static void main(String[] args) {

		System.out.println("�Ʊ��ڿ���...");

		RefreshBeverage b1 = new Coffe();

		b1.prepareBeverageTemplate();

		System.out.println("���Ⱥ��ˣ�");

		System.out.println("----------------------");

		System.out.println("�Ʊ�ţ�̿���...");

		RefreshBeverage b2 = new CoffeMilk();

		b2.prepareBeverageTemplate();

		System.out.println("���Ⱥ��ˣ�");

		System.out.println("----------------------");

		System.out.println("�Ʊ���...");

		RefreshBeverage b3 = new Tea();

		b2.prepareBeverageTemplate();

		System.out.println("���ݺ��ˣ�");

	}

}
