package collectionFrame.B_ListT;

import java.util.*;

public class B_ArrayListTest {

	public static void main(String[] args) {

		// 定义容器
		List<String> list = new ArrayList<String>();

		// 增
		list.add("a");
		list.add(0, "b");
		list.add("c");
		list.add(null);
		list.add(null);
		list.add("c");
		list.add(4, "4");// 通过下标把对象加入集合
		list.add("d");
		System.out.println(list);
		System.out.println(list.size());

		// 改
		list.set(0, "0");
		System.out.println(list);
		System.out.println(list.size());

		// 删
		list.remove(2);// 通过下标删除
		list.remove(null);// 非下标删除(通过内容删除)，只删除第一个null
		// list.remove(null);
		System.out.println("delete~~~");
		System.out.println(list);
		System.out.println(list.size());

		// 查
		System.out.println("search~~~");
		System.out.println(list.get(0));// 通过下标得到集合中的特定对象,此方法只允许通过下标查找
		System.out.println(list.get(2));
		System.out.println(list.get(3));

		System.out.println();
		System.out.println();
		System.out.println();

		// 两种方式迭代

		// 方式1：定义迭代器
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext() == true) {

			Object obj = iterator.next();

			if (obj == "a" || obj == "c") {
				iterator.remove();
				// list.remove(0);
			} else
				System.out.println(obj);
		}

		System.out.println();

		// 方式2：有下标
		// java方式的for循环
		for (String i : list) {
			System.out.println(i);

		}

		int i;
		for (i = 0; i < list.size(); i++) {
			Object obj1 = list.get(i);
			if (obj1 == "d") {
				list.remove(i);
			} else
				System.out.println(obj1);
		}

		/*
		 * 对ArrayList(继承于List这一接口)的总结：
		 * 
		 * 1.有序，即插入顺序
		 * 
		 * 2.允许重复,所以没有必要去重写对象身上的hashCode()和equals()
		 * 
		 * 3.非线程,会出现快速失败异常 4.支持下标索引功能
		 */

	}

}
