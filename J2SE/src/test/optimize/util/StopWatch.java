package test.optimize.util;

/**
 * ����࣬���ڼ���ִ��ʱ�� ע������Ƿ��̰߳�ȫ��
 *
 */
public class StopWatch {

//	private static final String DEFAULT_TASK_NAME = "defaultTask";
//	private String taskName;
//	private long start, end;
//	private boolean hasStarted, hasEnded;
//
//	// ʱ�䵥λö�٣����롢��ͷ���
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
//					"����StopWatch��end()����֮ǰ���ȵ���start()����");
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
//	 * ��ȡ�ܺ�ʱ����λΪ����
//	 * 
//	 * @return ���ĵ�ʱ�䣬��λΪ����
//	 */
//	public long getEclapsedMillis() {
//		if (!hasEnded) {
//			throw new IllegalOperationException("���ȵ���end()����");
//		}
//
//		return (end - start);
//	}
//
//	/**
//	 * ��ȡ�ܺ�ʱ����λΪ��
//	 * 
//	 * @return ���ĵ�ʱ�䣬��λΪ��
//	 */
//	public long getElapsedSeconds() {
//		return this.getEclapsedMillis() / 1000;
//	}
//
//	/**
//	 * ��ȡ�ܺ�ʱ����λΪ����
//	 * 
//	 * @return ���ĵ�ʱ�䣬��λΪ����
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
//	 * ��������ʱ�������λĬ��Ϊ����
//	 */
//	public void printEclapseDetail() {
//		this.printEclapseDetail(TimeUnit.MILLI);
//	}
//
//	/**
//	 * ��������ʱ���������ָ�����롢��ͷ�������ʱ�䵥λ
//	 * 
//	 * @param timeUnit
//	 *            ʱ�䵥λ
//	 */
//	public void printEclapseDetail(TimeUnit timeUnit) {
//		switch (timeUnit) {
//		case MILLI:
//			System.out.println(this.getTaskName() + "�����ʱ�����룩��"
//					+ this.getEclapsedMillis());
//			break;
//		case SECOND:
//			System.out.println(this.getTaskName() + "�����ʱ���룩��"
//					+ this.getElapsedSeconds());
//			break;
//		case MINUTE:
//			System.out.println(this.getTaskName() + "�����ʱ�����ӣ���"
//					+ this.getElapsedMinutes());
//			break;
//		default:
//			System.out.println(this.getTaskName() + "�����ʱ�����룩��"
//					+ this.getEclapsedMillis());
//		}
//	}

}
