package designPatterns.templateMethodP;

public class RefreshBeverageTest {

	public static void main(String[] args) {

		System.out.println("制备黑咖啡...");

		RefreshBeverage b1 = new Coffe();

		b1.prepareBeverageTemplate();

		System.out.println("咖啡好了！");

		System.out.println("----------------------");

		System.out.println("制备牛奶咖啡...");

		RefreshBeverage b2 = new CoffeMilk();

		b2.prepareBeverageTemplate();

		System.out.println("咖啡好了！");

		System.out.println("----------------------");

		System.out.println("制备茶...");

		RefreshBeverage b3 = new Tea();

		b2.prepareBeverageTemplate();

		System.out.println("茶泡好了！");

	}

}
