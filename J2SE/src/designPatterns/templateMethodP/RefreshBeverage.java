package designPatterns.templateMethodP;

/*
 * 抽象基类，为所有子类提供一个算法框架
 * 
 * 提神饮料
 */
public abstract class RefreshBeverage {

	/*
	 * 使用final关键字的作用是：
	 * 
	 * 这个抽象类是为子类的提供算法框架而禁止子类对算法框架做任何的改变
	 * 
	 * 所以要使用final关键字表示这个方法是不允许被重写的
	 */

	/*
	 * 制备饮料的模板方法
	 * 
	 * 封装子类共同遵循的算法框架
	 */
	public final void prepareBeverageTemplate() {

		// 步骤1 将水煮沸
		boilWater();

		// 步骤2 泡制饮料
		brew();

		// 步骤3 将饮料导入杯中
		pourInCup();

		if (isCustomerWantsCondiments()) {
			// 步骤4 加入调味料
			addCondiments();
		}

	}

	// ------------------------------------------------------

	// 钩子方法
	/*
	 * 询问用户是否插入调料
	 * 
	 * Hook，钩子函数，提供一个默认或者空的实现
	 * 
	 * 具体子类可以自行决定是否挂钩以及如何挂钩
	 * 
	 * 询问用户是否加入调料
	 */

	/*
	 * protected的作用就是使得子类可以看见并且可以自己决定是否复写它
	 * 
	 * 钩子的意思就是，子类可以决定是否自己去复写他，那么就相当于钩住了子类
	 * 
	 * 不复写就是没有钩住了子类，那么是采用父类默认的业务逻辑
	 * 
	 * 提供给子类选择可以自行选择的挂钩点
	 * 
	 * 一旦子类选择挂钩，那么子类只需要在自己当中复写这个钩子方法即可
	 */
	protected boolean isCustomerWantsCondiments() {
		return true;
	}

	// ------------------------------------------------------

	/*
	 * 基本方法 将水煮沸
	 * 
	 * 因为是模板当中共用的步骤
	 * 
	 * private向下屏蔽的细节
	 * 
	 * 所以使用private关键字，这样做的好处是：
	 * 
	 * 在子类当中只要把焦点放在自己要实现的方法上，没有必要让子类看见父类当中的公用操作
	 */
	private void boilWater() {
		System.out.println("将水煮沸");

	}

	/*
	 * 使用protected或者说是默认的访问权限关键字
	 * 
	 * 需要延迟到子类实现的,abstract,protected
	 * 
	 * 因为这个地方需要让不同的子类来实现它，所以是子类可见的
	 */

	// 泡制饮料
	protected abstract void brew();

	/*
	 * 基本方法 将饮料倒入杯中
	 */
	private void pourInCup() {
		System.out.println("倒入杯中");

	}

	// 加入调味料
	protected abstract void addCondiments();

}
