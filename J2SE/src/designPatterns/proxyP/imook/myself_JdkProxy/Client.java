package designPatterns.proxyP.imook.myself_JdkProxy;

public class Client {

	/**
	 * ≤‚ ‘¿‡
	 * 
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		Car c = new Car();

		InvocationHandler h = new TimeHandler(c);

		Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class, h);

		
		m.move();

	}

}
