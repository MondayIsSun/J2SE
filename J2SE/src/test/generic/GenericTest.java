package test.generic;

//泛型的嵌套
public class GenericTest<T> {

	T stu;

	public static void main(String[] args) {

		GenericTest<Teacher<String>> room = new GenericTest<Teacher<String>>();
		room.stu = new Teacher<String>();
		room.stu.setName("小李子");

		System.out.println(room.stu.getName());

	}

}

class Teacher<T> {

	T name;

	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}
}