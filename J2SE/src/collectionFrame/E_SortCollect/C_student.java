package collectionFrame.E_SortCollect;

public class C_student implements Comparable<C_student>{
	
	private String name;
	private int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	@Override
	public int hashCode() {
		return this.id;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof C_student){
			C_student s=(C_student)obj;
			if(s.id==this.id && s.name.equals(this.name))
				return true;
			else 
				return false;
		}
		else
			return false;
	}
	
	@Override
	public int compareTo(C_student otherStudent) {
		//return -(this.id-otherStudent.id);
		return -(this.name.compareTo(otherStudent.name));//因为字符串已经实现了比较
	}
	
	@Override
	public String toString() {
		return this.id+"="+this.name;
	}
	
	
	
}
