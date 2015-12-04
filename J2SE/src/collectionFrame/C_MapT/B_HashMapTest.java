package collectionFrame.C_MapT;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class B_HashMapTest {

	public static void main(String[] args) {
		
		//创建容器
		Map<String, String> strMap = new HashMap<String, String>();
		
		//往容器里加入对象(对象的键和值一起加入，即加入键值对)
		strMap.put("1","value1");
		strMap.put("2", "value2");
		//键的值不可重复,允许空键(键值唯一，否则会出现覆盖情况，这个很好理解)
		strMap.put(null, "空键1");
		strMap.put(null, "空键2");
		//空值可以重复(值可以重复，这个很好理解)
		strMap.put("空值",null);
		strMap.put("空值2",null);
		strMap.put("3", "value3");
		//此处会出现覆盖情况
		strMap.put("1", "最后添加的键1内容");
		System.out.println(strMap);
		System.out.println(strMap.size());
		
		
		//通过键取出集合里面的对象
		String string_1 = strMap.get("1");
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
		
		//方式1,通过获取键的集合来迭代keySet()--->可通过键的方式获取值：
		Set<String> kSet = studentMap.keySet();
		Iterator<String> kIterator =  kSet.iterator();
		while(kIterator.hasNext()) {
			String keyString = (String)kIterator.next();
			A_student stu = (A_student)studentMap.get(keyString);
			System.out.print("key="+keyString+"\t"+"ID="+stu.getId()+"\t"+"name="+stu.getName()+"\r\n");	
		}
		
		//方式2,通过获取值的集合来迭代values()--->不可通过值来获取键：
		Collection<A_student> vCollection = studentMap.values();
		Iterator<A_student> vIterator = vCollection.iterator();
		while(vIterator.hasNext()) {
			A_student vStu = (A_student)vIterator.next();
			System.out.print("ID="+vStu.getId()+"\t"+"name="+vStu.getName()+"\r\n");
		}
		
		//方式3,通过获取键值对来迭代entrySet()：
		Set<?> eSet = studentMap.entrySet();//此泛型是什么意思？
		Iterator<?> eIterator = eSet.iterator();
		while(eIterator.hasNext()){
			@SuppressWarnings("rawtypes")//这句又是什么意思？
			Map.Entry mEntry = (Map.Entry)eIterator.next();
			String key = (String)mEntry.getKey();//此处无需进行强制类型转换
			A_student eStu = (A_student)mEntry.getValue();
			System.out.print("key="+key+"\t"+"ID="+eStu.getId()+"\t"+"name="+eStu.getName()+"\r\n");	
		}
				
	}

}
