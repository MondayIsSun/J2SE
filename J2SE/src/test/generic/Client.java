package test.generic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Client {

	public static void main(String[] args) {

		Set stuSet = new HashSet();

		Student s1 = new Student(100, 90);
		Student s2 = new Student("100", 20);

		Object t = 12;
		System.out.println(t);

		stuSet.add(s1);
		stuSet.add(s2);

		// 确实这个例子当中还不是很好地体现了没有使用泛型的不便之处
		Iterator i = stuSet.iterator();
		while (i.hasNext()) {
			Student s = (Student) i.next();
			// System.out.println(s.getJavaScore());
			// System.out.println(s.getMathScore());
			if (s.getJavaScore() instanceof String) {
				System.out.println("JavaScore ---> String");
			} else {
				System.out.println("JavaScore ---> int");
			}
		}
	}
}

class Student {

	public Object javaScore;
	public Object mathScore;

	Student(Object javaScore, Object mathScore) {
		this.javaScore = javaScore;
		this.mathScore = mathScore;
	}

	Student() {
	}

	Student(Object javascore) {
		this.javaScore = javascore;
	}

	public Object getJavaScore() {
		return javaScore;
	}

	public void setJavaScore(Object javaScore) {
		this.javaScore = javaScore;
	}

	public Object getMathScore() {
		return mathScore;
	}

	public void setMathScore(Object mathScore) {
		this.mathScore = mathScore;
	}

}
