package collectionFrame.E_SortCollect;

import java.util.TreeMap;

public class A_TreeMapTest {

	public static void main(String[] args) {
		
		TreeMap<String, String> strMap = new TreeMap<String, String>();
		//(Ĭ����)��Key���������(�ܺ���⣬ֵ�����ظ���Map���ֽṹ����Ҫ����Key,��ֵ���ܼ����),���Լ���һ����Ҫʵ������ӿ�
		strMap.put("1", "value_2");
		strMap.put("3", "value_1");
		strMap.put("2", "value_3");
		strMap.put("5", "value_4");
		strMap.put("4", "value_5");
		
		System.out.print(strMap+"\r\n");
	}
}