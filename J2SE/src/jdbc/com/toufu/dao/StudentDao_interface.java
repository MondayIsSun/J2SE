package jdbc.com.toufu.dao;

import java.util.List;

import jdbc.com.toufu.dao.po.StudentPO;

public interface StudentDao_interface {

	// DAO对象是对一张特定表的操作

	public boolean addStudent(StudentPO student);

	public boolean uptStudent(StudentPO student);

	public boolean delStudent(String stu_no);

	public StudentPO getStudent(String stu_no);

	public List<StudentPO> getStudents();
}
