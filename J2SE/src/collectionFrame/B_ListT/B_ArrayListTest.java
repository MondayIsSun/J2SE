package collectionFrame.B_ListT;

import java.util.*;

public class B_ArrayListTest {

	public static void main(String[] args) {
		
		//��������
		List<String> list=new ArrayList<String>();
		
		//��
		list.add("a");
		list.add(0, "b");
		list.add("c");
		list.add(null);
		list.add(null);
		list.add("c");
		list.add(4, "4");//ͨ���±�Ѷ�����뼯��
		list.add("d");
		System.out.println(list);
		System.out.println(list.size());
		
		//��
		list.set(0,"0");
		System.out.println(list);
		System.out.println(list.size());
		
		//ɾ
		list.remove(2);//ͨ���±�ɾ��
		list.remove(null);//���±�ɾ��(ͨ������ɾ��)
		//list.remove(null);
		System.out.println(list);
		System.out.println(list.size());
		
		//��
		System.out.println(list.get(0));//ͨ���±�õ������е��ض�����,�˷���ֻ����ͨ���±����
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//���ַ�ʽ����
		
		    //��ʽ1�����������
			Iterator<String> iterator = list.iterator();
			while(iterator.hasNext() == true){
				
				Object obj = iterator.next();
				
				if(obj == "a" || obj == "c"){
					iterator.remove();
					//list.remove(0);
				}else
				System.out.println(obj);
			}
			
			System.out.println();
			
			//��ʽ2�����±�
			//java��ʽ��forѭ��
			for(String i:list){
				System.out.println(i);
				
			}
			
			int i;
			for(i=0;i<list.size();i++){
				Object obj1 = list.get(i);
				if(obj1 == "d"){
					list.remove(i);		
				}else
				System.out.println(obj1);
			}
		
		/*
		 * ��ArrayList(�̳���List��һ�ӿ�)���ܽ᣺
		 * 1.���򣬼�����˳��
		 * 2.�����ظ�,����û�б�Ҫȥ��д�������ϵ�hashCode()��equals()
		 * 3.���߳�,����ֿ���ʧ���쳣
		 * 4.֧���±���������
		 */
		
	}

}