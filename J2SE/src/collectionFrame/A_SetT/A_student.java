package collectionFrame.A_SetT;

public class A_student {

	// 属性
	private String name;
	private int id;

	// 构造方法
	public A_student() {
		super();
	}

	// get、set原则
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return this.id;
	}

	// @Override
	// public int hashCode() {
	// // TODO Auto-generated method stub
	// return super.hashCode();
	// }
	// 对象的哈希码是指对象在被创建的时候都会将对象的内部位置转化为一个整数来实现的
	// 这样保证每个对象的哈希值不一样...从而可以达到唯一标识一个对象的效果...
	// 实际上用Object身上的equals()方法进行比较两个对象是否相等时就是在比较这两个对象的哈希码是否相等

	/*
	 * 在Java的set这一容器中,因为set下面的子类都是不允许重复的,所以就有必要实现对象间的比较方法
	 * 又因为原生的equals()方法不能达到比较两个对象是否相等的效果,所以常常有必要去重写对象身上的equals()方法
	 * 又因为在调用对象的equals()方法一般都会使用到对象的哈希值进行比较...而每个对象的哈希值是唯一的,
	 * 所以用哈希值进行比较两个对象相等就等同于用对象的句柄比较大小,这是达不到效果的
	 * 所以常常有必要去重写对象身上hashCode()方法...重写的原则是:对象equals必然有相等的hash值,
	 * hash值相等的对象不一定equals... 这样重写过了equals()和hashCode()方法的对象在比较时的效率也提高了...
	 * 因为传统的比较方法是把每个对象身上所有的属性进行比较看是否相等,这样比较效率很低
	 */

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof A_student) {
			// instanceof操作符是判断是否是某个类的实例
			A_student s = (A_student) obj;
			if (s.id == this.id && s.name.equals(this.name))
				return true;
			else
				return false;
		} else
			return false;
	}

	// @Override
	// public boolean equals(Object obj) {
	// // TODO Auto-generated method stub
	// return super.equals(obj);
	// 注意到:原生的equals方法实际上只是单单比较两个对象的句柄是否相等,这样比较出来肯定是不相等的,因为对象的句柄实际上就是代表其在内存中的唯一位置,肯定不相等
	// 所以常常有必要去重写对象身上的equals()方法,还需要注意的是:String这一对象身上的equals方法已经是重写过的了...
	// }

	@Override
	public String toString() {
		return this.id + "=" + this.name;
	}

}
