package collectionFrame.D_OldCollect;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class B_HashTableTest {
	
	//HashTable是老集合里面的内容，用法和HashMap一模一样,所以代码直接从HashMapTest中拷贝过来

	public static void main(String[] args) {
		
		//创建容器
		Map<String, String> strMap = new Hashtable<String, String>();
		
		
		//往容器里加入对象
		strMap.put("1","value1");
		strMap.put("2", "value2");
		//strMap.put(null, "空键1");
		//strMap.put(null, "空键2");
		//strMap.put("空值",null);
		//strMap.put("空值2",null);
		strMap.put("3", "value3");
		strMap.put("1", "最后添加的键1内容");
		System.out.println(strMap);
		System.out.println(strMap.size());
		
		
		//通过键取出集合里面的对象
		String string_1 = (String)strMap.get("1");
		System.out.println(string_1);
		
		
		//通过键值删除集合中的对象
		strMap.remove("2");
		System.out.println(strMap);
		System.out.println(strMap.size());
		
		
		//三种方式迭代集合
		A_student student_1 = new A_student();
		student_1.setId(1);
		student_1.setName("student_1");
		
		A_student student_2 = new A_student();
		student_2.setId(2);
		student_2.setName("student_2");
		
		A_student student_3 = new A_student();
		student_3.setId(3);
		student_3.setName("student_3");
		
		A_student student_4 = new A_student();
		student_4.setId(4);
		student_4.setName("student_4");
		
		Map<String, A_student> studentMap = new HashMap<String, A_student>();
		studentMap.put("1", student_1);
		studentMap.put("2", student_2);
		studentMap.put("3", student_3);
		studentMap.put("4", student_4);
		System.out.println(studentMap);
		System.out.println(studentMap.size());
		
	
	}

}
