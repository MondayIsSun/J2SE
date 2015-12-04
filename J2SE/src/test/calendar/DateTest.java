package test.calendar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {

		Date d = new Date(); // ---> Wed Mar 18 09:55:47 CST 2015 --->
								// CST����China Standard Time(�й���׼ʱ�䣬Ҳ���Ǳ���ʱ��(������))

		// Date d1 = new Date(2009 - 1900, 3 - 1, 9);
		// d1 = new Date()
		// System.out.println(d1);

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++

		Date d2 = new Date();

		// ���
		int year = d2.getYear() + 1900;
		// �·�
		int month = d2.getMonth() + 1;
		// ����
		int date = d2.getDate();
		// Сʱ
		int hour = d2.getHours();
		// ����
		int minute = d2.getMinutes();
		// ��
		int second = d2.getSeconds();
		// ���ڼ�
		int day = d2.getDay();

		System.out.println(d2);
		System.out.println("��ݣ�" + year);
		System.out.println("�·ݣ�" + month);
		System.out.println("���ڣ�" + date);
		System.out.println("Сʱ��" + hour);
		System.out.println("���ӣ�" + minute);
		System.out.println("�룺" + second);
		System.out.println("���ڣ�" + day);

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++

		// ��Date��Ķ���ת��Ϊ���ʱ��
		Date d3 = new Date();
		System.out.println(d3);
		long t = d3.getTime();
		System.out.println(t);

		// �����ʱ��ת��ΪDate��Ķ���
		Date d4 = new Date(t);
		System.out.println(d4);

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++

		// SimpleDateFormat����-ʱ���ʽģʽ������
		// ��ĸ ���ڻ�ʱ��Ԫ�� ��ʾ ʾ��
		// G Era ��־�� Text AD
		// y �� Year 1996; 96
		// M ���е��·� Month July; Jul; 07
		// w ���е����� Number 27
		// W �·��е����� Number 2
		// D ���е����� Number 189
		// d �·��е����� Number 10
		// F �·��е����� Number 2
		// E �����е����� Text Tuesday; Tue
		// �����ڲ����ʱ���ڱ���oracle�Ƿ������������ڶ�������Oracle�ķ��������Ƿ���Tue.)
		// H һ���е�Сʱ����0-23�� Number 0
		// k һ���е�Сʱ����1-24�� Number 24
		// K am/pm �е�Сʱ����0-11�� Number 0
		// h am/pm �е�Сʱ����1-12�� Number 12
		// m Сʱ�еķ����� Number 30
		// s �����е����� Number 55
		// S ������ Number 978
		// z ʱ�� General time zone Pacific Standard Time; PST; GMT-08:00
		// Z ʱ�� RFC 822 time zone -0800

		SimpleDateFormat CeshiFmt0 = new SimpleDateFormat(
				"Gyyyy��MM��dd�� HHʱmm��ss��");
		SimpleDateFormat CeshiFmt1 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		SimpleDateFormat CeshiFmt2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat CeshiFmt3 = new SimpleDateFormat(
				"yyyy��MM��dd�� HHʱmm��ss�� E ");
		SimpleDateFormat CeshiFmt4 = new SimpleDateFormat("yyyy/MM/dd E");
		SimpleDateFormat CeshiFmt5 = new SimpleDateFormat(
				"һ���еĵ� D �� ����w������ ��һ�����е�W������ ��kʱ zʱ��");

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
