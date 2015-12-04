package jdbc.com.toufu.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {

	/*
	 * ctrl+d是删除当前行。 当光标在一行的两端时，按住shift+home/end可以选择当前行 ctrl+左右是跳过一个单词，
	 * ctrl+shift+左右是选择一个单词，可以连点左右已选择多个。
	 */

	public static void main(String[] args) {

		// 开始

		// 导入相应的jar包

		// 注意:
		// 只跟JDBC连,不跟具体的数据库连接,所以都用原生的java.sql下面的接口

		// 链接MySql数据库
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/javaee-db-test";
		String user = "root";
		String password = "root";

		// 链接Oracle数据库
		// String driver = "oracle.jdbc.driver.OracleDriver";
		// String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
		// String user = "scott";
		// String password = "scott";

		try {

			// 注册驱动类
			Class.forName(driver);

			// 链接数据库
			Connection conn = DriverManager.getConnection(url, user, password);

			// 创建语句对象
			Statement stat = conn.createStatement();

			// 当有执行检索数据库的操作的时候需要创建结果集对象
			// ResultSet rs = stat.executeQuery("select * from student");

			ResultSet rs = stat.executeQuery("select * from goods");

			while (rs.next()) {
				// System.out.println(rs.getString("stu_no")+"\t"+rs.getString("stu_name")+"\t"+rs.getDate("stu_birthday"));

				System.out.println(rs.getInt("g_id") + "\t" + rs.getInt("u_id")
						+ "\t" + rs.getString("g_name"));

			}

			// stat.executeUpdate("insert into student value('0938298','哈哈','2015-5-21')");

			// 关闭结果集对象
			rs.close();

			// 关闭语句
			stat.close();

			// 关闭连接对象
			conn.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
