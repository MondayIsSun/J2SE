package collectionFrame.F_UtilitiesT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C_CollectionsTest {

	public static void main(String[] args) {

		List<A_cat> cList = new ArrayList<A_cat>();
		cList.add(new A_cat("加菲猫_1"));
		cList.add(new A_cat("加菲猫_3"));
		cList.add(new A_cat("加菲猫_5"));
		cList.add(new A_cat("加菲猫_2"));
		cList.add(new A_cat("加菲猫_4"));

		System.out.println(Collections.max(cList));// 如果cat类没有实现比较方法，这样操作会保错,
													// 重写cat中的toString方法会比较直观
		System.out.println(Collections.min(cList));

		// 对集合排序，排序是也可以加入比较器
	}
}