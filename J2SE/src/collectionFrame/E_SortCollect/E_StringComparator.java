package collectionFrame.E_SortCollect;

import java.util.Comparator;

public class E_StringComparator implements Comparator<String> {
	@Override
	public int compare(String str_1, String str_2) {
		return -(str_1.compareTo(str_2));
	}
}
