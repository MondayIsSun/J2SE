package jdbc.com.toufu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jdbc.com.toufu.dao.DBUtil;
import jdbc.com.toufu.dao.StudentDao_interface;
import jdbc.com.toufu.dao.po.StudentPO;

public class StudentDAO_implements_2 implements StudentDao_interface {
	

	// private DBUtil dbUtil = null;
	
	@SuppressWarnings("unused")
	private DateFormat dateFormat = null;
	/*
	 * 学会各种数据的格式化操作
	 * 
	 * 时间的格式化操作
	 * 
	 * sql语句的格式化操作
	 */
	
	public StudentDAO_implements_2(){
		// dbUtil = new DBUtil();
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	}
	
	private boolean optStudent(String sql,Object[] arr) {
		
		Connection conn = DBUtil.getConn();
		
		PreparedStatement preStat = null;

		boolean flag = false;

		try {

			//先进行SQL语句的预处理
			preStat = conn.prepareStatement(sql);
			
			for(int i=0;i<arr.length;i++){
				preStat.setObject(i+1, arr[i]);
			}

			//预处理后就可以执行SQL语句进行数据库访问了
			int result = preStat.executeUpdate();

			if (result > 0)
				flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(preStat, conn);
		}

		return flag;
	}

	@Override
	public boolean addStudent(StudentPO student) {
		
		String sql = "insert into student values(?,?,?)";
		
		Object [] arr = new Object[3];
		
		arr[0] = student.getStu_no();
		arr[1] = student.getStu_name();
		arr[2] = student.getStu_birthday();
		
		return optStudent(sql,arr);
		
	}
	
	@Override
	public boolean delStudent(String stu_no) {
		
		String sql = "delete from student where stu_no = ? ";
		
		Object[] arr = new Object[1];

		arr[0] = stu_no;
		
		return optStudent(sql,arr);
	}

	@Override
	public boolean uptStudent(StudentPO student) {

		String sql = "update student set stu_name = ? where stu_no = ? ";

		Object[] arr = new Object[2];

		arr[0] = student.getStu_name();

		arr[1] = student.getStu_no();

		return optStudent(sql, arr);
	}

	@Override
	public StudentPO getStudent(String stu_no) {
		
		StudentPO stu = null;
		
		Connection conn = DBUtil.getConn();

		Statement stat = null;
		
		ResultSet rs = null;
		
		String sql = "select * from student where stu_no = ''{0}''";
		
		sql = MessageFormat.format(sql, new Object[]{stu_no});

		try {

			stat = conn.createStatement();

			rs = stat.executeQuery(sql);
			if(rs.next())
				stu = new StudentPO(rs.getString("stu_no"), rs.getString("stu_name"), rs.getDate("stu_birthday"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stat, conn);
		}

		return stu;
	}

	@Override
	public List<StudentPO> getStudents() {
		
		List<StudentPO> list = new ArrayList<StudentPO>();
		
		Connection conn = DBUtil.getConn();

		Statement stat = null;
		
		ResultSet rs = null;
		
		StudentPO stu = null;
		
		String sql = "select * from student";

		try {

			stat = conn.createStatement();

			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				stu = new StudentPO(rs.getString("stu_no"), rs.getString("stu_name"), rs.getDate("stu_birthday"));
				list.add(stu);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stat, conn);
		}

		return list;
	}

}
