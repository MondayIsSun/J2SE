package designPatterns.proxyP.imook.staticProxy;

public class Car_Time_Proxy implements Moveable {

	@Override
	public void move() {

		/**
		 * 这是使用最普通的方式实现的记录汽车行驶时间的做法
		 */

		/**
		 * 但是这样写的代码太难维护，不灵活了
		 * 
		 * 比如以后我要记录的不是汽车而是坦克行驶的时间
		 * 
		 * 或者我要在汽车行驶的之前做一些汽车的安全检查等等一些操作
		 */

		/**
		 * 使用继承的方式
		 * 
		 * 使用聚合的方式
		 * 
		 */

		long starttime = System.currentTimeMillis();

		System.out.println("汽车开始行驶...");

		// 实现开车
		try {
			System.out.println("汽车行驶中...");
			// Thread.sleep(new Random().nextInt(1000));
			// new Random().nextInt(10000产生10以内的随机数)
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long endtime = System.currentTimeMillis();

		System.out.println("汽车结束行驶...");
		System.out.println("汽车行驶时间:" + (endtime - starttime) + "毫秒!");
	}

}
