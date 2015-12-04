package io.mook.objectSerialize;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student implements Serializable {

	private String stuno;
	private String stuname;

	/**
	 * 理由是这样的：
	 * 
	 * 1、以后呢我们可能会把对象在网络当中传输，
	 * 
	 * 如果这个对象本身就很庞大，而且并不是对象上的所有东西都要传输
	 * 
	 * 就可以使用transient关键字表面我不序列化这个东西
	 * 
	 * 2、还有一种情况是我不需要jvm帮我序列化，而是我自己实现这个的序列化
	 * 
	 * 比如ArrayList底层源码当中，首先，ArrayList对象的一些属性是可以序列化的，
	 * 
	 * 但是ArrayList当中的这个属性：存放数据的数组是不能让JVM来序列化的，因为这个可能没有元素或者元素不满(当然满了就得扩容了)
	 * 
	 * 那么这个的序列化必须是有效元素的序列化，所以需要我们自己来完成这个属性的序列化，而不能由JVM帮我们序列化，
	 * 
	 * 所以说，transient是会帮我们提高程序的运行效率的
	 * 
	 * 可以自己去看看ArrayList底层的源码
	 */

	/**
	 * 其次在这一块知识点当中我们还需要了解什么是方法签名
	 */

	// 1、该元素不会进行jvm默认的序列化,2、但是并不是说这个元素就不能被序列化，也可以自己完成这个元素的序列化
	private transient int stuage;

	public Student(String stuno, String stuname, int stuage) {
		super();
		this.stuno = stuno;
		this.stuname = stuname;
		this.stuage = stuage;
	}

	public String getStuno() {
		return stuno;
	}

	public void setStuno(String stuno) {
		this.stuno = stuno;
	}

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public int getStuage() {
		return stuage;
	}

	public void setStuage(int stuage) {
		this.stuage = stuage;
	}

	@Override
	public String toString() {
		return "Student [stuno=" + stuno + ", stuname=" + stuname + ", stuage="
				+ stuage + "]";
	}

	private void writeObject(java.io.ObjectOutputStream s)
			throws java.io.IOException {
		s.defaultWriteObject();// 把jvm能默认序列化的元素进行序列化操作
		s.writeInt(stuage);// 自己完成stuage的序列化
	}

	private void readObject(java.io.ObjectInputStream s)
			throws java.io.IOException, ClassNotFoundException {
		s.defaultReadObject();// 把jvm能默认反序列化的元素进行反序列化操作
		this.stuage = s.readInt();// 自己完成stuage的反序列化操作
	}
}
