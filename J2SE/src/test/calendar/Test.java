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

		// ��õ��·�Ϊʵ�ʵ��·�ֵ��1����õ����ڵ�ֵ��Date�಻һ������Calendar���У�������1����һ��2���ܶ���3����������
		int day = c.get(Calendar.DAY_OF_WEEK);

		System.out.println(year + "-" + month + "-" + date + "--->" + day);

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		Calendar c3 = Calendar.getInstance();
		// �������10���Ժ������
		c3.add(Calendar.DATE, 10);
		int year1 = c3.get(Calendar.YEAR);
		int month1 = c3.get(Calendar.MONTH) + 1;
		int date1 = c3.get(Calendar.DATE);
		System.out.println(year1 + "��" + month1 + "��" + date1 + "��");

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		// �÷������������жϵ�ǰ���ڶ����Ƿ���when����ĺ��棬�����when����ĺ����򷵻�true�����򷵻�false�����磺
		// public boolean after(Object when)
		Calendar c4 = Calendar.getInstance();
		c4.set(2015, 3 - 1, 18);
		Calendar c5 = Calendar.getInstance();
		c5.set(2015, 3 - 1, 10);
		boolean b = c5.after(c4);
		System.out.println(b);

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		// �÷����������ǽ�Calendar���͵Ķ���ת��Ϊ��Ӧ��Date��������ߴ�����ͬ��ʱ��㡣
		// ���Ƶķ�����setTime���÷����������ǽ�Date����ת��Ϊ��Ӧ��Calendar���󣬸÷������������£�
		// public final void setTime(Date date)
		Date d = new Date();
		Calendar c6 = Calendar.getInstance();
		// Calendar���͵Ķ���ת��ΪDate����
		Date d1 = c6.getTime();
		// Date���͵Ķ���ת��ΪCalendar����
		Calendar c7 = Calendar.getInstance();
		c7.setTime(d);

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		// epoch ���� 1970-01-01 00:00:00.000 ���ʱ��

		Calendar c8 = Calendar.getInstance();
		// long t = 1252785271098L;
		// ��Calendar����ת��Ϊ���ʱ��
		long t1 = c8.getTimeInMillis();
		// �����ʱ��ת��ΪCalendar����
		Calendar c9 = Calendar.getInstance();
		c9.setTimeInMillis(t1);
	}
}
