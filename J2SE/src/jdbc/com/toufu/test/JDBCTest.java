package jdbc.com.toufu.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {

	/*
	 * ctrl+d��ɾ����ǰ�С� �������һ�е�����ʱ����סshift+home/end����ѡ��ǰ�� ctrl+����������һ�����ʣ�
	 * ctrl+shift+������ѡ��һ�����ʣ���������������ѡ������
	 */

	public static void main(String[] args) {

		// ��ʼ

		// ������Ӧ��jar��

		// ע��:
		// ֻ��JDBC��,������������ݿ�����,���Զ���ԭ����java.sql����Ľӿ�

		// ����MySql���ݿ�
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/javaee-db-test";
		String user = "root";
		String password = "root";

		// ����Oracle���ݿ�
		// String driver = "oracle.jdbc.driver.OracleDriver";
		// String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
		// String user = "scott";
		// String password = "scott";

		try {

			// ע��������
			Class.forName(driver);

			// �������ݿ�
			Connection conn = DriverManager.getConnection(url, user, password);

			// ����������
			Statement stat = conn.createStatement();

			// ����ִ�м������ݿ�Ĳ�����ʱ����Ҫ�������������
			// ResultSet rs = stat.executeQuery("select * from student");

			ResultSet rs = stat.executeQuery("select * from goods");

			while (rs.next()) {
				// System.out.println(rs.getString("stu_no")+"\t"+rs.getString("stu_name")+"\t"+rs.getDate("stu_birthday"));

				System.out.println(rs.getInt("g_id") + "\t" + rs.getInt("u_id")
						+ "\t" + rs.getString("g_name"));

			}

			// stat.executeUpdate("insert into student value('0938298','����','2015-5-21')");

			// �رս��������
			rs.close();

			// �ر����
			stat.close();

			// �ر����Ӷ���
			conn.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
