package collectionFrame.E_SortCollect;

import java.util.Set;
import java.util.TreeSet;

public class B_TreeSetTest {

	public static void main(String[] args) {
		
		//��������
		Set<String> strSet = new TreeSet<String>();
		
		//��������������(��Ĭ������ʽ�ǰ�����Ȼ˳�򣬼�����)
		strSet.add("c");
		strSet.add("a");
		strSet.add("d");
		strSet.add("b");
		strSet.add("e");
		//���򼯺ϲ��ܼ���NULLԪ�أ���ΪNULLԪ�ز�������
		//strSet.add(null);//�ᱨ��
		System.out.println(strSet);
	
		
		
		
		
		Set<C_student> stuSet = new TreeSet<C_student>();
		
		C_student stu_5 = new C_student();
		stu_5.setId(5);
		stu_5.setName("a");
		
		C_student stu_1 = new C_student();
		stu_1.setId(1);
		stu_1.setName("e");
		
		C_student stu_3 = new C_student();
		stu_3.setId(3);
		stu_3.setName("b");
		
		C_student stu_4 = new C_student();
		stu_4.setId(4);
		stu_4.setName("d");
		
		C_student stu_2 = new C_student();
		stu_2.setId(2);
		stu_2.setName("c");
		
		stuSet.add(stu_3);
		stuSet.add(stu_4);
		stuSet.add(stu_2);
		stuSet.add(stu_5);
		stuSet.add(stu_1);
		
		System.out.println(stuSet);
	}

}