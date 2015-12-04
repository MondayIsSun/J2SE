package test.innerClass;

//��� this �� super �ı���
// ++a �Ƿ��ؼ�֮��Ľ����ȷʵa������1�ˣ�ֻ���������������ô���صĶ��ѣ�����������
//���final,static

public class Outer {

	private int size = 0;

	public class Inner {

		private int size = 3;

		public void doStuff(int size) {
			System.out.println(++size);
			System.out.println(++this.size);
			System.out.println(++Outer.this.size);
		}
	}

	public static void main(String[] args) {

		Outer out = new Outer();
		Outer.Inner inner = out.new Inner();
		inner.doStuff(-1);

	}

}