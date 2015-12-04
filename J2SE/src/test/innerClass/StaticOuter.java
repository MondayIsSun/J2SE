package test.innerClass;

/**
 * ���ó��Ľ�����
 * 
 * 1����̬�ڲ���ֻ�ܷ����ⲿ�ྲ̬�Ķ�������ͨ�ڲ�����Է����ⲿ�����еĶ���
 * 
 * 2����̬�ڲ������ӵ���Լ���̬�Ķ�������ͨ�ڲ���ֻ��ӵ�зǾ�̬�Ķ���
 * 
 * �����ǣ�������ǵ��ڲ�����������ڿ��ܻ���ⲿ�೤�Ļ�Ӧ�ÿ���ʹ�þ�̬�ڲ������������ ---> ��Ϊ��̬�ڲ��಻������ⲿ�������
 * 
 */

public class StaticOuter {

	// ��̬����
	// ��Ȼ��̬����һ����public����
	private static String name;

	public int age;

	public static void printSomething() {

	}

	public void happyBird() {

	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// ��̬�ڲ��� static inner classes
	// ֻ�ܷ����ⲿ��ľ�̬��Ա�����뾲̬����
	public static class StaticInner {

		// ��̬�ڲ���ֻ�ܷ����ⲿ�ྲ̬���򣬲��ܷ����ⲿ��ĳ�Ա����(��Ա�����Ƕ���ʱ�ڲž��еĶ���)
		// --->
		// ����ֱ�ӵ����˾�̬�ڲ��಻������ⲿ�������,��Ϊ������ʵ��ⲿ������ԣ�Ҳ����˵��ʱ�򲻻�����ⲿ���ĳ��instance�����ԣ�����û�б�Ҫ�����ⲿ���������
		// ---> ���������ڴ�й¶

		// ��Ȼ��̬�ڲ���Ҳ��һ���࣬Ҳ�ǿ������Լ�����Ķ�����

		// ��̬�ڲ������������̬�ĳ�Ա�������������ڲ��಻����
		public static boolean sex;

		// ��̬�ڲ�������о�̬�Ķ��� ---> ��̬�����Ժͷ���
		public static void saySomthing() {

		}

		private String myName;
		public int myAge;

		public void testM() {

			// ++++++++++++++++++++++++++++++++++++++++++++++++++++++

			// ����this����Ͳ��Ǿ�̬�Ķ�������������ط������Ǻ�������
			// StaticOuter.this.name = this.myName;
			// ȷʵ��̬�ڲ�����Է����ⲿ�ྲ̬�Ķ���
			name = myName;
			// ȷʵ��̬�ڲ���û�а취�����ⲿ��Ǿ�̬�Ķ���
			// age

			printSomething();
			// happyBird();

			// ++++++++++++++++++++++++++++++++++++++++++++++++++++++

		}
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// ��Ա�ڲ��� member inner classes
	public class InnerClass {

		// �Ǿ�̬�ڲ��಻���Կ���������̬�ĳ�Ա����
		// public static boolean sex;

		// ͬ���ģ���ͨ�ڲ���Ҳ�ǲ���������̬�ķ�����
		// public static void saySomthing() {
		// }

		// ��Ȼ��ͨ���ڲ���Ҳ�ǿ������Լ��Ķ����ģ�ֻ��������������Ǿ�̬��
		private String myName;
		public int myAge;

		public void doSomething() {

			// ��ͨ�ڲ�����Է����ⲿ�ྲ̬�Ķ��� ---> ��̬����&��̬����
			StaticOuter.this.name = "";
			StaticOuter.name = "";
			StaticOuter.printSomething();

			// ��ͨ�ڲ�����Է����ⲿ��Ǿ�̬�Ķ��� ---> ����&����
			StaticOuter.this.age = 10;
			StaticOuter.this.happyBird();

		}

	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// �ⲿ���һ����Ա����
	public void execute() {

		final int a = 1;
		//a = 2;

		// �����ֲ��ڲ���
		// �����ھֲ����������ܶ���Ϊpublic��protected��private����static���͡�
		// ���巽���У�ֻ�ܷ��ʸ÷���������Ϊfinal���͵ı����� ---> �ڲ���ıհ� ---> ԭ�����ڲ�����������ڿ��ܻ�����ڵķ�����
		// ---> ���Բ��ܷ��ʷ������в���final���εĶ���
		@SuppressWarnings("hiding")
		class InnerClass {
			public void execute() {
				System.out.println("LocalInner Class");
				// �ֲ��ڲ���ֻ�ܷ���final���͵ı���
				System.out.println(a);
			}
		}

		// ֻ�������ڷ������򴴽�
		new InnerClass().execute();
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	// �����ڲ��� ---> ��ʵ�;ֲ��ڲ��౾����һ���� ---> ֻ����������ڲ�����û��Ӧ��ָ��� ---> �Ӷ���������������ֻ�ᱻʹ��һ��
	// ---> û������ָ��Ķ����GC��
	// ��ξ����ڴ������������ʱ������ǽӿ�ѽ�ȵ�������ֱ��������ʵ���˽ӿڵ�������
	// ͬ��Ҳֻ�ܷ��ʸ÷����ڲ���final���͵ı���
	
	/*
	 button.addActionListener(new ActionListener(){
		//ʵ�ֽӿ��еķ���
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("ʹ�������ڲ���ʵ��ActionListener�ӿ�");
		}
	 });
	 */

	public static void main(String[] args) {

		StaticOuter out = new StaticOuter();

		// ��ͨ�ڲ������Ĵ���
		InnerClass innerClass = out.new InnerClass();

		// ��̬�ڲ������Ĵ��� ---> ��̬�Ķ������������� ---> ��̬�Ķ������ǿ�������.������
		StaticInner staticInner = new StaticOuter.StaticInner();
	}

}
