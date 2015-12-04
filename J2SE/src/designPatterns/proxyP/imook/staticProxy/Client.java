package designPatterns.proxyP.imook.staticProxy;

public class Client {

	public static void main(String[] args) {

		// 最普通的汽车行驶功能
		Car_Time_Proxy car = new Car_Time_Proxy();
		car.move();

		System.out.println();
		System.out.println("=============================================");
		System.out.println();

		// 使用继承实现的代理
		/**
		 * 思考使用继承实现的静态代理的坏处:
		 * 
		 * 首先，如果要在原有代理前后的基础上再额外新增服务，那么又需要再次使用继承
		 * 
		 * 其次，如果不同的功能点需要调换前后顺序是根本办不到的，你只能重新继承重写代码
		 * 
		 * 使用继承的方式实现的代理在不断有功能排列组合叠加的时候会不断地出现继承
		 * 
		 * 所以使用继承方式实现的代理，那么会导致代理类有可能无限地膨胀下去
		 */
		Car2_Security_Proxy car2 = new Car2_Security_Proxy();
		car2.move();

		System.out.println();
		System.out.println("=============================================");
		System.out.println();

		// 使用聚合实现的代理
		/**
		 * 使用聚合实现代理的好处在于避免了因为不断有功能排列组合叠加的时候出现的代理类膨胀
		 * 
		 * 只需要传递给不同的代理类的时候修改一下传递的顺序即可
		 * 
		 * 即使用聚合的方式实现的各种代理之间是可以随意组合的
		 * 
		 * 但是如果我还要实现对坦克的代理呢？
		 * 
		 * 那么聚合也是没有办法实现的
		 * 
		 * 这就是动态代理要解决的了
		 * 
		 * 而且静态代理也没有办法解决同一个类当中有多个方法需要代理的情况
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

		// 聚合随意更改功能的叠加
		// 先喷漆
		// 小孩玩
		// 汽车行驶
		Car3_PengQi_Proxy carJUHE = new Car3_PengQi_Proxy(
				new Car4_ChildrenPlay_Proxy(car));
		carJUHE.move();
	}

}
