package designPatterns.chainOfResponsibility.imooc.cor.handler;

/*
 * 价格处理人，负责处理客户的折扣申请
 */

/*
 * 思考什么时候用接口什么时候用抽象类
 */

public abstract class PriceHandler {

	protected PriceHandler successor; // successor后继的意思(比如链表当中的后继)，还有就是思考这里使用protected的原因

	protected void setSuccessor(PriceHandler successor) {
		this.successor = successor;
	}

	/*
	 * 处理折扣申请
	 */
	public abstract void processDiscount(float discount);

	//将这个方法移到工厂类当中去实现
	/*
	// 构建责任链的工厂方法
	public static PriceHandler createPriceHandler() {

		PriceHandler sales = new Sales();
		PriceHandler lead = new Lead();
		PriceHandler manager = new Manager();
		PriceHandler director = new Director();
		PriceHandler vicePresident = new VicePresident();
		PriceHandler ceo = new CEO();

		// 指定对象的直接后继
		sales.setSuccessor(lead);
		lead.setSuccessor(manager);
		manager.setSuccessor(director);
		director.setSuccessor(vicePresident);
		vicePresident.setSuccessor(ceo);
		ceo.setSuccessor(null);

		return sales;
	}
	*/

	/**
	 * 思考OOP思想：
	 * 
	 * 在面向对象的设计当中有一个原则就是————>单一职责
	 * 
	 * 意思大概就是在我们设计一个接口的时候，应该只将与这个接口业务相关的方法放在这个接口之中
	 * 
	 * 这样才能使我们设计出的系统更加健壮而不至于当变化发生时手足无措
	 * 
	 * =========================================
	 * 
	 * 而这个接口类当中的processDiscount()和createPriceHandler()这两个方法在功能上是不能聚合在一起的
	 * 
	 * 也就是说我们的这个设计是不符合单一职责原则的
	 * 
	 * =========================================
	 * 
	 * 另外，就Java而言我们希望编程当中做到见名知义
	 * 
	 * 而当程序员看到PriceHandler这个类的时候我估计无论如何都不会想到这里面还有一个工厂方法
	 */

}
