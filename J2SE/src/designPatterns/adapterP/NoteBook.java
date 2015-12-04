package designPatterns.adapterP;

public class NoteBook {

	/*
	 * �ʼǱ���Ҫʹ�������ڵĲ������г�磬��������ֻ��������ڵĲ���
	 * 
	 * ����Ҫʹ�õ�������ڵ���������������ڵ�ת����������ڵ�
	 */

	private ThreePlugIf plug;

	public NoteBook(ThreePlugIf plug) {
		this.plug = plug;
	}

	// ʹ�ò������
	public void charge() {
		plug.powerWithThree();
	}

	public static void main(String[] args) {

		GBTwoPlug two = new GBTwoPlug();
		ThreePlugIf three = new TwoPlugAdapter(two);
		NoteBook nb = new NoteBook(three);
		nb.charge();

		three = new TwoPlugAdapterExtends();
		nb = new NoteBook(three);
		nb.charge();

	}

}
