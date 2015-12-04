package collectionFrame.F_UtilitiesT;

import java.util.Arrays;
import java.util.List;

public class D_ArraysTest {

	public static void main(String[] args) {

		String[] strArray = { "b", "a", "d", "e", "c" };

		// 使用二分法查找数据
		System.out.println(Arrays.binarySearch(strArray, "e"));
		// 对数组进行排序
		Arrays.sort(strArray);// 如果要反序排序的话还可以传递一个比较器的参数

		// 不能这样打印数组
		System.out.println(strArray);

		for (String str : strArray) {
			System.out.print(str + "\t");
		}
		System.out.println();

		// 比较器参数的使用
		B_StringComparator strComparator = new B_StringComparator();
		Arrays.sort(strArray, strComparator);

		for (String str : strArray) {
			System.out.print(str + "\t");
		}
		System.out.println();

		// 将数组转换为List
		List<String> sList = Arrays.asList(strArray);

		// sList.add("f");//会报错报错的原因是用这样的方式获得的List集合固定大小

		System.out.println(sList + "\t" + sList.size());

	}

}
