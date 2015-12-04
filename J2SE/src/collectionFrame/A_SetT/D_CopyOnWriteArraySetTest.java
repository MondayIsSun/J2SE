package collectionFrame.A_SetT;

import java.util.concurrent.CopyOnWriteArraySet;
import java.util.Iterator;
import java.util.Set;

public class D_CopyOnWriteArraySetTest {

	public static void main(String[] args) {
		
		A_student student_1=new A_student();
		student_1.setId(1);
		student_1.setName("Alice");
		A_student student_2=new A_student();
		student_2.setId(2);
		student_2.setName("Blice");
		A_student student_3=new A_student();
		student_3.setId(3);
		student_3.setName("Clice");
		A_student student_4=new A_student();
		student_4.setId(4);
		student_4.setName("Dlice");
		A_student student_5=new A_student();
		student_5.setId(1);
		student_5.setName("Alice");
		
		Set<A_student> set=new CopyOnWriteArraySet<A_student>();
		
		set.add(student_4);
		set.add(student_2);
		set.add(student_5);
		set.add(student_1);
		set.add(student_3);
		set.add(student_3);
		
		System.out.println(set.size());
		System.out.println(set);
		
		Iterator<A_student> iterator=set.iterator();

		while(iterator.hasNext()==true){
			
			A_student stu=(A_student)iterator.next();
			
			if(stu.getName().equals("Alice")){			
				set.remove(stu);//��ΪCopyOnWriteArraySet���̰߳�ȫ�ļ��ϣ����Կ�������ɾ�������еĶ���
				
				//iterator.remove();//�˴��ĳ�����û�����
			}

			else
				System.out.print("id = "+stu.getId()+"  "+"name = "+stu.getName()+" "+iterator.hasNext()+"\r\n");
			
		}
		System.out.println(set.size());
		System.out.println(set);
		
		System.out.println(iterator.hasNext());
		System.out.println(iterator.hasNext());
		System.out.println(iterator.hasNext());
		
	}
		
		/*
		 * ��CopyOnWriteArraySet���ܽ᣺
		 * 1.�������ظ�
		 * 2.�е���˳��,�������˳��
		 * 3.�߳�ͬ���ļ��ϣ�ʼ��ӵ�м��ϵ��ǰ���,���Բ�����ֿ���ʧ���쳣,�����߳�ͬ����Ч��һ�㶼����
		 */

}
