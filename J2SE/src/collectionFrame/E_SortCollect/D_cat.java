package collectionFrame.E_SortCollect;

public class D_cat {
	
	private int ID;
	private String name;
	
	//构造方法
	public D_cat(String name) {
		this.name=name;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	

}
