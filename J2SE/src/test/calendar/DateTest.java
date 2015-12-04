package test.calendar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {

		Date d = new Date(); // ---> Wed Mar 18 09:55:47 CST 2015 --->
								// CST代表China Standard Time(中国标准时间，也就是北京时间(东八区))

		// Date d1 = new Date(2009 - 1900, 3 - 1, 9);
		// d1 = new Date()
		// System.out.println(d1);

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++

		Date d2 = new Date();

		// 年份
		int year = d2.getYear() + 1900;
		// 月份
		int month = d2.getMonth() + 1;
		// 日期
		int date = d2.getDate();
		// 小时
		int hour = d2.getHours();
		// 分钟
		int minute = d2.getMinutes();
		// 秒
		int second = d2.getSeconds();
		// 星期几
		int day = d2.getDay();

		System.out.println(d2);
		System.out.println("年份：" + year);
		System.out.println("月份：" + month);
		System.out.println("日期：" + date);
		System.out.println("小时：" + hour);
		System.out.println("分钟：" + minute);
		System.out.println("秒：" + second);
		System.out.println("星期：" + day);

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++

		// 将Date类的对象转换为相对时间
		Date d3 = new Date();
		System.out.println(d3);
		long t = d3.getTime();
		System.out.println(t);

		// 将相对时间转换为Date类的对象
		Date d4 = new Date(t);
		System.out.println(d4);

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++

		// SimpleDateFormat日期-时间格式模式参数：
		// 字母 日期或时间元素 表示 示例
		// G Era 标志符 Text AD
		// y 年 Year 1996; 96
		// M 年中的月份 Month July; Jul; 07
		// w 年中的周数 Number 27
		// W 月份中的周数 Number 2
		// D 年中的天数 Number 189
		// d 月份中的天数 Number 10
		// F 月份中的星期 Number 2
		// E 星期中的天数 Text Tuesday; Tue
		// （我在部署的时候在本机oracle是返回星期是星期二，而在Oracle的服务器上是返回Tue.)
		// H 一天中的小时数（0-23） Number 0
		// k 一天中的小时数（1-24） Number 24
		// K am/pm 中的小时数（0-11） Number 0
		// h am/pm 中的小时数（1-12） Number 12
		// m 小时中的分钟数 Number 30
		// s 分钟中的秒数 Number 55
		// S 毫秒数 Number 978
		// z 时区 General time zone Pacific Standard Time; PST; GMT-08:00
		// Z 时区 RFC 822 time zone -0800

		SimpleDateFormat CeshiFmt0 = new SimpleDateFormat(
				"Gyyyy年MM月dd日 HH时mm分ss秒");
		SimpleDateFormat CeshiFmt1 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		SimpleDateFormat CeshiFmt2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat CeshiFmt3 = new SimpleDateFormat(
				"yyyy年MM月dd日 HH时mm分ss秒 E ");
		SimpleDateFormat CeshiFmt4 = new SimpleDateFormat("yyyy/MM/dd E");
		SimpleDateFormat CeshiFmt5 = new SimpleDateFormat(
				"一年中的第 D 天 ，第w个星期 ，一个月中第W个星期 ，k时 z时区");

		Date now = new Date();
		System.out.println(CeshiFmt0.format(now));
		System.out.println(CeshiFmt1.format(now));
		System.out.println(CeshiFmt2.format(now));
		System.out.println(CeshiFmt3.format(now));
		System.out.println(CeshiFmt4.format(now));
		System.out.println(CeshiFmt5.format(now));

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++
	}

}
