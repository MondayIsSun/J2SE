package designPatterns.strategyP;

public class DuckTest {

	// ctrl+alt+向下箭头——>复制当前行到下一行

	public static void main(String[] args) {
		System.out.println("测试鸭子程序");
		System.out.println("************************");
		Duck duck = null;
		// duck = new MallardDuck();
		// duck = new RedheadDuck();
		// duck = new RubberDuck();
		// duck = new BigYellow();
		duck = new SpaceDuck();

		duck.display();// 展示鸭子
		duck.quack();// 鸭子会鸣叫
		duck.fly();// 鸭子会飞行
		System.out.println("************************");
		System.out.println("测试完毕");
	}

}
