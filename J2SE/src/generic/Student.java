package generic;

public class Student<T1, T2> {

	T1 name;
	T2 sex;

	public Student() {
		super();
	}

	public Student(T1 name, T2 sex) {
		super();
		this.name = name;
		this.sex = sex;
	}

	public T1 getName() {
		return name;
	}

	public void setName(T1 name) {
		this.name = name;
	}

	public T2 getSex() {
		return sex;
	}

	public void setSex(T2 sex) {
		this.sex = sex;
	}

	// 注意下面的是泛型方法，不要和泛型，static相混淆了
	@SuppressWarnings("unchecked")
	public static <T> void showInfor(T... a) {
		System.out.println(a);
		return;
	}

}
