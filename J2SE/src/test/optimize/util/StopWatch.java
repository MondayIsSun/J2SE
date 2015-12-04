package test.optimize.util;

/**
 * 秒表类，用于计算执行时间 注意该类是非线程安全的
 *
 */
public class StopWatch {

//	private static final String DEFAULT_TASK_NAME = "defaultTask";
//	private String taskName;
//	private long start, end;
//	private boolean hasStarted, hasEnded;
//
//	// 时间单位枚举：毫秒、秒和分钟
//	public enum TimeUnit {
//		MILLI, SECOND, MINUTE
//	}
//
//	public StopWatch() {
//		this(DEFAULT_TASK_NAME);
//	}
//
//	public StopWatch(String taskName) {
//		this.taskName = StringUtil.isEmpty(taskName) ? DEFAULT_TASK_NAME
//				: taskName;
//	}
//
//	public void start() {
//		start = System.currentTimeMillis();
//		hasStarted = true;
//	}
//
//	public void end() {
//		if (!hasStarted) {
//			throw new IllegalOperationException(
//					"调用StopWatch的end()方法之前请先调用start()方法");
//		}
//		end = System.currentTimeMillis();
//		hasEnded = true;
//	}
//
//	public void clear() {
//		this.start = 0;
//		this.end = 0;
//
//		this.hasStarted = false;
//		this.hasEnded = false;
//	}
//
//	/**
//	 * 获取总耗时，单位为毫秒
//	 * 
//	 * @return 消耗的时间，单位为毫秒
//	 */
//	public long getEclapsedMillis() {
//		if (!hasEnded) {
//			throw new IllegalOperationException("请先调用end()方法");
//		}
//
//		return (end - start);
//	}
//
//	/**
//	 * 获取总耗时，单位为秒
//	 * 
//	 * @return 消耗的时间，单位为秒
//	 */
//	public long getElapsedSeconds() {
//		return this.getEclapsedMillis() / 1000;
//	}
//
//	/**
//	 * 获取总耗时，单位为分钟
//	 * 
//	 * @return 消耗的时间，单位为分钟
//	 */
//	public long getElapsedMinutes() {
//		return this.getEclapsedMillis() / (1000 * 60);
//	}
//
//	public void setTaskName(String taskName) {
//		this.taskName = StringUtil.isEmpty(taskName) ? DEFAULT_TASK_NAME
//				: taskName;
//	}
//
//	public String getTaskName() {
//		return this.taskName;
//	}
//
//	/**
//	 * 输出任务耗时情况，单位默认为毫秒
//	 */
//	public void printEclapseDetail() {
//		this.printEclapseDetail(TimeUnit.MILLI);
//	}
//
//	/**
//	 * 输出任务耗时情况，可以指定毫秒、秒和分钟三种时间单位
//	 * 
//	 * @param timeUnit
//	 *            时间单位
//	 */
//	public void printEclapseDetail(TimeUnit timeUnit) {
//		switch (timeUnit) {
//		case MILLI:
//			System.out.println(this.getTaskName() + "任务耗时（毫秒）："
//					+ this.getEclapsedMillis());
//			break;
//		case SECOND:
//			System.out.println(this.getTaskName() + "任务耗时（秒）："
//					+ this.getElapsedSeconds());
//			break;
//		case MINUTE:
//			System.out.println(this.getTaskName() + "任务耗时（分钟）："
//					+ this.getElapsedMinutes());
//			break;
//		default:
//			System.out.println(this.getTaskName() + "任务耗时（毫秒）："
//					+ this.getEclapsedMillis());
//		}
//	}

}
