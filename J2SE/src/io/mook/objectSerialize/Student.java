package io.mook.objectSerialize;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student implements Serializable {

	private String stuno;
	private String stuname;

	/**
	 * �����������ģ�
	 * 
	 * 1���Ժ������ǿ��ܻ�Ѷ��������統�д��䣬
	 * 
	 * ������������ͺ��Ӵ󣬶��Ҳ����Ƕ����ϵ����ж�����Ҫ����
	 * 
	 * �Ϳ���ʹ��transient�ؼ��ֱ����Ҳ����л��������
	 * 
	 * 2������һ��������Ҳ���Ҫjvm�������л����������Լ�ʵ����������л�
	 * 
	 * ����ArrayList�ײ�Դ�뵱�У����ȣ�ArrayList�����һЩ�����ǿ������л��ģ�
	 * 
	 * ����ArrayList���е�������ԣ�������ݵ������ǲ�����JVM�����л��ģ���Ϊ�������û��Ԫ�ػ���Ԫ�ز���(��Ȼ���˾͵�������)
	 * 
	 * ��ô��������л���������ЧԪ�ص����л���������Ҫ�����Լ������������Ե����л�����������JVM���������л���
	 * 
	 * ����˵��transient�ǻ��������߳��������Ч�ʵ�
	 * 
	 * �����Լ�ȥ����ArrayList�ײ��Դ��
	 */

	/**
	 * �������һ��֪ʶ�㵱�����ǻ���Ҫ�˽�ʲô�Ƿ���ǩ��
	 */

	// 1����Ԫ�ز������jvmĬ�ϵ����л�,2�����ǲ�����˵���Ԫ�ؾͲ��ܱ����л���Ҳ�����Լ�������Ԫ�ص����л�
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
		s.defaultWriteObject();// ��jvm��Ĭ�����л���Ԫ�ؽ������л�����
		s.writeInt(stuage);// �Լ����stuage�����л�
	}

	private void readObject(java.io.ObjectInputStream s)
			throws java.io.IOException, ClassNotFoundException {
		s.defaultReadObject();// ��jvm��Ĭ�Ϸ����л���Ԫ�ؽ��з����л�����
		this.stuage = s.readInt();// �Լ����stuage�ķ����л�����
	}
}
