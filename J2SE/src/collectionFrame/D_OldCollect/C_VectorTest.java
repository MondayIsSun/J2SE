package collectionFrame.D_OldCollect;

import java.util.Enumeration;
import java.util.Vector;

public class C_VectorTest {
	
	//Vector(����)���ϼ������������,��ArrayList���÷���һģһ����,���Դ���ֱ�Ӵ�ArrayListTest�п�������

	public static void main(String[] args) {
		
		//��������
		Vector/*�˴�����ֱ����List���壬��Ϊ�������޷�ָ���������ϵķ���*/<String> list=new Vector<String>();//�������÷���
		
		//��
		list.add("b");
		list.add(0, "a");
		list.add("c");
		list.add(null);
		list.add(null);
		list.add("c");
		//list.add(4, "4");	
		list.add("d");	
		System.out.println(list);
		System.out.println(list.size());
		
		//��
		//list.set(0, "0");
		//System.out.println(list);
		//System.out.println(list.size());
		
		//ɾ
		//list.remove(2);//ͨ���±�ɾ��
		//list.remove(null);//���±�ɾ��(��ͨ������ľ�������ɾ��)
		//list.remove(null);
		//System.out.println(list);
		//System.out.println(list.size());
		
		//��
		System.out.println(list.get(0));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		
		System.out.println();
		
		//���ַ�ʽ����
		
		//��ʽ1����ȡ�ɵ���������
		Enumeration<String> enumeration = list.elements();
		while (enumeration.hasMoreElements()) {
			Object object = (Object) enumeration.nextElement();
			if(object == null){
				list.remove(object);//ͨ������ľ������ݴӼ�����ɾ�����ö���	,������ֿ���ʧ���쳣,���ü���ɾ�����е�С����
			}else
				System.out.print(object+"\t");
			
		}
		System.out.println();
	
		//��ʽ2���µ���������
				/*��Ҫ�ѡ� Vector(�˴�����ֱ����List���壬��Ϊ�������޷�ָ���������ϵķ���) list=new Vector();����һ���Ϊ��
				 * List list=new Vector();
				*/
				/*
				Iterator iterator = list.iterator();//��Ϊû�� <<  java.util.*;  >>�����������
				while(iterator.hasNext() == true){
					
					Object obj = iterator.next();
					
					if(obj == "a" || obj == "c"){
						iterator.remove();
						//list.remove(0);
					}else
					System.out.println(obj);
				}
				*/
		
		//��ʽ3����Ϊ��������ֱ����ѭ������
		int i;
		for(i=0;i<list.size();i++){
			Object obj1 = list.get(i);
			if(obj1 == null){
				list.remove(i);
				i--;//�˾��Ǳ����
			}else
			System.out.print(obj1+"\t");
		}
		


	}

}
