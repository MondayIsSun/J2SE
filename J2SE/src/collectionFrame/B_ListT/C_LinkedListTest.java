package collectionFrame.B_ListT;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Predicate;

public class C_LinkedListTest {

	public static void main(String[] args) {

		@SuppressWarnings("rawtypes")
		LinkedList<Comparable> list = new LinkedList<Comparable>();// 多态原理一定要理解得清清楚楚

		list.add("a");
		list.add(0, "b");
		list.add("c");
		list.add(null);
		list.add(null);
		list.add("c");
		list.add(4, 4);
		list.add("d");
		System.out.println(list);
		System.out.println(list.size());

		list.set(0, 0);
		System.out.println(list);
		System.out.println(list.size());

		list.remove(2);// 把2位置的元素删除掉,LinkedList底层虽然是通过链表实现的,但很多方面都和数组相似
		list.remove(null);// 只会删除掉遇到的第一个null,不会把接下来重复的也删除掉,即一次只删除一个
		list.remove(null);
		System.out.println(list);
		System.out.println(list.size());

		System.out.println(list.get(0));
		System.out.println(list.get(2));
		System.out.println(list.get(3));

		System.out.println();
		System.out.println();
		System.out.println();

		// LinkedList的迭代方式也和ArrayList的一样
		@SuppressWarnings("rawtypes")
		Iterator<Comparable> iterator = list.iterator();
		while (iterator.hasNext() == true) {

			Object obj = iterator.next();

			if (obj == "a" || obj == "c") {
				iterator.remove();
				// list.remove(0);
			} else
				System.out.println(obj);
		}
		System.out.println();
		int i;
		for (i = 0; i < list.size(); i++) {
			Object obj1 = list.get(i);
			if (obj1 == "d") {
				list.remove(i);
			} else
				System.out.println(obj1);
		}

	}

	/*
	 * 对LinkedList的总结:
	 * 1.除了具有ArrayList的所有功能以外,LinkedList还提供了操作头尾的操作(LinkedList底层虽然是通过链表实现的,
	 * 但很多方面都和数组相似)和 一些与栈有关的处理操作
	 * 
	 * 2.继承与List这一接口
	 * 
	 * 3.什么时候用ArrayList?什么时候用LinkedList? 与底层实现有关,要知道每一种数据结构都有其适用的范围:
	 * 底层是链表实现的适合较多的增删改操作,底层是数组实现的比较适合较多的查操作
	 * 
	 * 4.非线程同步,会出现快速失败异常 5.除了有普通的单向Iterator迭代器外还有listIterator这一双向迭代器
	 */

}
