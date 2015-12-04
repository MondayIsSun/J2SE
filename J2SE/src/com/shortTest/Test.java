package com.shortTest;

public class Test {

	@SuppressWarnings({ "unused" })
	public static void main(String[] args) {

		short a = 1;// 不会报编译错误，但其实已经把a自动类型转化为int类型了

		// short b = b+1;
		// 会出现编译错误，原因，b+1的时候b会自动被转换成int类型，而将int类型赋值给short类型肯定会报错

		// 默认是int
		short m = (short) 1;
		long md = 1L;
		long mi = 1l;

		// short c = 0;
		// c++;
		// 下面是错误的理解：
		// 也是会出现编译错误，原因也是，在进行c++的运算的时候类似于short类型的c与int类型的1运算，c会自动被转换成int,
		// 最后int类型的c又会赋值给short类型的c,所以必然报错

		// short dh;
		// dh++;
		// 这个报的实际上是没有初始化的编译时异常

		/****************************************************************************/

		// int d;
		// System.out.println(d++);
		// 会报编译时错误，原因是在某个变量参与运算之前需要初始化，即使他会有默认值

		// int e;
		// e = e + 1;
		// 会报编译时错误，原因是在某个变量参与运算之前需要初始化，即使他会有默认值

		// int g;
		// System.out.println(g);
		// 也就是说必须初始化？
		// 在这个变量被使用之前必须赋值或者初始化他

		// for(int i;i<2;i++){
		//
		// }
		// 也是提示必须初始化的编译时错误

		/****************************************************************************/

		// ++c，c++
		int h = 0;
		System.out.println(++h);// 1
		System.out.println(h++);// 1
		h = 0;
		System.out.println(h = ++h);// 1
		System.out.println(h = h++);// 1

		h = 0;

		// 两个=
		while (++h < 3) {
			System.out.println("=");
		}

		h = 0;

		// 三个*
		while (h++ < 3) {
			System.out.println("*");
		}

		/****************************************************************************/

		// Test_2
		// Math.round()的处理就是加上0.5以后取整数部分
		// 原来的数字加上0.5后再向下取整
		// System.out.println("总结：正数小数点后大于5则舍入，负数小数点后小于以及等于5都舍去，反之舍入");
		// System.out.println("也就是说：小数点后大于5全部加，等于5正数加，小于5全不加");
		// System.out.println(Math.round(12.5));
		// System.out.println(Math.round(12.4));
		// System.out.println(Math.round(-12.5));
		// System.out.println(Math.round(-12.9));
		//
		// System.out.println(Math.round(12.56));
		// System.out.println(Math.round(12.46));

		System.out.println(Math.random());// [0.0,1.0)

		System.out.println(Math.round(-12.5));
		System.out.println(Math.round(-12.9));

		System.out.println(Math.floor(1.4));
		System.out.println(Math.floor(-1.4));
		System.out.println(Math.ceil(-1.4));
		System.out.println(Math.ceil(1.4));

		// String问题
		// String str_1 = "abc";
		// String str_2 = "abc";
		// System.out.println(str_1 == str_2);//true

		String str_1 = "a";
		String str_2 = "b";
		
		String str_5 = "ab";
		String str_3 = str_1 + str_2;//堆？
		String str_4 = "a" + "b";
		
		String str_6 = new String("ab");

		System.out.println(str_3 == str_4);// false
		System.out.println(str_4 == str_5);// true
		System.out.println(str_3 == str_5);// false

		/*
		 * string 对象的创建: String name1="my";是放在内存常量区中 方式1: string对象是放在常量池中的一块内存地址
		 * 放置之前先检查该区域是否已经放有该常量,如果有,直接返回地址
		 * 
		 * 方式2:String name3=new String("my"); 这个是放在堆内存里面的,创建出来的对象是不相等的,因为内存地址不一样
		 * 
		 * 
		 * String特点: 1、由于字符串底层是由一个字符数组来实现的，所以String是不可变的 2、String
		 * 重写了Object的hashCode方法 == 表示比较的是地址
		 * 
		 * String 常用的方法:
		 */

		// String str_1 = "abc";

	}

	/****************************************************************************/

	public void testM() {
		// int i;
		// System.out.println(i);
		// 确实现在都需要初始化了
		// 正确的理解应该是，在这个变量被使用之前一定要进行赋值初始化操作
	}

}
