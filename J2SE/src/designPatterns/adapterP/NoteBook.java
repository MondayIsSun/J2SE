package designPatterns.adapterP;

public class NoteBook {

	/*
	 * 笔记本需要使用三相插口的插座进行充电，但是现在只有两个插口的插座
	 * 
	 * 就需要使用到两个插口的适配器把两个插口的转化成三个插口的
	 */

	private ThreePlugIf plug;

	public NoteBook(ThreePlugIf plug) {
		this.plug = plug;
	}

	// 使用插座充电
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
