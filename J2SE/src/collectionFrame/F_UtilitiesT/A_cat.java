package collectionFrame.F_UtilitiesT;

public class A_cat implements Comparable<A_cat>{
	
	private int ID;
	private String name;
	
	//构造方法
	public A_cat(String name) {
		this.name=name;
	}
	
	//set,get原则
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

	@Override
	public int compareTo(A_cat otherCat) {
		return this.getName().compareTo(otherCat.getName());
	}
	
	

}
