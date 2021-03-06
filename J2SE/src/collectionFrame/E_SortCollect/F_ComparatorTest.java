package collectionFrame.E_SortCollect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class F_ComparatorTest {

	public static void main(String[] args) {
		
		E_StringComparator strComparator = new E_StringComparator();
		
		Set<String> strSet = new TreeSet<String>(strComparator);
		
		strSet.add("a");
		strSet.add("c");
		strSet.add("b");
		strSet.add("e");
		strSet.add("d");
		
		System.out.println(strSet);
		
		List<D_cat> catlist = new ArrayList<D_cat>();//并不是所有的集合都可以接受比较器这一参数
		catlist.add(new D_cat("加菲_3"));
		catlist.add(new D_cat("加菲_2"));
		catlist.add(new D_cat("加菲_4"));
		catlist.add(new D_cat("加菲_1"));
		catlist.add(new D_cat("加菲_5"));
		
		//并不是所有的集合都可以接受比较器这一参数,所以需要Collections这一Java提供的工具类
		Collections.sort(catlist,new Comparator<D_cat>() {
			@Override
			public int compare(D_cat cat_1, D_cat cat_2) {
				return cat_1.getName().compareTo(cat_2.getName());
			}
		});
		System.out.println(catlist);
	}
}
