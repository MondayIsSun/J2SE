package collectionFrame.F_UtilitiesT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C_CollectionsTest {

	public static void main(String[] args) {

		List<A_cat> cList = new ArrayList<A_cat>();
		cList.add(new A_cat("�ӷ�è_1"));
		cList.add(new A_cat("�ӷ�è_3"));
		cList.add(new A_cat("�ӷ�è_5"));
		cList.add(new A_cat("�ӷ�è_2"));
		cList.add(new A_cat("�ӷ�è_4"));

		System.out.println(Collections.max(cList));// ���cat��û��ʵ�ֱȽϷ��������������ᱣ��,
													// ��дcat�е�toString������Ƚ�ֱ��
		System.out.println(Collections.min(cList));

		// �Լ�������������Ҳ���Լ���Ƚ���
	}
}