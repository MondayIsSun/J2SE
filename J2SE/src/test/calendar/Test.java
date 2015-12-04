package test.calendar;

import java.util.Calendar;
import java.util.Date;

public class Test {

	public static void main(String[] args) {

		Calendar c = Calendar.getInstance();

		// ????
		// c.setLenient();

		c.set(2015, 2, 15);
		
		//???
		c.setFirstDayOfWeek(Calendar.MONDAY);

		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);

		// 获得的月份为实际的月份值减1，获得的星期的值和Date类不一样。在Calendar类中，周日是1，周一是2，周二是3，依次类推
		int day = c.get(Calendar.DAY_OF_WEEK);

		System.out.println(year + "-" + month + "-" + date + "--->" + day);

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		Calendar c3 = Calendar.getInstance();
		// 计算今天10天以后的日期
		c3.add(Calendar.DATE, 10);
		int year1 = c3.get(Calendar.YEAR);
		int month1 = c3.get(Calendar.MONTH) + 1;
		int date1 = c3.get(Calendar.DATE);
		System.out.println(year1 + "年" + month1 + "月" + date1 + "日");

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		// 该方法的作用是判断当前日期对象是否在when对象的后面，如果在when对象的后面则返回true，否则返回false。例如：
		// public boolean after(Object when)
		Calendar c4 = Calendar.getInstance();
		c4.set(2015, 3 - 1, 18);
		Calendar c5 = Calendar.getInstance();
		c5.set(2015, 3 - 1, 10);
		boolean b = c5.after(c4);
		System.out.println(b);

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		// 该方法的作用是将Calendar类型的对象转换为对应的Date类对象，两者代表相同的时间点。
		// 类似的方法是setTime，该方法的作用是将Date对象转换为对应的Calendar对象，该方法的声明如下：
		// public final void setTime(Date date)
		Date d = new Date();
		Calendar c6 = Calendar.getInstance();
		// Calendar类型的对象转换为Date对象
		Date d1 = c6.getTime();
		// Date类型的对象转换为Calendar对象
		Calendar c7 = Calendar.getInstance();
		c7.setTime(d);

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		// epoch 就是 1970-01-01 00:00:00.000 这个时刻

		Calendar c8 = Calendar.getInstance();
		// long t = 1252785271098L;
		// 将Calendar对象转换为相对时间
		long t1 = c8.getTimeInMillis();
		// 将相对时间转换为Calendar对象
		Calendar c9 = Calendar.getInstance();
		c9.setTimeInMillis(t1);
	}
}
