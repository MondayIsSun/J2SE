package collectionFrame.B_ListT;

import java.util.*;

public class D_LinkedList_listIterator_Test {

	public static void main(String[] args) {
		
		//����LinkedList����
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
		
		//��ȡ�������������������(ע�����۵�����˫��������տ�ʼ��ԶĬ�϶��Ǵ����ڼ��ϵĵ�һ��λ��)
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			Object x = iterator.next();
			System.out.print(x+"\t");
		}
		
		System.out.println();
		
		//��ȡ˫���������˫���������
		ListIterator<Integer> R_listiterator = list.listIterator(list.size());//������ָ�����һ��Ԫ��λ��
		while(R_listiterator.hasPrevious()){
			Object obj = R_listiterator.previous();
			System.out.print(obj+"\t");
		}
		
		System.out.println();
		
		ListIterator<Integer> L_listiterator = list.listIterator();//Ĭ�ϵ�˫���������ʼ����ָ��һ��Ԫ��λ��
		while(L_listiterator.hasNext()){
			Object obj = L_listiterator.next();
			System.out.print(obj+"\t");
		}

		
	}

}
