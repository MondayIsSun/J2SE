package test.reflect;

public class Foo {

	public String name;
	public String sex;

	private String log;

	public Foo() {
		System.out.println("Foo���޲ι��캯��...");
	}

	public Foo(String name, String sex) {
		this.name = name;
		this.sex = sex;
		System.out.println("Food���вι��캯��...");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public static String myMethod(String name, int age) {
		System.out.println("����ô���õ���? name = " + name + "  age = " + age);
		return "hahah";
	}

}
