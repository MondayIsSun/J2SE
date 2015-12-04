package io.mook.objectSerialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSeriaDemo1 {

	public static void main(String[] args) throws Exception {

		// ����������л��ͷ����л�

		String file = "demo/obj.dat";

		// ========================================

		// 1.��������л�
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				file));
		Student stu = new Student("10001", "����", 20);
		oos.writeObject(stu);
		oos.flush();
		oos.close();

		// ========================================

		// 2.����ķ����л�
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Student stu1 = (Student) ois.readObject();
		System.out.println(stu1);
		ois.close();

	}

}
