package io.mook.objectSerialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSeriaDemo1 {

	public static void main(String[] args) throws Exception {

		// 最基本的序列化和反序列化

		String file = "demo/obj.dat";

		// ========================================

		// 1.对象的序列化
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				file));
		Student stu = new Student("10001", "张三", 20);
		oos.writeObject(stu);
		oos.flush();
		oos.close();

		// ========================================

		// 2.对象的反序列化
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Student stu1 = (Student) ois.readObject();
		System.out.println(stu1);
		ois.close();

	}

}
