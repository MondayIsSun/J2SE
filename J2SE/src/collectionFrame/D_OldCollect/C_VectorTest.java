package collectionFrame.D_OldCollect;

import java.util.Enumeration;
import java.util.Vector;

public class C_VectorTest {
	
	//Vector(有序)是老集合里面的内容,与ArrayList的用法是一模一样的,所以代码直接从ArrayListTest中拷贝过来

	public static void main(String[] args) {
		
		//定义容器
		Vector/*此处不可直接用List定义，因为父类句柄无法指向子类身上的方法*/<String> list=new Vector<String>();//懂得利用泛型
		
		//增
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
		
		//改
		//list.set(0, "0");
		//System.out.println(list);
		//System.out.println(list.size());
		
		//删
		//list.remove(2);//通过下标删除
		//list.remove(null);//非下标删除(即通过对象的具体内外删除)
		//list.remove(null);
		//System.out.println(list);
		//System.out.println(list.size());
		
		//查
		System.out.println(list.get(0));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		
		System.out.println();
		
		//三种方式迭代
		
		//方式1：获取旧迭代器迭代
		Enumeration<String> enumeration = list.elements();
		while (enumeration.hasMoreElements()) {
			Object object = (Object) enumeration.nextElement();
			if(object == null){
				list.remove(object);//通过对象的具体内容从集合里删除掉该对象	,不会出现快速失败异常,但用集合删除会有点小问题
			}else
				System.out.print(object+"\t");
			
		}
		System.out.println();
	
		//方式2：新迭代器迭代
				/*需要把《 Vector(此处不可直接用List定义，因为父类句柄无法指向子类身上的方法) list=new Vector();》这一句改为：
				 * List list=new Vector();
				*/
				/*
				Iterator iterator = list.iterator();//因为没导 <<  java.util.*;  >>这个包而出错
				while(iterator.hasNext() == true){
					
					Object obj = iterator.next();
					
					if(obj == "a" || obj == "c"){
						iterator.remove();
						//list.remove(0);
					}else
					System.out.println(obj);
				}
				*/
		
		//方式3：因为有序，所以直接用循环迭代
		int i;
		for(i=0;i<list.size();i++){
			Object obj1 = list.get(i);
			if(obj1 == null){
				list.remove(i);
				i--;//此句是必须的
			}else
			System.out.print(obj1+"\t");
		}
		


	}

}
