package collectionFrame.E_SortCollect;

import java.util.TreeMap;

public class A_TreeMapTest {

	public static void main(String[] args) {
		
		TreeMap<String, String> strMap = new TreeMap<String, String>();
		//(默认是)按Key进行排序的(很好理解，值可以重复，Map这种结构最重要的是Key,键值不能加入空),所以键这一对象要实现排序接口
		strMap.put("1", "value_2");
		strMap.put("3", "value_1");
		strMap.put("2", "value_3");
		strMap.put("5", "value_4");
		strMap.put("4", "value_5");
		
		System.out.print(strMap+"\r\n");
	}
}