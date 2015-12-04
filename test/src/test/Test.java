package test;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public enum IcPlayerID {

		DEFAULT("默认值", -1), // 没有通过DebugUtilsActivity改变Module的默认Module
		HDKT("互动课堂Module", 0), // 通过DebugUtilsActivity使用互动课堂Module
		XUEKE("学科Module", 1), // 通过DebugUtilsActivity使用学科Module
		XIAMEN("厦门Module", 2);// 通过DebugUtilsActivity使用厦门Module

		private String module;
		private int sp_id;

		IcPlayerID(String module, int sp_id) {
			this.module = module;
			this.sp_id = sp_id;
			// 201509210001
		}
	}

	public static String modifyOneDigitSeatNum(String seatNum) {
		if (seatNum.matches("^[0-9]*$")) {
			if (seatNum.matches("^\\d$")) {
				seatNum = "0" + seatNum;
			}
		} else {
			System.out.print("NaN");
		}
		return seatNum;
	}

	public static void main(String[] args) {
		// System.out.println(IcPlayerID.DEFAULT.module + " = " +
		// IcPlayerID.DEFAULT.sp_id);
		// System.out.println(modifyOneDigitSeatNum("12345t"));
		// System.out.println(modifyOneDigitSeatNum("09287462"));
		// System.out.println(modifyOneDigitSeatNum("1"));
		// System.out.println(modifyOneDigitSeatNum("2"));
		// System.out.println(modifyOneDigitSeatNum("32"));
		// System.out.println(modifyOneDigitSeatNum("2124"));
		// System.out.println(modifyOneDigitSeatNum("124g566"));

		// for (int i = 0; i < 10000; i++) {
		// //System.out.println((Math.random()));
		// System.out.println((int)(Math.random()*1));
		// }

		// LinkedList<String> mTaskQueue = new LinkedList<>();
		// mTaskQueue.add("test");
		// System.out.println(mTaskQueue.removeFirst());

		// java信号量机制
		ExecutorService exec = Executors.newCachedThreadPool();// 线程池
		final Semaphore semp = new Semaphore(5);// 只能5个线程同时访问

		for (int index = 0; index < 20; index++) {// 模拟20个客户端访问
			final int NO = index;
			Runnable run = new Runnable() {
				public void run() {
					try {
						semp.acquire();// 获取许可
						System.out.println("Accessing: " + NO);
						Thread.sleep((long) (Math.random() * 10000));
						semp.release();// 访问完后，释放
						System.out.println("-----------------" + semp.availablePermits());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			exec.execute(run);
		}
		// 退出线程池
		exec.shutdown();
	}
}
