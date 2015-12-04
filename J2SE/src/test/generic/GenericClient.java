package test.generic;

public class GenericClient {

	public static void main(String[] args) {

		// 这个时候我是在使用泛型
		Child<String, Integer> c1 = new Child<String, Integer>();

		// 接下来写的代码会自定地进行泛型检查
		// 从而没有必要进行类型的转换，也不需要进行类型的判断，自动拆箱装箱机制
		c1.setJavaScore("79");// 类型检查
		c1.setMathScore(new Integer(86));// 发生类型检查

		String jc = c1.getJavaScore();// 发生类型检查
		c1.setMathScore(87);// 这个地方发生自动装箱
		int mc = c1.getMathScore();// 这个地方发生自动拆箱

		System.out.println(jc + "   " + mc);
	}
}

// 这个时候我是在定义泛型
class Child<T1, T2> {

	public T1 javaScore;
	public T2 mathScore;

	public T1 getJavaScore() {
		return javaScore;
	}

	public void setJavaScore(T1 javaScore) {
		this.javaScore = javaScore;
	}

	public T2 getMathScore() {
		return mathScore;
	}

	public void setMathScore(T2 mathScore) {
		this.mathScore = mathScore;
	}
}
