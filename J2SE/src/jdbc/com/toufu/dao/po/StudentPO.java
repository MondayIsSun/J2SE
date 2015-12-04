package jdbc.com.toufu.dao.po;

import java.util.Date;

public class StudentPO {

	private String stu_no;
	
	private String stu_name;
	
	private Date stu_birthday;
	
	
	
	public StudentPO() {
		
	}
	
	public StudentPO(String stu_no, String stu_name, Date stu_birthday) {
		this();
		this.stu_no = stu_no;
		this.stu_name = stu_name;
		this.stu_birthday = stu_birthday;
	}
	
	public String getStu_no() {
		return stu_no;
	}
	
	public void setStu_on(String stu_on) {
		this.stu_no = stu_on;
	}
	
	public String getStu_name() {
		return stu_name;
	}
	
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	
	public Date getStu_birthday() {
		return stu_birthday;
	}
	
	public void setStu_birthday(Date stu_birthday) {
		this.stu_birthday = stu_birthday;
	}
}
