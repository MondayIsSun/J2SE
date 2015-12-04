package effectiveJava;

import java.util.ArrayList;
import java.util.List;

public class EffecttiveJava {

	public static void main(String[] args) {

		/**
		 * 在对象创建阶段，系统要通过下面的步骤，完成对象的创建过程
		 * 
		 * （1）为对象分配存储空间。
		 * 
		 * （2）开始构造对象。
		 * 
		 * （3）递归调用其超类的构造方法。
		 * 
		 * （4）进行对象实例初始化与变量初始化。
		 * 
		 * （5）执行构造方法体。
		 */

		// 避免在循环体中创建对象，即使该对象占用内存空间不大
		List<Object> strL = new ArrayList<Object>();
		Object obj = null;
		for (int i = 0; i < 10; i++) {
			obj = new String("str_" + i);
			strL.add(obj);
		}

		System.out.println(strL.size());

		System.out.println(strL);

		// 出现字符串连接情况时应用
		// StringBuffer(线程安全)或者
		// StringBuilder(非线程安全)代替
		StringBuilder strBuilder = null;

		// 对象使用完毕，应手动置成null

		// lazy loading
		// int i = 0;
		// String str = "aaa";
		// if (i == 1) {
		// strL.add(str);
		// }

		int i = 0;
		if (i == 1) {
			String str = "aaa";
			strL.add(str);
		}

		// 异常只能用于错误处理，不应该用来控制程序流程
		// 尤其注意不要在循环中使用：try...catch...

	}
}
