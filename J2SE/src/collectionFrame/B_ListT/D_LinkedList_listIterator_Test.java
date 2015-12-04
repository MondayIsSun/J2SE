package collectionFrame.B_ListT;

import java.util.*;

public class D_LinkedList_listIterator_Test {

	public static void main(String[] args) {
		
		//定义LinkedList集合
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.print(list+"\r\n");
		System.out.println(list.size()+"\r\n");
		
		//获取单向迭代器并迭代集合(注意无论单向还是双向迭代器刚开始永远默认都是存在在集合的第一个位置)
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			Object x = iterator.next();
			System.out.print(x+"\t");
		}
		
		System.out.println();
		
		//获取双向迭代器并双向迭代集合
		ListIterator<Integer> R_listiterator = list.listIterator(list.size());//迭代器指向最后一个元素位置
		while(R_listiterator.hasPrevious()){
			Object obj = R_listiterator.previous();
			System.out.print(obj+"\t");
		}
		
		System.out.println();
		
		ListIterator<Integer> L_listiterator = list.listIterator();//默认的双向迭代器初始化是指向一个元素位置
		while(L_listiterator.hasNext()){
			Object obj = L_listiterator.next();
			System.out.print(obj+"\t");
		}

		
	}

}
