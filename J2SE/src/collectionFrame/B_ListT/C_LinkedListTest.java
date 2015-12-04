package collectionFrame.B_ListT;

import java.util.Iterator;
import java.util.LinkedList;

public class C_LinkedListTest {

	public static void main(String[] args) {
		
		@SuppressWarnings("rawtypes")
		LinkedList<Comparable> list=new LinkedList<Comparable>();//��̬ԭ��һ��Ҫ������������
		
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
		
		list.remove(2);//��2λ�õ�Ԫ��ɾ����,LinkedList�ײ���Ȼ��ͨ������ʵ�ֵ�,���ܶ෽�涼����������
		list.remove(null);//ֻ��ɾ���������ĵ�һ��null,����ѽ������ظ���Ҳɾ����,��һ��ֻɾ��һ��
		list.remove(null);
		System.out.println(list);
		System.out.println(list.size());
		
		System.out.println(list.get(0));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		//LinkedList�ĵ�����ʽҲ��ArrayList��һ��
		@SuppressWarnings("rawtypes")
		Iterator<Comparable> iterator = list.iterator();
		while(iterator.hasNext() == true){
			
			Object obj = iterator.next();
			
			if(obj == "a" || obj == "c"){
				iterator.remove();
				//list.remove(0);
			}else
			System.out.println(obj);
		}
		System.out.println();
		int i;
		for(i=0;i<list.size();i++){
			Object obj1 = list.get(i);
			if(obj1 == "d"){
				list.remove(i);		
			}else
			System.out.println(obj1);
		}
		
		
		
		
		

	}
	
	/*��LinkedList���ܽ�:
	 * 1.���˾���ArrayList�����й�������,LinkedList���ṩ�˲���ͷβ�Ĳ���(LinkedList�ײ���Ȼ��ͨ������ʵ�ֵ�,���ܶ෽�涼����������)��
	 *   һЩ��ջ�йصĴ�������
	 * 2.�̳���List��һ�ӿ�
	 * 3.ʲôʱ����ArrayList?ʲôʱ����LinkedList?
	 *   ��ײ�ʵ���й�,Ҫ֪��ÿһ�����ݽṹ���������õķ�Χ:
	 *   �ײ�������ʵ�ֵ��ʺϽ϶����ɾ�Ĳ���,�ײ�������ʵ�ֵıȽ��ʺϽ϶�Ĳ����
	 * 4.���߳�ͬ��,����ֿ���ʧ���쳣
	 * 5.��������ͨ�ĵ���Iterator�������⻹��listIterator��һ˫�������
	 */

}