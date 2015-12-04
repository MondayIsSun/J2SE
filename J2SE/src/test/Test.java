package test;

public class Test {

	public static void main(String[] args) {

		// 尝试创建对象的代码演示
		// 重要的知识点其实是使用你的try...catch 来精确捕捉你的异常，而不是在一个大范围里面进行异常捕获

		int[] intArray = { 0, 0, 0, 0, 0, 0, 1 };
		int result = -1;

		int i = 0;
		for (i = 0; i < intArray.length; i++) {
			try {
				result = 2 / intArray[i];
				// beak语句的作用是第一次创建成功就可以不再循环创建了
				break;
			} catch (Exception e) {
				// 不处理异常
			}
		}
		System.out.println(result != -1 ? "创建成功！" : "创建失败！");
	}
}
