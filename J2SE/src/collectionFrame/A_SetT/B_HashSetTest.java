package collectionFrame.A_SetT;

import java.util.*;

public class B_HashSetTest {
	
	/*
	 * set�������ظ��Ĵ�����ʽ:
	 * �����ظ�:�����ǲ������������߼����ظ���...
	 * �߼��ظ�:ָ���������������equals()��ô��������������߼��ظ���
	 * ���ʹ��Object�м̳�������equals()�������бȽ���ô������������Զ�������߼������
	 * ʵ����Object����ԭ����equals()�������õ��˶���Ĺ�ϣֵ
	 * ���Գ���Ա����ȥ��д�����equals()����
	 * ����set�����д����ظ��ķ�������������equals()�Ϳ��Խ��,��Ϊ���set���ϵ�������equals()�������бȽ�Ч��̫��
	 * Ҳ����˵������ƽ���ı�̵��бȽ����������Ƿ����ֻҪ��дequals()�������㹻��
	 * �������������Ҫ�Ž�set�����е�ʱ����Ҫȥ��д�������ϵ�hashCode()����
	 * 
	 * ��ΪJava�����������ʱ������������set�е���ȵ�:
	 * ��HashSet�бȽ����������Ƿ���ȵķ����ǣ��ȱȽ����������hashCode()ֵ�Ƿ���ȣ�
	 * �������Ⱦ���Ϊ���������ǲ���ȵģ�������������hashCode��Ⱦͼ�������equals()������һ���ж����������Ƿ���ȣ�
	 * ���equals()��������true��Ϊ����������ȣ�����false��Ϊ����������ȡ�
	 * 
	 * ��ΪĬ�϶����hashֵ�϶�����ȵ�,�������Ҫ��set������������д�����������ʱ,Ҫȥ��дequals()������ͬʱ����Ҫȥ��дhashCode()����
	 * ��ʱ��дhashCode()������ԭ����---����equals�� Ȼ����ȵĹ�ϣ�룬����ϣ����ȵĶ���һ��equals---
	 */

	public static void main(String[] args) {
		
		A_student student_1=new A_student();//������͹ؼ����غϣ�
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
		
		//����HashSet��һ����
		Set<A_student> hashset=new HashSet<A_student>();
		
		//��������������
		hashset.add(student_1);
		hashset.add(student_2);
		hashset.add(student_3);
		hashset.add(student_4);
		hashset.add(student_5);
		hashset.add(student_4);
		System.out.println(hashset.size());
		System.out.println(hashset);
		
		//����������ĵ�����
		Iterator<A_student> iterator=hashset.iterator();//���������������ĵ����������Ե�����ֱ��ָ����������Ķ���
		
		//��֤�Լ��Ĳ���
		//System.out.println(iterator.hasNext());//iterator.hasNext()�÷������Խ���һ������������ʼ����������ָ��
		//student stud=(student)iterator.next();
		//System.out.print("id = "+stud.getId()+"  "+"name = "+stud.getName()+" "+iterator.hasNext()+"\r\n");
		
		while(iterator.hasNext() == true){
			
			A_student stu=iterator.next();//��Ϊ���˷���,���Դ˴��������ǿ������ת��
			
			//��֤�Լ��Ĳ���
			//System.out.print("id = "+stu.getId()+"  "+"name = "+stu.getName()+" "+iterator.hasNext()+"\r\n");
			
			if(stu.getName().equals("Alice"))//�ַ����Ƚ��Ƿ���ȱ�����equals()����,String����ĺܶ෽��JDK ��д����,����equals()����
				iterator.remove();
			else
				System.out.print("id = "+stu.getId()+"  "+"name = "+stu.getName()+" "+iterator.hasNext()+"\r\n");
			
		}
		System.out.println(hashset.size());
		System.out.println(hashset);
		
		System.out.println(iterator.hasNext());
		System.out.println(iterator.hasNext());
		System.out.println(iterator.hasNext());
		
		/*
		 * ��HashSet���ܽ�
		 * 1.�̳���Set�ӿڣ����Ա�Ȼ���ظ�
		 * 2.����(�˴�������ָ��ͬ��JDK�汾���в�ͬ��˳��)
		 * 3.���߳�ͬ�������Ի���ֿ���ʧ���쳣,����ֱ���õ������е�remove()����ɾ������
		 */
		
	}

}