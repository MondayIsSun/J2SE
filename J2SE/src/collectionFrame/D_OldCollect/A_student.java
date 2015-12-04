package collectionFrame.D_OldCollect;

public class A_student {
	
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
		
		if(obj instanceof A_student){
			A_student s=(A_student)obj;
			if(s.id==this.id && s.name.equals(this.name))
				return true;
			else 
				return false;
		}
		else
			return false;
	}
	
}
