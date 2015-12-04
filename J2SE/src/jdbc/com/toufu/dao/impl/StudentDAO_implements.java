package jdbc.com.toufu.dao.impl;

import java.sql.Connection;
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

public class StudentDAO_implements implements StudentDao_interface {

	// private DBUtil dbUtil = null;

	private DateFormat dateFormat = null;

	/*
	 * 学会各种数据的格式化操作
	 * 
	 * 时间的格式化操作
	 * 
	 * sql语句的格式化操作
	 */

	public StudentDAO_implements() {
		// dbUtil = new DBUtil();
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	}

	private boolean optStudent(String sql) {

		Connection conn = DBUtil.getConn();

		Statement stat = null;

		boolean flag = false;

		try {

			stat = conn.createStatement();

			int result = stat.executeUpdate(sql);

			if (result > 0)
				flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stat, conn);
		}

		return flag;
	}

	@Override
	public boolean addStudent(StudentPO student) {

		String sql = "insert into student values(''{0}'',''{1}'',''{2}'')";

		sql = MessageFormat.format(sql,
				new Object[] { student.getStu_no(), student.getStu_name(),
						dateFormat.format(student.getStu_birthday()) });

		return optStudent(sql);

	}

	@Override
	public boolean delStudent(String stu_no) {

		String sql = "delete from student where stu_no = ''{0}''";

		sql = MessageFormat.format(sql, new Object[] { stu_no });

		return optStudent(sql);
	}

	@Override
	public boolean uptStudent(StudentPO student) {

		String sql = "update student set stu_name = ''{0}'' where stu_no = ''{1}''";

		sql = MessageFormat.format(sql, new Object[] { student.getStu_name(),
				student.getStu_no() });

		return optStudent(sql);
	}

	@Override
	public StudentPO getStudent(String stu_no) {

		StudentPO stu = null;

		Connection conn = DBUtil.getConn();

		Statement stat = null;

		ResultSet rs = null;

		String sql = "select * from student where stu_no = ''{0}''";

		sql = MessageFormat.format(sql, new Object[] { stu_no });

		try {

			stat = conn.createStatement();

			rs = stat.executeQuery(sql);
			if (rs.next())
				stu = new StudentPO(rs.getString("stu_no"),
						rs.getString("stu_name"), rs.getDate("stu_birthday"));

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

			while (rs.next()) {
				stu = new StudentPO(rs.getString("stu_no"),
						rs.getString("stu_name"), rs.getDate("stu_birthday"));
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
